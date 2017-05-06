package ru.jakimenko.skymeal.service;

import ru.jakimenko.skymeal.repository.IPlaneModelRepository;
import ru.jakimenko.skymeal.repository.mock.PlaneModelRepositoryMock;
import ru.jakimenko.skymeal.model.PlaneModel;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class PlaneModelService implements IPlaneModelService {

    private final IPlaneModelRepository repository = new PlaneModelRepositoryMock();

    @Override
    public ru.jakimenko.skymeal.model.PlaneModel save(ru.jakimenko.skymeal.model.PlaneModel planeModel) {
        return repository.save(planeModel);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.delete(id);
    }

    @Override
    public ru.jakimenko.skymeal.model.PlaneModel get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public void update(PlaneModel planeModel) {}

    @Override
    public List<ru.jakimenko.skymeal.model.PlaneModel> getAll() {
        return repository.getAll();
    }

    @Override
    public void evictCache() {}
}
