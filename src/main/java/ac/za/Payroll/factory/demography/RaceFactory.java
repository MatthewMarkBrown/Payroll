package ac.za.Payroll.factory.demography;

import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.util.Misc;

public class RaceFactory {
    public static Race buildRace (String raceName){
        return new Race.Builder().raceId(Misc.generateId()).raceName(raceName).build();
    }
}
