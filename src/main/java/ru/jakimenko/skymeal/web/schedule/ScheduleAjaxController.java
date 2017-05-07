package ru.jakimenko.skymeal.web.schedule;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.jakimenko.skymeal.View;
import ru.jakimenko.skymeal.model.Schedule;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by konst on 07.05.17.
 */
@RestController
@RequestMapping("/ajax/admin/schedules")
public class ScheduleAjaxController extends AbstractScheduleController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public List<Schedule> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.UI.class)
    public Schedule get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid Schedule plane) {
        if (plane.isNew()) {
            super.create(plane);
        } else {
            super.update(plane);
        }
    }
}
