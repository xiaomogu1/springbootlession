package com.staxrt.tutorial;

import com.staxrt.tutorial.dao.UserMapper;
import com.staxrt.tutorial.exception.ResourceNotFoundException;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.model.UserFromUrl;
import com.staxrt.tutorial.repository.UserRepository;
import com.staxrt.tutorial.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper;

    @Before
    public void setup(){
        List<User> users = new LinkedList<>();
        User user = new User();
        user.setId(1);
        user.setFirstName("william");
        user.setLastName("liu");
        user.setEmail("888@gmail.com");

        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        Optional<User> response = Optional.of(user);
        when(userRepository.findById(1L)).thenReturn(response);

    }


    @Test
    public void findAll_passNoParams_returnSuccessUsers()
    {
        List<UserFromUrl> users = userService.findAll();
        System.out.println(users.size());
        users.forEach(userFromUrl -> System.out.println(userFromUrl.toString()));
    }


    @Test
    public void findAll_passUserId_returnSuccessUsers() throws ResourceNotFoundException {
        UserFromUrl user = userService.findById((long) 1);
//        System.out.println(user.toString());
//        Assert.assertEquals("888@gmail.com",user.getEmail());
        assertEquals("888@gmail.com",user.getEmail());
    }

}
