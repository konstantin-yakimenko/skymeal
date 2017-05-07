package ru.jakimenko.skymeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.jakimenko.skymeal.model.Schedule;
import ru.jakimenko.skymeal.repository.IScheduleRepository;
import ru.jakimenko.skymeal.util.exception.ExceptionUtil;
import ru.jakimenko.skymeal.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by konst on 07.05.17.
 */
@Service("scheduleService")
public class ScheduleService implements IScheduleService {

    @Autowired
    private IScheduleRepository repository;

    @Override
    public Schedule get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    public Collection<Schedule> getBetweenDateTimes(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return repository.getBetween(startDateTime, endDateTime);
    }

    @Override
    public Collection<Schedule> getAll() {
        return repository.getAll();
    }

    @Override
    public Schedule update(Schedule schedule) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.save(schedule), schedule.getId());
    }

    @Override
    public Schedule save(Schedule schedule) {
        return repository.save(schedule);
    }
}
