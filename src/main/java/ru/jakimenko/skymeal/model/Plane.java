package ru.jakimenko.skymeal.model;

import java.io.Serializable;

/**
 * Created by konst on 06.05.17.
 */
public class Plane implements Serializable {

    private Integer id;
    private PlaneModel model;
    private String number;
    private Integer seatEconom;
    private Integer seatBusiness;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlaneModel getModel() {
        return model;
    }

    public void setModel(PlaneModel model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (id != null ? !id.equals(plane.id) : plane.id != null) return false;
        if (model != null ? !model.equals(plane.model) : plane.model != null) return false;
        if (number != null ? !number.equals(plane.number) : plane.number != null) return false;
        if (seatEconom != null ? !seatEconom.equals(plane.seatEconom) : plane.seatEconom != null) return false;
        return seatBusiness != null ? seatBusiness.equals(plane.seatBusiness) : plane.seatBusiness == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (seatEconom != null ? seatEconom.hashCode() : 0);
        result = 31 * result + (seatBusiness != null ? seatBusiness.hashCode() : 0);
        return result;
    }
}
