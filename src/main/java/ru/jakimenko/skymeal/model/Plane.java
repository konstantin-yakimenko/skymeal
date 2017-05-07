package ru.jakimenko.skymeal.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.List;

/**
 * Created by konst on 06.05.17.
 */
@Entity
@Table(name = "planes", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "planes_unique_bortnumber_idx")})
public class Plane  extends NamedEntity {

    @Column(name = "type", nullable = false)
    @Length(min = 4)
    @NotEmpty
    protected String type;

    @Column(name = "seat_econom", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 3)
    protected int seatEconom;

    @Column(name = "seat_business", columnDefinition = "default 0")
    @Digits(fraction = 0, integer = 3)
    protected int seatBusiness;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "plane")
    @OrderBy("dateTime DESC")
//    @JsonIgnore
    protected List<Schedule> schedules;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeatEconom() {
        return seatEconom;
    }

    public void setSeatEconom(Integer seatEconom) {
        this.seatEconom = seatEconom;
    }

    public Integer getSeatBusiness() {
        return seatBusiness;
    }

    public void setSeatBusiness(Integer seatBusiness) {
        this.seatBusiness = seatBusiness;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Plane() {}

    public Plane(Plane plane) {
        this(plane.id, plane.name, plane.type, plane.seatEconom, plane.seatBusiness);
    }

    public Plane(String type, Integer seatEconom, Integer seatBusiness) {
        this.type = type;
        this.seatEconom = seatEconom;
        this.seatBusiness = seatBusiness;
    }

    public Plane(Integer id, String name, String type, Integer seatEconom, Integer seatBusiness) {
        super(id, name);
        this.type = type;
        this.seatEconom = seatEconom;
        this.seatBusiness = seatBusiness;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", seatEconom='" + seatEconom + '\'' +
                ", seatBusiness='" + seatBusiness + '\'' +
                '}';
    }
}
