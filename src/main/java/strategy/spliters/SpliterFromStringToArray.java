package strategy.spliters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpliterFromStringToArray {

    public int[] splitStringToIntArray(String inputtedString) {
        List<Integer> integers = new ArrayList<>();
        inputtedString.chars()
                .mapToObj(c -> (char) c)
                .forEach(character -> {
                    if (Character.isDigit(character)) {
                        integers.add(Character.getNumericValue(character));
                    }
                });
        return integers.stream().mapToInt(i -> i).toArray();
    }
}