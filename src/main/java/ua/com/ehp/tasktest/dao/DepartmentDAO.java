package ua.com.ehp.tasktest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.ehp.tasktest.models.Department;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Integer> {

    Department findDepartmentByDpName(String dpName);



}
