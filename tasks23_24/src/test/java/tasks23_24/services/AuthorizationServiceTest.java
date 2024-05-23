package tasks23_24.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import tasks23_24.objects.Role;
import tasks23_24.objects.UserDTO;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorizationServiceTest {
    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthorizationService authorizationService;

    @Test
    void signUp() {
        String username = "test_user";
        String password = "test_password";
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        String hashedPassword = "hashed_password";

        when(passwordEncoder.encode(password)).thenReturn(hashedPassword);

        boolean result = authorizationService.signUp(userDTO);

        verify(passwordEncoder).encode(password);


        verify(userService).create(argThat(user -> user.getUsername().equals(username)
                && user.getPassword().equals(hashedPassword)
                && user.getRole() == Role.USER));

    }
}