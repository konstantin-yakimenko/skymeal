package ru.jakimenko.skymeal.service;

import ru.jakimenko.skymeal.model.User;
import ru.jakimenko.skymeal.repository.IUserRepository;
import ru.jakimenko.skymeal.repository.mock.UserRepositoryMock;
import ru.jakimenko.skymeal.to.UserTo;
import ru.jakimenko.skymeal.util.UserUtil;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class UserService implements IUserService {

    private final IUserRepository repository = new UserRepositoryMock();

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return repository.getByEmail(email);
    }

    @Override
    public void update(UserTo userTo) {
        User user = get(userTo.getId());
        UserUtil.updateFromTo(user, userTo);
        repository.save(UserUtil.prepareToSave(user));
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void evictCache() {}

    @Override
    public void enable(int id, boolean enable) {}
}
