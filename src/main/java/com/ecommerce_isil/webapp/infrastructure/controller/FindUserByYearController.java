package com.ecommerce_isil.webapp.infrastructure.controller;

import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.FindUserByYearCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class FindUserByYearController {
    private final FindUserByYearCase findUserByYearCase;

    public FindUserByYearController(FindUserByYearCase findUserByYearCase){
        this.findUserByYearCase = findUserByYearCase;
    }

    @GetMapping("/{year}")
    public List<UserResponse> findUserByYear(@PathVariable int year){
        return findUserByYearCase.findUserByYear(year)
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getLastName(),
                        user.getFirstName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getCreatedAt(),
                        user.getUpdatedAt(),
                        user.getRole()
                ))
                .toList();
    }
}
