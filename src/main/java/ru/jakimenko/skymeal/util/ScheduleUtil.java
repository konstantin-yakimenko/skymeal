package ru.jakimenko.skymeal.util;

import ru.jakimenko.skymeal.model.Schedule;
import ru.jakimenko.skymeal.to.ScheduleTo;

/**
 * Created by konst on 08.05.17.
 */
public class ScheduleUtil {

    public static Schedule createNewFromTo(ScheduleTo newSchedule) {
        return new Schedule.ScheduleBuilder()
                .setDate(newSchedule.getDate())
                .setNumber(newSchedule.getNumber())
                .setRegionDate(newSchedule.getRegionDate())
                .setPlanStart(newSchedule.getPlanStart())
                .setPlanFinish(newSchedule.getPlanFinish())
                .setAirportStart(newSchedule.getAirportStart())
                .setAirportFinish(newSchedule.getAirportFinish())
                .setFactStart(newSchedule.getFactStart())
                .setFactFinish(newSchedule.getFactFinish())
                .setFactStartUtc(newSchedule.getFactStartUtc())
                .setFactFinishUtc(newSchedule.getFactFinishUtc())
                .setAirportFact(newSchedule.getAirportFact())
                .setPasEconom(newSchedule.getPasEconom())
                .setPasBusiness(newSchedule.getPasBusiness())
                .setPilots(newSchedule.getPilots())
                .setStrewards(newSchedule.getStrewards())
                .build();
    }

}
