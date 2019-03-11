package ua.com.ehp.tasktest.services;

import org.springframework.stereotype.Service;
import ua.com.ehp.tasktest.dao.EmployeeDAO;
import ua.com.ehp.tasktest.models.Employee;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    public Employee findById(int id) {
        Employee employee = employeeDAO.findById(id).get();
        return employee;
    }

    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }
}
