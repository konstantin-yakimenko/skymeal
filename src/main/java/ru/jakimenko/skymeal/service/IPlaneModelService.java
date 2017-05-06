package ru.jakimenko.skymeal.service;

import ru.jakimenko.skymeal.model.PlaneModel;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public interface IPlaneModelService {
    ru.jakimenko.skymeal.model.PlaneModel save(ru.jakimenko.skymeal.model.PlaneModel planeModel);

    void delete(int id) throws NotFoundException;

    ru.jakimenko.skymeal.model.PlaneModel get(int id) throws NotFoundException;

    void update(PlaneModel planeModel);

    List<ru.jakimenko.skymeal.model.PlaneModel> getAll();

    void evictCache();
}
