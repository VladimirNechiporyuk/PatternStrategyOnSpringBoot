package strategy.spliters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SpliterFromStringToArray {

    public static List<Integer> splitStringToIntArray(String inputtedString, String symbolForSplit) {
        //todo: do it with streams
        List<Integer> integers = new ArrayList<>();
        Stream.of(inputtedString, symbolForSplit)
                .forEach(n -> integers.add(Integer.valueOf(n)));
        return integers;
    }
}