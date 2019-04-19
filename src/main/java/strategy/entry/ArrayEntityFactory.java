package strategy.entry;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import strategy.data.RandomDataGenerator;

import java.util.Date;

@Configuration
public class ArrayEntityFactory {

    @Value("${array.length:10}")
    private int arrayLength;

    @Value("${array.bound:2}")
    private int numBound;

    @Autowired
    private RandomDataGenerator dataGenerator;

    @Autowired
    private BeanFactory beanFactory;

    @Bean
    public ArrayEntity getArrayEntity() {
        return new ArrayEntity(dataGenerator.generateData(arrayLength, numBound), new Date());
    }
}
