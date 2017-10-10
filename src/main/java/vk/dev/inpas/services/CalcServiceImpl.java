package vk.dev.inpas.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by vk on 18.03.2017
 */
@Slf4j
@Service
public class CalcServiceImpl implements CalcService {

    private static final String INVALID_INPUT_REGEX = "[^,\\d]|,{2,}";

    @Override
    public Integer calc(List<Integer> src) {
        return calculate(src);
    }

    @Override
    public Integer calc(String src) {
        List<Integer> list = null;
        try {
            list = parse(src);
        } catch (Exception e) {
            log.error("Failed to parse input string", e);
        }
        return calc(list);
    }

    @Override
    public String validate(String input) {
        if (StringUtils.isEmpty(input)) return "Empty input!";

        Pattern p = Pattern.compile(INVALID_INPUT_REGEX);
        Matcher m = p.matcher(input);
        if (m.find()) return "Invalid input characters!";

        return null;
    }


    ///////////////////////////////////////
    // PRIVATE
    ///////////////////////////////////////

    private List<Integer> parse(String src) {
        return Arrays.stream(src.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * Algorithm: <br>
     * 0. start with left peek at index 0 <br>
     * 1. find the next adjacent peeks <br>
     * 2. calculate sum between them <br>
     * 3. repeat steps 1-2 till the end of list <br>
     */
    private Integer calculate(List<Integer> src) {
        if (CollectionUtils.isEmpty(src)) return null;

        int result = 0;

        int left = 0;
        int prev = src.get(left);
        for (int i = 1; i < src.size(); i++) {

            // if we reached the end of the list
            // then try to calculate sum and exit
            if (i == src.size() - 1) {
                result += sumUp(src.subList(left, i + 1));
                break;
            }

            int curr = src.get(i);
            int next = src.get(i + 1);

            // find next peek
            // and calculate sum between left and right peeks
            if (curr > prev && curr > next) {
                result += sumUp(src.subList(left, i + 1));
                left = i;
            }
            prev = curr;
        }
        return result;
    }

    /**
     * Calculate sum between two adjacent peeks
     *
     * @param integers subList between two peeks
     * @return sum between two adjacent peeks
     */
    private Integer sumUp(List<Integer> integers) {
        if (integers.size() < 3) return 0;

        // choose lesser of two peeks
        int peekValue = Math.min(integers.get(0), integers.get(integers.size() - 1));

        return integers.stream()
                .map(value -> peekValue - value)
                .filter(val -> val > 0)
                .reduce(0, Integer::sum);
    }
}
