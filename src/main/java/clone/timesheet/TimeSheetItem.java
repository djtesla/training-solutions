package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem another) {
        this.employee = another.employee;
        this.project = another.project;
        this.from = another.from;
        this.to = another.to;
    }

    public String getEmployee() {
        return employee;
    }

    public String getProject() {
        return project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem tsi, LocalDate ld) {

        TimeSheetItem cl = new TimeSheetItem(tsi);
        cl.from = LocalDateTime.of(ld, cl.from.toLocalTime());
        cl.to = LocalDateTime.of(ld, cl.to.toLocalTime());
        return cl;
    }

}
