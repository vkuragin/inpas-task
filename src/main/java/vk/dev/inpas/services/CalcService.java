package vk.dev.inpas.services;

import java.util.List;

/**
 * Created by vk on 18.03.2017
 */
public interface CalcService {
    Integer calc(List<Integer> src);
    Integer calc(String src);
    String validate(String input);
}
