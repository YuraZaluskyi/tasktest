package ua.com.ehp.tasktest.controllers;


import org.springframework.web.bind.annotation.*;
import ua.com.ehp.tasktest.models.Department;
import ua.com.ehp.tasktest.models.Employee;
import ua.com.ehp.tasktest.services.DepartmentService;
import ua.com.ehp.tasktest.services.EmployeeService;

import java.util.List;

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
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        employeeService.delete(employee);
        return "delete ok!";
    }

    @GetMapping("/view/{id}")
    public Employee viewEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @GetMapping("/edit/{id}")
    public Employee editEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @GetMapping("/find/{empName}")
    public List<Employee> findEmployeeByEmpName(@PathVariable String empName) {
        List<Employee> employees = employeeService.findAllByEmpName(empName);
        return employees;
    }
    
    @GetMapping("/employees")
    public List<Employee> listEmployees(){
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

}
