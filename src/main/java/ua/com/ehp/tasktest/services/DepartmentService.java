package ua.com.ehp.tasktest.services;

import org.springframework.stereotype.Service;
import ua.com.ehp.tasktest.dao.DepartmentDAO;
import ua.com.ehp.tasktest.models.Department;

@Service
public class DepartmentService {

    private DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public void save(Department department) {
        departmentDAO.save(department);
    }

    public Department findDepartmentByDpName(String dpName) {
        Department department = departmentDAO.findDepartmentByDpName(dpName);
        return department;
    }

    public Department createDepartment(String dpNme){
        Department department = new Department(dpNme);
        return department;
    }

    public Department findOrCreateDepartment(String dpName){
        if(isDepartmentExists(dpName)){
            return findDepartmentByDpName(dpName);
        } else {
            return createDepartment(dpName);
        }
    }

    public boolean isDepartmentExists(String dpName) {
        if (findDepartmentByDpName(dpName) != null) {
            return true;
        } else{
            return false;
        }
    }


}
