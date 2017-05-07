package ru.jakimenko.skymeal.to;

import java.time.LocalDateTime;

/**
 * Created by konst on 07.05.17.
 */
public class ScheduleTo {

    private LocalDateTime date;
    private Integer number;
    private LocalDateTime regionDate;
    private LocalDateTime planStart;
    private LocalDateTime planFinish;
    private String airportStart;
    private String airportFinish;
    private LocalDateTime factStart;
    private LocalDateTime factFinish;
    private LocalDateTime factStartUtc;
    private LocalDateTime factFinishUtc;
    private String airportFact ;
    private Integer pasEconom;
    private Integer pasBusiness;
    private Integer pilots;
    private Integer strewards;
    private String plane;
    private Integer planeId;

    public ScheduleTo(LocalDateTime date, Integer number, LocalDateTime regionDate, LocalDateTime planStart, LocalDateTime planFinish, String airportStart, String airportFinish, LocalDateTime factStart, LocalDateTime factFinish, LocalDateTime factStartUtc, LocalDateTime factFinishUtc, String airportFact, Integer pasEconom, Integer pasBusiness, Integer pilots, Integer strewards, String plane, Integer planeId) {
        this.date = date;
        this.number = number;
        this.regionDate = regionDate;
        this.planStart = planStart;
        this.planFinish = planFinish;
        this.airportStart = airportStart;
        this.airportFinish = airportFinish;
        this.factStart = factStart;
        this.factFinish = factFinish;
        this.factStartUtc = factStartUtc;
        this.factFinishUtc = factFinishUtc;
        this.airportFact = airportFact;
        this.pasEconom = pasEconom;
        this.pasBusiness = pasBusiness;
        this.pilots = pilots;
        this.strewards = strewards;
        this.plane = plane;
        this.planeId = planeId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

    public Integer getPasEconom() {
        return pasEconom;
    }

    public void setPasEconom(Integer pasEconom) {
        this.pasEconom = pasEconom;
    }

    public Integer getPasBusiness() {
        return pasBusiness;
    }

    public void setPasBusiness(Integer pasBusiness) {
        this.pasBusiness = pasBusiness;
    }

    public Integer getPilots() {
        return pilots;
    }

    public void setPilots(Integer pilots) {
        this.pilots = pilots;
    }

    public Integer getStrewards() {
        return strewards;
    }

    public void setStrewards(Integer strewards) {
        this.strewards = strewards;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }
}
