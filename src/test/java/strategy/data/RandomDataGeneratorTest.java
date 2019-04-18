package strategy.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomDataGeneratorTest {

    @Autowired
    private RandomDataGenerator randomDataGenerator;

    @Test
    public void getDataTest() {
        int arrayLength = 15;
        int numbersBound = 3;

        int[] generatedArray = randomDataGenerator.generateData(arrayLength, numbersBound);
        int maxNumberInGeneratedArray = stream(generatedArray)
                .max()
                .orElseThrow(RuntimeException::new);

        assertEquals(generatedArray.length, arrayLength);
        assertEquals(maxNumberInGeneratedArray, numbersBound - 1);
    }
}