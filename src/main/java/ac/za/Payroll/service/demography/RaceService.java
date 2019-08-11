package ac.za.Payroll.service.demography;

import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race, String> {
    Set<Race> getAll();
}
