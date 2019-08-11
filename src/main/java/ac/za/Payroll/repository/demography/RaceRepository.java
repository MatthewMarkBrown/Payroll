package ac.za.Payroll.repository.demography;

import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race, String> {
    Set<Race> getAll();
}
