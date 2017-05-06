package ru.jakimenko.skymeal.repository.mock;

import com.google.common.collect.Lists;
import ru.jakimenko.skymeal.model.PlaneModel;
import ru.jakimenko.skymeal.repository.IPlaneModelRepository;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class PlaneModelRepositoryMock implements IPlaneModelRepository {

    PlaneModel pm1;
    PlaneModel pm2;

    {
        pm1 = new PlaneModel();
        pm1.setId(1);
        pm1.setName("A320-214");

        pm2 = new PlaneModel();
        pm2.setId(2);
        pm2.setName("A321-211");
    }

    @Override
    public PlaneModel save(PlaneModel planeModel) {
        return pm1;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public PlaneModel get(int id) {
        return pm1;
    }

    @Override
    public List<PlaneModel> getAll() {
        return Lists.newArrayList(pm1, pm2);
    }
}
