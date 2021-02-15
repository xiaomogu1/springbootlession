package com.staxrt.tutorial.repositoryTest;

import com.staxrt.tutorial.Application;
import com.staxrt.tutorial.repository.CurrencyForeign;
import com.staxrt.tutorial.repository.CurrencyReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CurrencyReposityTest {
    @Autowired
    private CurrencyReposity currencyReposity;

    @Test
    public void testRepo(){
        CurrencyForeign result = currencyReposity.get("https://api.exchangeratesapi.io/latest");
        System.out.println(result);

    }

}
