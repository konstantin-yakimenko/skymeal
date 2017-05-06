package ru.jakimenko.skymeal.repository;

import ru.jakimenko.skymeal.model.Plane;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public interface IPlaneRepository {

    Plane save(Plane plane);

    boolean delete(int id);

    Plane get(int id);

    List<Plane> getAll();
}
