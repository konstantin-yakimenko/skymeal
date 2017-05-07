package ru.jakimenko.skymeal.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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

    @Column(name = "seat_econom", nullable = false)
    @NotEmpty
    protected String seatEconom;

    @Column(name = "seat_business", nullable = false)
    @NotEmpty
    protected String seatBusiness;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeatEconom() {
        return seatEconom;
    }

    public void setSeatEconom(String seatEconom) {
        this.seatEconom = seatEconom;
    }

    public String getSeatBusiness() {
        return seatBusiness;
    }

    public void setSeatBusiness(String seatBusiness) {
        this.seatBusiness = seatBusiness;
    }

    public Plane() {}

    public Plane(Plane plane) {
        this(plane.id, plane.name, plane.type, plane.seatEconom, plane.seatBusiness);
    }

    public Plane(String type, String seatEconom, String seatBusiness) {
        this.type = type;
        this.seatEconom = seatEconom;
        this.seatBusiness = seatBusiness;
    }

    public Plane(Integer id, String name, String type, String seatEconom, String seatBusiness) {
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
