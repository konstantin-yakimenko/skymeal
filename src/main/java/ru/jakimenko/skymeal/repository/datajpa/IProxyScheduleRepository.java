package ru.jakimenko.skymeal.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.jakimenko.skymeal.model.Schedule;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by konst on 07.05.17.
 */
@Transactional(readOnly = true)
public interface IProxyScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Schedule s WHERE s.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Schedule save(Schedule schedule);

    @Query("SELECT s FROM Schedule s LEFT JOIN FETCH s.plane WHERE s.id=:id")
    Schedule get(@Param("id") int id);

    @Override
    @Query("SELECT s FROM Schedule s LEFT JOIN FETCH s.plane ORDER BY s.date desc")
    List<Schedule> findAll();

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT s from Schedule s LEFT JOIN FETCH s.plane WHERE s.date BETWEEN :startDate AND :endDate ORDER BY s.date DESC")
    List<Schedule> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
