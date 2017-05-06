package ru.jakimenko.skymeal.service;

import ru.jakimenko.skymeal.repository.IPlaneRepository;
import ru.jakimenko.skymeal.repository.mock.PlaneRepositoryMock;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class PlaneService implements IPlaneService {

    private final IPlaneRepository repository = new PlaneRepositoryMock();

    @Override
    public ru.jakimenko.skymeal.model.Plane save(Plane plane) {
        return repository.save(plane);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public Plane get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public void update(Plane plane) {}

    @Override
    public List<Plane> getAll() {
        return repository.getAll();
    }


    @Override
    public void evictCache() {}
}
