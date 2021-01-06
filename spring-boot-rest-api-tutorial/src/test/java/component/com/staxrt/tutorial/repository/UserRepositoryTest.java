package component.com.staxrt.tutorial.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.staxrt.tutorial.Application;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() {
		
		List<User> users = userRepository.findAll();
		users.forEach(user-> {
			System.out.println(user.toString());
		});
	}

}
