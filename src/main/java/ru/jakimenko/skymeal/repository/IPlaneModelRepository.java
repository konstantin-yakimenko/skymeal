package ru.jakimenko.skymeal.repository;

import ru.jakimenko.skymeal.model.PlaneModel;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public interface IPlaneModelRepository {

    PlaneModel save(PlaneModel planeModel);

    boolean delete(int id);

    PlaneModel get(int id);

    List<PlaneModel> getAll();
}
