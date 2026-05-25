package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.entity.User;

import java.util.List;

public interface FindUserByYearCase {
    List<User> findUserByYear(int year);
}
