package vk.dev.inpas;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import vk.dev.inpas.services.CalcService;

/**
 * Created by vk on 18.03.2017
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class WebController {

    private final CalcService calcService;

    @RequestMapping(path = "/")
    public ModelAndView main(Model model) {
        return new ModelAndView("main");
    }

    @RequestMapping(path = "/calc", method = RequestMethod.POST)
    public ModelAndView calc(Model model, WebRequest request) {

        String inputString = request.getParameter("inputArr");
        String errMsg = calcService.validate(inputString);

        model.addAttribute("inputArr", inputString);
        model.addAttribute("errMsg", errMsg);

        // if input valid then calculate and print result
        Integer result = null;
        if (StringUtils.isEmpty(errMsg)) {
            result = calcService.calc(inputString);
            model.addAttribute("result", result);
        }

        log.info("Input array: {},\n Error message={}\n, Result={}\n", inputString, errMsg, result);
        return new ModelAndView("forward:/");
    }
}
