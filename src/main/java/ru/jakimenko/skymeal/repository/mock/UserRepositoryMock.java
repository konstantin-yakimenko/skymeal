package ru.jakimenko.skymeal.repository.mock;

import com.google.common.collect.Lists;
import ru.jakimenko.skymeal.model.User;
import ru.jakimenko.skymeal.repository.IUserRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class UserRepositoryMock implements IUserRepository {

    User u1, u2;

    {
        u1 = new User();
        u1.setCaloriesPerDay(1);
        u1.setEmail("u1@mail.ru");
        u1.setEnabled(true);
        u1.setPassword("111");
        u1.setRegistered(new Date());
        u1.setRoles(new ArrayList<>());
        u1.setId(1);
        u1.setName("user1");

        u2 = new User();
        u2.setCaloriesPerDay(1);
        u2.setEmail("u1@mail.ru");
        u2.setEnabled(true);
        u2.setPassword("111");
        u2.setRegistered(new Date());
        u2.setRoles(new ArrayList<>());
        u2.setId(2);
        u2.setName("user2");
    }

    @Override
    public User save(User user) {
        return u1;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User get(int id) {
        return u1;
    }

    @Override
    public User getByEmail(String email) {
        return u1;
    }

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(u1, u2);
    }
}
