package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.entity.User;
import com.ecommerce_isil.webapp.core.usecase.port.in.FindUserByYearCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FindUserByYearService implements FindUserByYearCase {
    private final UserRepositoryPort userRepositoryPort;

    public FindUserByYearService(UserRepositoryPort userRepositoryPort){
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> findUserByYear(int year) {
        LocalDateTime begin = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(year, 12, 31, 0, 0,0);
        return userRepositoryPort.findByCreatedAtBetween(begin, end);
    }
}
