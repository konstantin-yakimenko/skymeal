package ru.jakimenko.skymeal.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.jakimenko.skymeal.model.User;
import ru.jakimenko.skymeal.repository.IUserRepository;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
@Repository
public class DataJpaUserRepository implements IUserRepository {

    @Autowired
    private IProxyUserRepository proxy;

    @Override
    public User save(User user) {
        return proxy.save(user);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return proxy.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return proxy.findAll();
    }

}
