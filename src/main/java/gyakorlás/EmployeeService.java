package gyakorlás;

import java.util.List;

public class EmployeeService {

    public void createEmployee(String name, int yearOfBirth, EmployeeType employeeType) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("");
        }
    }


    public Result findEmployee(String prefix, List<String> names) {

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).startsWith(prefix)) {
                return new Result(names.get(i), i);
            }
        }
        throw new IllegalArgumentException("");
    }


}
