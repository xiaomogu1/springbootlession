package com.staxrt.tutorial;


import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationH2Test {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void h2ConnectionTest()
    {
        User user = new User();
        user.setEmail("admin@gmail.com");
        user.setFirstName("admin");
        user.setLastName("admin");
        user.setCreatedBy("admin");
        user.setUpdatedBy("admin");
        userRepository.save(user);
        System.out.println(userRepository.findAll());
    }

}
