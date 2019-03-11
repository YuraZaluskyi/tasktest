package ua.com.ehp.tasktest.controllers;


import org.springframework.web.bind.annotation.*;
import ua.com.ehp.tasktest.dao.EmployeeDAO;
import ua.com.ehp.tasktest.models.Employee;

import java.util.List;

@RestController
public class MainRestController {

    EmployeeDAO employeeDAO;

    public MainRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    @GetMapping("/")
    public String home() {
        System.out.println("home page");
        return "home";

    }

    @PostMapping("/save")
    public String save(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeDAO.save(employee);
        System.out.println(employee);
        System.out.println("save ok!");
        return "ok";
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees")
    public List<Employee> listEmployees() {
        List<Employee> employees = employeeDAO.findAll();
        return employees;
    }
}
