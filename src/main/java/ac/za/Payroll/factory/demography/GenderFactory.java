package ac.za.Payroll.factory.demography;

import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.util.Misc;

public class GenderFactory {
    public static Gender buildGender (String genderName){
        return new Gender.Builder().genderId(Misc.generateId()).genderName(genderName).build();
    }
}
