package ac.za.Payroll.service.demography.impl;

import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.repository.demography.RaceRepository;
import ac.za.Payroll.repository.demography.impl.RaceRepositoryImpl;
import ac.za.Payroll.service.demography.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;


public class RaceServiceImpl implements RaceService {

    private static RaceServiceImpl service = null;
    private RaceRepository repository;

    private RaceServiceImpl() {
        this.repository = RaceRepositoryImpl.getRepository();
    }

    public static RaceServiceImpl getService(){
        if (service == null) service = new RaceServiceImpl();
        return service;
    }

    @Override
    public Race create(Race race) {
        return this.repository.create(race);
    }

    @Override
    public Race update(Race race) {
        return this.repository.update(race);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Race read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Race> getAll() {
        return this.repository.getAll();
    }
}
