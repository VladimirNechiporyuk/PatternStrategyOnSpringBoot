package strategy.outers;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class OutputInConsole implements OutNumbersArray{
    public void outNumbersArray(String message, int[] array) {
        System.out.print(message + ' ' + Arrays.toString(array));
    }
}
