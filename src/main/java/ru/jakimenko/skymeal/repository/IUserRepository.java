package ru.jakimenko.skymeal.repository;


import ru.jakimenko.skymeal.model.User;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public interface IUserRepository {
    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

}
