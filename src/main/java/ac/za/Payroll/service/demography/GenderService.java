package ac.za.Payroll.service.demography;

import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender, String> {
    Set<Gender> getAll();
}
