package ru.jakimenko.skymeal.service;

import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public interface IPlaneService {
    Plane save(Plane plane);

    void delete(int id) throws NotFoundException;

    Plane get(int id) throws NotFoundException;

    void update(Plane plane);

    List<Plane> getAll();
}
