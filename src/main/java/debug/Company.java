package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {

    public List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeByName(String employeeName) {



        for (Employee element : employees) {

            if (element.getName() == employeeName) {
                return element;
            }

        }
    return null;
    }


    public List<String> listEmployeeNames() {
        List<String> employeeNames= new ArrayList<>();

        for (Employee element: employees) {
            employeeNames.add(element.getName());
        }
        return employeeNames;
    }
}



