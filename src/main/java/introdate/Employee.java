package introdate;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private String name;
    private LocalDate dateOfBirth;
    LocalDateTime beginEmployment;

    public Employee(String name, int year, int month, int day) {
        this.name = name;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.beginEmployment = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getBeginEmployment() {
        return beginEmployment;
    }

}
