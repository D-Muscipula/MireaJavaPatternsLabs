package tasks23_24.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tasks23_24.objects.User;
import tasks23_24.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public boolean create(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false;
        }else{
            userRepository.save(user);
            return true;
        }
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }
}
