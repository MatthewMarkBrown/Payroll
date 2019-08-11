package ac.za.Payroll.repository.user.impl;

import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.repository.user.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

@Repository("InMemory")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Map<String, Employee> employeess;

    private EmployeeRepositoryImpl() {
        this.employeess = new HashMap<>();
    }

    public static EmployeeRepository getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.employeess.put(employee.getEmployeeId(),employee);
        return employee;
    }

    public Employee read(String employeeId){
        return this.employeess.get(employeeId);
    }

    public Employee update(Employee employee) {
        this.employeess.replace(employee.getEmployeeId(),employee);
        return this.employeess.get(employee.getEmployeeId());
    }

    public void delete(String employeeId) {
        this.employeess.remove(employeeId);
    }

    public Set<Employee> getAll(){
        Collection<Employee> students = this.employeess.values();
        Set<Employee> set = new HashSet<>();
        set.addAll(students);
        return set;
    }
}
