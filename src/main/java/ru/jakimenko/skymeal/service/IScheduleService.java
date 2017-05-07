package ru.jakimenko.skymeal.service;

import ru.jakimenko.skymeal.model.Schedule;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

/**
 * Created by konst on 07.05.17.
 */
public interface IScheduleService {
    Schedule get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    default Collection<Schedule> getBetweenDates(LocalDate startDate, LocalDate endDate) {
        return getBetweenDateTimes(LocalDateTime.of(startDate, LocalTime.MIN), LocalDateTime.of(endDate, LocalTime.MAX));
    }

    Collection<Schedule> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime);

    Collection<Schedule> getAll();

    Schedule update(Schedule schedule) throws NotFoundException;

    Schedule save(Schedule schedule);
}
