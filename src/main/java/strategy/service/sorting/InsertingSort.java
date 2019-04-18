package strategy.service.sorting;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("inserting")
public class InsertingSort implements SortingStrategy {

    @Override
    public int[] sort(int[] array) {
        for (int barrier = 1; barrier < array.length; barrier++) {
            int index = barrier;
            while (index - 1 >= 0 && array[index] < array[index - 1]) {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
        return array;
    }
}
