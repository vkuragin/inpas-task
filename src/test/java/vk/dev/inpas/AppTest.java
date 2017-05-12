package vk.dev.inpas;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import vk.dev.inpas.services.CalcService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by vk on 18.03.2017
 */
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {

    @Autowired
    private CalcService calcService;

    @Test
    public void testValidations() {
        String valid = "1,2,0,4,2,5";
        assertNull("Validation success", calcService.validate(valid));
    }

    @Test
    public void testValidationEmptyString() {
        String empty = null;
        assertEquals("Validation error on null input", "Empty input!", calcService.validate(empty));

        empty = "";
        assertEquals("Validation error on empty input", "Empty input!", calcService.validate(empty));
    }

    @Test
    public void testValidationInvalidCharacters() {
        String invalid = "1,2,.5m";
        assertEquals("Validation error on invalid input", "Invalid input characters!", calcService.validate(invalid));
    }

    @Test
    public void testCalculationByString() {
        String input = "3,2,4,1,2";
        assertEquals("Calculation result for " + input, 2, calcService.calc(input).intValue());
    }

    @Test
    public void testCalculationByArray() {
        List<Integer> input = Arrays.asList(4, 1, 1, 0, 2, 3);
        assertEquals("Calculation result for " + input, 8, calcService.calc(input).intValue());

        input = Arrays.asList(16, 1, 1, 0, 0, 0);
        assertEquals("Calculation result for " + input, 0, calcService.calc(input).intValue());

        input = Arrays.asList(3, 9, 1, 10, 2, 3, 0, 1);
        assertEquals("Calculation result for " + input, 10, calcService.calc(input).intValue());
    }
}
