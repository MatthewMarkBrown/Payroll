package ac.za.Payroll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class IndexController {
    @GetMapping("/")
    @ResponseBody
    public String getHome() {
        return " Hello World ";
    }
}
