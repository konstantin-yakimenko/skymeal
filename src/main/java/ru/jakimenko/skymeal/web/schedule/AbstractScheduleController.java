package ru.jakimenko.skymeal.web.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.jakimenko.skymeal.AuthorizedUser;
import ru.jakimenko.skymeal.model.Schedule;
import ru.jakimenko.skymeal.service.IScheduleService;
import ru.jakimenko.skymeal.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by konst on 07.05.17.
 */
public abstract class AbstractScheduleController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("scheduleService")
    private IScheduleService service;

    public List<Schedule> getAll() {
        log.info("getAll");
        return (List<Schedule>) service.getAll();
    }

    public Schedule get(int id) {
        log.info("get " + id);
        return service.get(id);
    }

    public Schedule create(Schedule schedule) {
        schedule.setId(null);
        log.info("create " + schedule);
        return service.save(schedule);
    }

    public void delete(int id) {
        log.info("delete " + id);
        service.delete(id);
    }

    public void update(Schedule schedule) {
        log.info("update " + schedule);
        service.update(schedule);
    }

    public List<Schedule> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        int userId = AuthorizedUser.id();
        log.info("getBetween dates {} - {} for time {} - {} for User {}", startDate, endDate, startTime, endTime, userId);
        return (List<Schedule>)service.getBetweenDates(startDate != null ? startDate : TimeUtil.MIN_DATE, endDate != null ? endDate : TimeUtil.MAX_DATE);
    }
}
