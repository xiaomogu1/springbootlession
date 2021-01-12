package unit.com.staxrt.tutorial.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.UserRepository;
import com.staxrt.tutorial.service.UserService;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Before
	public void setup() {
		List<User> users = new LinkedList<User>();
		User user = new User();
		user.setFirstName("test");
		user.setLastName("123");
		user.setEmail("rr@gmail.com");
		users.add(user);
		when(userRepository.findAll()).thenReturn(users );
		
		Optional<User> response = Optional.of(user);
		when(userRepository.findById(1L)).thenReturn(response); 
	}
	
	@Test
	public void findAll_passNoParams_returnSuccessUsers() {
		
		List<User> users = userService.findAll();
		 System.out.println(users.size());
		users.forEach(user-> {
			System.out.println(user.toString());
		});
	}
	
	@Test
	public void findAll_passUserId_returnSuccessUsers() throws ResourceNotFoundException {
		User users = userService.findUserById(1);
		assertEquals("rr@gmail.com", users.getEmail());
	}

}
