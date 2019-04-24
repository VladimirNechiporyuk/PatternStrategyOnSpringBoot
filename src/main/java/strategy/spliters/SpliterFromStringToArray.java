package strategy.spliters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SpliterFromStringToArray {

    public int[] splitStringToIntArray(String inputtedString) {
        List<Integer> integers = new ArrayList<>();
        char[] chars = inputtedString.toCharArray();
        for (int i = 0; i < inputtedString.length(); i++) {
            if (Character.isDigit(chars[i])) {
                integers.add(Character.getNumericValue(chars[i]));
            }
        }
        int[] resultArray = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            resultArray[i] = integers.get(i);
        }
        return resultArray;
    }
}