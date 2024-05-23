package tasks23_24.services;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tasks23_24.objects.User;
import tasks23_24.objects.UserDTO;

import static tasks23_24.objects.Role.USER;

@AllArgsConstructor
@Service
public class AuthorizationService {
    PasswordEncoder passwordEncoder;
    private final UserService userService;

    public boolean signUp(UserDTO userData) {

        User user = new User(userData.getUsername(), passwordEncoder.encode(userData.getPassword()), USER);

        return userService.create(user);
    }
}