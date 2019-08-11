package ac.za.Payroll.controller.demography;

import ac.za.Payroll.factory.demography.RaceFactory;
import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.service.demography.impl.RaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/payroll/race")
public class RaceController {

    private RaceServiceImpl service;

    @GetMapping("/create/{raceName}")
    public @ResponseBody
    Race create(@PathVariable String raceName){
        Race course = RaceFactory.buildRace(raceName);
        return service.create(course);

    }

    @GetMapping("/getall")
    @ResponseBody
    public Set<Race> getAll(){
        return service.getAll();
    }
}

