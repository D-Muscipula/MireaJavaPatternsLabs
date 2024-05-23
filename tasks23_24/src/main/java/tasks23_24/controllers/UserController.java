package tasks23_24.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tasks23_24.objects.UserDTO;
import tasks23_24.services.AuthorizationService;

@AllArgsConstructor
@RestController
public class UserController {
    AuthorizationService authorizationService;

    @PostMapping("/auth/signup")
    public String signUp(@RequestBody UserDTO user){
        if(authorizationService.signUp(user)){
            return "User created";
        }else{
            return "User exists";
        }
    }
    @PostMapping("/auth/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "Logged out successfully";
    }

}
