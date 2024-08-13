package com.example.taazadhara.N.Controller;

import com.example.taazadhara.N.dto.LoginApiDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Temporary in-memory storage
    private List<LoginApiDto> users = new ArrayList<>();

    @GetMapping
    public List<LoginApiDto> getAllUsers() {
        return users;
    }

    @PostMapping
    public LoginApiDto createUser(@RequestBody LoginApiDto loginApiDto) {
        loginApiDto.setId((long) (users.size() + 1)); // Simple ID generation
        users.add(loginApiDto);
        return loginApiDto;
    }
}
