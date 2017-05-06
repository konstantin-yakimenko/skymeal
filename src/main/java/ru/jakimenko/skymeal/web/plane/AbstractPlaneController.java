package ru.jakimenko.skymeal.web.plane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.jakimenko.skymeal.model.Plane;
import ru.jakimenko.skymeal.service.IPlaneService;
import ru.jakimenko.skymeal.service.PlaneService;
import ru.jakimenko.skymeal.to.PlaneTo;

import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
public class AbstractPlaneController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private IPlaneService service = new PlaneService();

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
//        checkModificationAllowed(id);
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Plane plane, int id) {
//        checkModificationAllowed(id);
        plane.setId(id);
        log.info("update " + plane);
        service.update(plane);
    }

    public void update(PlaneTo planeTo) {
    }
}
