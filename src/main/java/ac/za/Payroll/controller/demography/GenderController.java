package ac.za.Payroll.controller.demography;

import ac.za.Payroll.factory.demography.GenderFactory;
import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.service.demography.impl.GenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/payroll/gender")
public class GenderController {
    @Autowired
    @Qualifier("GenderServiceImpl")
    private GenderServiceImpl service;

    @GetMapping("/create/{genderName}")
    public @ResponseBody
    Gender create(@PathVariable String genderName){
        Gender course = GenderFactory.buildGender(genderName);
        return service.create(course);
    }


    @GetMapping("/getall")
    @ResponseBody
    public Set<Gender> getAll(){
        return service.getAll();
    }
}
