package ac.za.Payroll.repository.demography;

import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender, String> {
    Set<Gender> getAll();
}
