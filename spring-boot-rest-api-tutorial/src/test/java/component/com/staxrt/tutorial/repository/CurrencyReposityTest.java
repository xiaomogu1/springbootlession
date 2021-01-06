package component.com.staxrt.tutorial.repository;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.staxrt.tutorial.Application;
import com.staxrt.tutorial.repository.CurrencyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CurrencyReposityTest {
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Test
	public void testrepo() {
		String result =  currencyRepository.get("https://api.exchangeratesapi.io/latest");
		System.out.println(result);
	}

	
	@Autowired
    ApplicationContext applicationContext;

	@Test
    public void printBeans() {
		Arrays.asList(applicationContext.getBeanDefinitionNames()).stream().forEach(x ->{
	        System.out.println(x);

		});
    }
}
