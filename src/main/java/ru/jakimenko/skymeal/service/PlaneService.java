package ru.jakimenko.skymeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.repository.IPlaneRepository;
import ru.jakimenko.skymeal.util.exception.ExceptionUtil;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
@Service("planeService")
public class PlaneService implements IPlaneService {

    @Autowired
    private IPlaneRepository repository;

    @Override
    public Plane save(Plane plane) {
        return repository.save(plane);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Plane get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void update(Plane plane) { repository.save(plane); }

    @Override
    public List<Plane> getAll() {
        return repository.getAll();
    }
}
