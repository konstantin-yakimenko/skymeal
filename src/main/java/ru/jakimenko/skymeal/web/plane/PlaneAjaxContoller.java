package ru.jakimenko.skymeal.web.plane;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.jakimenko.skymeal.View;
import ru.jakimenko.skymeal.model.Plane;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
@RestController
@RequestMapping("/ajax/admin/planes")
public class PlaneAjaxContoller extends AbstractPlaneController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public List<Plane> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public Plane get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid Plane plane) {
        if (plane.isNew()) {
            super.create(plane);
        } else {
            super.update(plane);
        }
    }
}
