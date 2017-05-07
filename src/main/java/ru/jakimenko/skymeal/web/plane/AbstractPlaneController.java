package ru.jakimenko.skymeal.web.plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.service.IPlaneService;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public abstract class AbstractPlaneController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("planeService")
    private IPlaneService service;

    public List<Plane> getAll() {
        log.info("getAll");
        return service.getAll();
    }

    public Plane get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public Plane create(Plane plane) {
        plane.setId(null);
        log.info("create " + plane);
        return service.save(plane);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Plane plane) {
        log.info("update " + plane);
        service.update(plane);
    }

}
