package strategy.data;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomDataGenerator implements DataSource {

    @Override
    public int[] generateData(int arrayLength, int numBound) {
        int[] array = new int[arrayLength];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(numBound);
        }
        return array;
    }
}
