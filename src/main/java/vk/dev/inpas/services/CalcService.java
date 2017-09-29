package vk.dev.inpas.services;

import java.util.List;

/**
 * Created by vk on 18.03.2017
 */
public interface CalcService {

    /**
     * Calculate water volume by list.
     *
     * @param src list of values
     * @return water volume.
     */
    Integer calc(List<Integer> src);

    /**
     * Calculate water volume by string array.
     *
     * @param src string array
     * @return water volume.
     */
    Integer calc(String src);

    /**
     * Validate input string.
     *
     * @return null if validation succeeded or error message if not.
     */
    String validate(String input);
}
