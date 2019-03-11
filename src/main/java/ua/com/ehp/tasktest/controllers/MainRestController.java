package ua.com.ehp.tasktest.controllers;


import org.springframework.web.bind.annotation.*;
import ua.com.ehp.tasktest.dao.DepartmentDAO;
import ua.com.ehp.tasktest.dao.EmployeeDAO;
import ua.com.ehp.tasktest.models.Department;
import ua.com.ehp.tasktest.models.Employee;
import ua.com.ehp.tasktest.services.DepartmentService;
import ua.com.ehp.tasktest.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class MainRestController {

    EmployeeService employeeService;
    DepartmentService departmentService;

    public MainRestController(EmployeeService employeeService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    public String home() {
        System.out.println("home page");
        return "home";

    }

    @PostMapping("/save")
    public String save(
            @RequestParam String empName,
            @RequestParam String empActive,
            @RequestParam String dpName
    ) {
        Employee employee = new Employee(empName, empActive);
        employeeService.save(employee);
        Department department = departmentService.findOrCreateDepartment(dpName);
        employee.setDepartment(department);
        employeeService.save(employee);
        return "save ok!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        return "delete ok!";
    }
    
    @GetMapping("/view/{id}")
    public Employee viewEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id){
        return "edit ok!";
    }

    @GetMapping("/find/{empName}")
    public String findEmployeeByEmpName(@PathVariable String empName){
        return "find ok";
    }

//    @PostMapping("/save")
//    public String save(@RequestBody Employee employee) {
//        System.out.println(employee);
//        employeeDAO.save(employee);
//        System.out.println(employee);
//        System.out.println("save ok!");
//        return "ok";
//    }
//
////    @CrossOrigin(origins = "http://localhost:4200")
//    @GetMapping("/employees")
//    public List<Employee> listEmployees() {
//        List<Employee> employees = employeeDAO.findAll();
//        return employees;
//    }
}
