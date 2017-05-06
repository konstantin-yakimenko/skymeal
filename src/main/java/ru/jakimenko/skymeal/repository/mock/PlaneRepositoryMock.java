package ru.jakimenko.skymeal.repository.mock;

import com.google.common.collect.Lists;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.model.PlaneModel;
import ru.jakimenko.skymeal.repository.IPlaneRepository;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class PlaneRepositoryMock implements IPlaneRepository {

    Plane p1, p2;

    {
        PlaneModel pm1 = new PlaneModel();
        pm1.setId(1);
        pm1.setName("A320-214");

        p1 = new Plane();
        p1.setId(1);
        p1.setModel(pm1);
        p1.setNumber("VQ-BES");
        p1.setSeatBusiness(8);
        p1.setSeatEconom(150);

        p2 = new Plane();
        p2.setId(2);
        p2.setModel(pm1);
        p2.setNumber("VQ-BPN");
        p2.setSeatBusiness(8);
        p2.setSeatEconom(150);
    }

    @Override
    public Plane save(Plane plane) {
        return p1;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }

    @Override
    public Plane get(int id) {
        return p2;
    }

    @Override
    public List<Plane> getAll() {
        return Lists.newArrayList(p1, p2);
    }
}
