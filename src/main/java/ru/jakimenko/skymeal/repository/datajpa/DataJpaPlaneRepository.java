package ru.jakimenko.skymeal.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.repository.IPlaneRepository;

import java.util.List;

/**
 * Created by konst on 07.05.17.
 */
@Repository
public class DataJpaPlaneRepository implements IPlaneRepository {

    @Autowired
    private IProxyPlaneRepository proxy;

    @Override
    public Plane save(Plane plane) {
        return proxy.save(plane);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Plane get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Plane> getAll() {
        return proxy.findAll();
    }
}
