package strategy.service.sorting;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"selection"})
public class SelectionSort implements SortingStrategy {

    @Override
    public int[] sort(int[] array) {
        for (int barrier = 0; barrier < array.length - 1; barrier++) {
            for (int i = barrier + 1; i < array.length; i++) {
                if (array[i] < array[barrier]) {
                    int temp = array[i];
                    array[i] = array[barrier];
                    array[barrier] = temp;
                }
            }
        }
        return array;
    }
}
