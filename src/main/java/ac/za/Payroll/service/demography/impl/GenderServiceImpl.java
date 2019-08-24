package ac.za.Payroll.service.demography.impl;

import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.repository.demography.GenderRepository;
import ac.za.Payroll.repository.demography.impl.GenderRepositoryImpl;
import ac.za.Payroll.service.demography.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("GenderServiceImpl")
public class GenderServiceImpl implements GenderService {
    @Autowired
    @Qualifier("InMemory")
    private static GenderServiceImpl service = null;
    private GenderRepository repository;

    private GenderServiceImpl() {
        this.repository = GenderRepositoryImpl.getRepository();
    }

    public static GenderServiceImpl getService(){
        if (service == null) service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }
}
