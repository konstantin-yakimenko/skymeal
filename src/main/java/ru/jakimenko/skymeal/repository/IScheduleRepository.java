package ru.jakimenko.skymeal.repository;

import ru.jakimenko.skymeal.model.Schedule;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by konst on 07.05.17.
 */
public interface IScheduleRepository {
    Schedule save(Schedule schedule);

    boolean delete(int id);

    Schedule get(int id);

    Collection<Schedule> getAll();

    Collection<Schedule> getBetween(LocalDateTime startDate, LocalDateTime endDate);

    default Schedule getWithPlane(Integer id) {
        throw new UnsupportedOperationException();
    }
}
