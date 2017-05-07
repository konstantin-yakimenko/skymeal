package ru.jakimenko.skymeal.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.CollectionUtils;
import ru.jakimenko.skymeal.View;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by konst on 07.05.17.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Schedule.GET, query = "SELECT s FROM Schedule s WHERE s.id=:id"),
        @NamedQuery(name = Schedule.ALL_SORTED, query = "SELECT s FROM Schedule s ORDER BY s.date DESC"),
        @NamedQuery(name = Schedule.DELETE, query = "DELETE FROM Schedule s WHERE s.id=:id"),
        @NamedQuery(name = Schedule.GET_BETWEEN, query = "SELECT s FROM Schedule s "+
                "WHERE s.date BETWEEN :startDate AND :endDate ORDER BY s.date DESC"),
})
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    public static final String GET = "Schedule.get";
    public static final String ALL_SORTED = "Schedule.getAll";
    public static final String DELETE = "Schedule.delete";
    public static final String GET_BETWEEN = "Schedule.getBetween";

    @Column(name = "date", columnDefinition = "timestamp default now()")
    protected LocalDateTime date = LocalDateTime.now();

    @Column(name = "number", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 7)
    protected int number;

    @Column(name = "region_date", columnDefinition = "timestamp default now()")
    protected LocalDateTime regionDate = LocalDateTime.now();

    @Column(name = "plan_start", columnDefinition = "timestamp default now()")
    protected LocalDateTime planStart = LocalDateTime.now();

    @Column(name = "plan_finish", columnDefinition = "timestamp default now()")
    protected LocalDateTime planFinish = LocalDateTime.now();

    @Column(name = "airport_start", nullable = false)
    @Length(max=3, min=3)
    @NotEmpty
    protected String airportStart;

    @Column(name = "airport_finish", nullable = false)
    @Length(max=3, min=3)
    @NotEmpty
    protected String airportFinish;

    @Column(name = "fact_start", columnDefinition = "timestamp default now()")
    protected LocalDateTime factStart = LocalDateTime.now();

    @Column(name = "fact_finish", columnDefinition = "timestamp default now()")
    protected LocalDateTime factFinish = LocalDateTime.now();

    @Column(name = "fact_start_utc", columnDefinition = "timestamp default now()")
    protected LocalDateTime factStartUtc = LocalDateTime.now();

    @Column(name = "fact_finish_utc", columnDefinition = "timestamp default now()")
    protected LocalDateTime factFinishUtc = LocalDateTime.now();

    @Column(name = "airport_fact", nullable = false)
    @Length(max=3, min=3)
    @NotEmpty
    protected String airportFact ;

    @Column(name = "pas_econom", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 4)
    protected int pasEconom;

    @Column(name = "pas_business", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 4)
    protected int pasBusiness;

    @Column(name = "pilots", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 2)
    protected int pilots;

    @Column(name = "strewards", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 2)
    protected int strewards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id", nullable = false)
    protected Plane plane;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getRegionDate() {
        return regionDate;
    }

    public void setRegionDate(LocalDateTime regionDate) {
        this.regionDate = regionDate;
    }

    public LocalDateTime getPlanStart() {
        return planStart;
    }

    public void setPlanStart(LocalDateTime planStart) {
        this.planStart = planStart;
    }

    public LocalDateTime getPlanFinish() {
        return planFinish;
    }

    public void setPlanFinish(LocalDateTime planFinish) {
        this.planFinish = planFinish;
    }

    public String getAirportStart() {
        return airportStart;
    }

    public void setAirportStart(String airportStart) {
        this.airportStart = airportStart;
    }

    public String getAirportFinish() {
        return airportFinish;
    }

    public void setAirportFinish(String airportFinish) {
        this.airportFinish = airportFinish;
    }

    public LocalDateTime getFactStart() {
        return factStart;
    }

    public void setFactStart(LocalDateTime factStart) {
        this.factStart = factStart;
    }

    public LocalDateTime getFactFinish() {
        return factFinish;
    }

    public void setFactFinish(LocalDateTime factFinish) {
        this.factFinish = factFinish;
    }

    public LocalDateTime getFactStartUtc() {
        return factStartUtc;
    }

    public void setFactStartUtc(LocalDateTime factStartUtc) {
        this.factStartUtc = factStartUtc;
    }

    public LocalDateTime getFactFinishUtc() {
        return factFinishUtc;
    }

    public void setFactFinishUtc(LocalDateTime factFinishUtc) {
        this.factFinishUtc = factFinishUtc;
    }

    public String getAirportFact() {
        return airportFact;
    }

    public void setAirportFact(String airportFact) {
        this.airportFact = airportFact;
    }

    public int getPasEconom() {
        return pasEconom;
    }

    public void setPasEconom(int pasEconom) {
        this.pasEconom = pasEconom;
    }

    public int getPasBusiness() {
        return pasBusiness;
    }

    public void setPasBusiness(int pasBusiness) {
        this.pasBusiness = pasBusiness;
    }

    public int getPilots() {
        return pilots;
    }

    public void setPilots(int pilots) {
        this.pilots = pilots;
    }

    public int getStrewards() {
        return strewards;
    }

    public void setStrewards(int strewards) {
        this.strewards = strewards;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
