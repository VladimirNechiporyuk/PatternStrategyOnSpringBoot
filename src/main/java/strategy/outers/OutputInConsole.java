package strategy.outers;

import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.lang.String.format;

@Component
public class OutputInConsole implements OutNumbersArray {
    public void outNumbersArray(String message, int[] array) {
        System.out.println(format("%s %s", message, Arrays.toString(array)));
    }
}
