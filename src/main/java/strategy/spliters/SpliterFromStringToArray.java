package strategy.spliters;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SpliterFromStringToArray {

    public static int[] splitStringToIntArray(String inputtedString, String symbolForSplit) {
        return Arrays.stream(inputtedString.split(symbolForSplit))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}