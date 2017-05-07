package ru.jakimenko.skymeal.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.jakimenko.skymeal.model.Schedule;
import ru.jakimenko.skymeal.repository.IScheduleRepository;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by konst on 07.05.17.
 */
@Repository
public class DataJpaScheduleRepository implements IScheduleRepository {

    @Autowired
    private IProxyScheduleRepository proxy;

    @Override
    public Schedule save(Schedule schedule) {
        return proxy.save(schedule);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Schedule get(int id) {
        return proxy.get(id);
    }

    @Override
    public Collection<Schedule> getAll() {
        return proxy.findAll();
    }

    @Override
    public Collection<Schedule> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        return proxy.getBetween(startDate, endDate);
    }
}
