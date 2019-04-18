package strategy.service.sorting;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class BubbleSort implements SortingStrategy {

    @Override
    public int[] sort(int[] array) {
        for (int barier = array.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }
}
