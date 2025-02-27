package com.example.springsecuritylearn.Api;

import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritylearn.Model.Authorities;
import com.example.springsecuritylearn.Model.Users;
import com.example.springsecuritylearn.Payload.Request.RegisterReq;
import com.example.springsecuritylearn.Repos.AuthoritiesRepo;
import com.example.springsecuritylearn.Repos.UsersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class ApiClass {

    @Autowired
    UsersRepo usersRepo;
    @Autowired
    AuthoritiesRepo authoritiesRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @GetMapping("/login")
    public String getMethodName() {
        return "Login API called";
    }

    // @GetMapping("/register")
    // public String getMethodName2() {
    // return "Register API called";
    // }

    @PostMapping("/register")
    public String postMethodName(@RequestBody RegisterReq entity) {

        // Encode password
        String encodedPassword = encoder.encode(entity.getPassword());

        Users user = new Users();
        user.setUsername(entity.getUsername());
        // user.setPassword(entity.getPassword());
        user.setPassword("{bcrypt}" + encodedPassword);
        user.setEnabled(true);

        Authorities auth = new Authorities();
        auth.setUsername(entity.getUsername());
        auth.setAuthority("ROLE_" + entity.getAuthority());

        try {
            authoritiesRepo.save(auth);
            usersRepo.save(user);
            return "You have registered with username: " + entity.getUsername() + " and password: "
                    + entity.getPassword()
                    + " and authority: " + entity.getAuthority();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }

    @GetMapping("/authonly")
    public String getMethodName3() {
        return "Auth only API called";
    }

}
