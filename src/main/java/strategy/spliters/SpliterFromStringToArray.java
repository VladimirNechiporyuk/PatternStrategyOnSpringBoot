package strategy.spliters;

import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class SpliterFromStringToArray {

    public int[] splitStringToIntArray(String inputtedString, String symbolForSplit) {
        return Stream.of(inputtedString.substring(1, inputtedString.length() - 1)
                .split(symbolForSplit))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}