package tasks23_24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tasks23_24.objects.User;
import tasks23_24.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Captor
    ArgumentCaptor<User> captor;

    @Test
    void save() {
        User user = new User();
        user.setUsername("Vitya");
        UserService userService = new
                UserService(userRepository);
        userService.create(user);
        Mockito.verify(userRepository).save(captor.capture());
        User captured = captor.getValue();
        assertEquals("Vitya", captured.getUsername());
    }
}
