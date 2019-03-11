package ua.com.ehp.tasktest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.ehp.tasktest.models.Employee;
@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}
