package com.ecommerce_isil.webapp.core.usecase.service;

import com.ecommerce_isil.webapp.core.usecase.dto.request.RegisterUserRequest;
import com.ecommerce_isil.webapp.core.usecase.dto.response.UserResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.DeleteUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.FindUserByYearCase;
import com.ecommerce_isil.webapp.core.usecase.port.in.RegisterUserCase;
import com.ecommerce_isil.webapp.core.usecase.port.out.UserRepositoryPort;
import com.ecommerce_isil.webapp.core.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements RegisterUserCase, DeleteUserCase, FindUserByYearCase {
    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {
        User user = new User();

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        /*acá propongo que updatedAt sea null porque el updatedAt solo adquiere valor cuando se actualiza
        aqui solamente estamos registrando un nuevo usuario*/
        user.setUpdatedAt(null);
        user.setRole("USER");

        User savedUser = userRepositoryPort.save(user);

        return new UserResponse (
               savedUser.getId(),
               savedUser.getName(),
               savedUser.getLastName(),
               savedUser.getFirstName(),
               savedUser.getEmail(),
               savedUser.getPhone(),
               savedUser.getCreatedAt(),
               savedUser.getUpdatedAt(),
               savedUser.getRole()
        );

    }


    //eliminar un user por su idUser
    @Override
    public void deleteUser(UUID idUser) {
        userRepositoryPort.deleteById(idUser);
    }

    //acá la logica para tener todos los registros desde el inicio hasta el fin del año que se escriba
    @Override
    public List<User> findUserByYear(int year) {
        LocalDateTime begin = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        LocalDateTime end = LocalDateTime.of(year, 12, 31, 0, 0,0);
        return userRepositoryPort.findByCreatedAtBetween(begin, end);
    }
}
