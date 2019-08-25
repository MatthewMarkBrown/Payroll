package ac.za.Payroll.service.user.impl;

import ac.za.Payroll.factory.demography.GenderFactory;
import ac.za.Payroll.factory.demography.RaceFactory;
import ac.za.Payroll.factory.user.EmployeeFactory;
import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.repository.demography.impl.GenderRepositoryImpl;
import ac.za.Payroll.repository.demography.impl.RaceRepositoryImpl;
import ac.za.Payroll.repository.user.impl.EmployeeRepositoryImpl;
import ac.za.Payroll.service.user.CreateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateEmployeeServiceImpl implements CreateEmployeeService{

    @Autowired
    public EmployeeRepositoryImpl empRepository = EmployeeRepositoryImpl.getRepository();
    @Autowired
    public GenderRepositoryImpl genderRepository = GenderRepositoryImpl.getRepository();
    @Autowired
    public RaceRepositoryImpl raceRepository = RaceRepositoryImpl.getRepository();
    @Autowired
    public EmployeeFactory employeeFactory;
    @Autowired
    public GenderFactory genderFactory;
    @Autowired
    public RaceFactory raceFactory;

    public CreateEmployeeServiceImpl(){
 }

    @Override
    public Employee saveEmp(String id, String firstName, String lastName, int age, String Gender, String race) {
        Employee emp = this.empRepository.create(EmployeeFactory.buildEmployee(firstName,lastName,age));
        Gender gender = this.genderRepository.create(GenderFactory.buildGender(Gender));
        Race Race = this.raceRepository.create(RaceFactory.buildRace(race));
        return emp;
    }

    @Override
    public Gender getGender(String gender) {
        return this.genderRepository.read(gender);
    }

    @Override
    public Race getRace(String race) {
        return this.raceRepository.read(race);
    }
}
