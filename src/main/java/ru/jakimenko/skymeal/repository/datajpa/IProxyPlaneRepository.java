package ru.jakimenko.skymeal.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.jakimenko.skymeal.model.Plane;

import java.util.List;

/**
 * Created by konst on 07.05.17.
 */
@Transactional(readOnly = true)
public interface IProxyPlaneRepository extends JpaRepository<Plane, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Plane p WHERE p.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Plane save(Plane plane);
}
