package ru.jakimenko.skymeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jakimenko.skymeal.AuthorizedUser;
import ru.jakimenko.skymeal.model.User;
import ru.jakimenko.skymeal.repository.IUserRepository;
import ru.jakimenko.skymeal.repository.mock.UserRepositoryMock;
import ru.jakimenko.skymeal.to.UserTo;
import ru.jakimenko.skymeal.util.UserUtil;
import ru.jakimenko.skymeal.util.exception.ExceptionUtil;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;
import java.util.Objects;

/**
 * Created by konst on 06.05.17.
 */
@Service("userService")
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(UserUtil.prepareToSave(user));
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Objects.requireNonNull(email, "Email must not be empty");
        return ExceptionUtil.checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    @Override
    @Transactional
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
        repository.save(UserUtil.prepareToSave(user));
    }

    @Override
    public void evictCache() {}

    @Override
    @Transactional
    public void enable(int id, boolean enable) {
        User user = get(id);
        user.setEnabled(enable);
        repository.save(user);
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repository.getByEmail(email.toLowerCase());
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(u);
    }
}
