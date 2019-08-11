package ac.za.Payroll.service.user.impl;

import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.repository.user.EmployeeRepository;
import ac.za.Payroll.service.user.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ServiceImpl")
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    @Qualifier("InMemory")
    private EmployeeRepository repository;

    @Override
    public Employee create(Employee employee) {
        return repository.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return repository.update(employee);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);

    }

    @Override
    public Employee read(String s) {
        return repository.read(s);
    }

    @Override
    public Set<Employee> getAll() {
        return repository.getAll();
    }
}

