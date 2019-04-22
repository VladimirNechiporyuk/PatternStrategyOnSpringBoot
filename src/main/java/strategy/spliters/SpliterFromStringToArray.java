package strategy.spliters;

import java.util.Arrays;

public class SpliterFromStringToArray {

    public static int[] splitStringToIntArray(String inputtedString, String symbolForSplit) {
        //todo: do it with streams
        return Arrays.stream(inputtedString.split(symbolForSplit))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}