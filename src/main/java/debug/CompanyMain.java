package debug;

public class CompanyMain {

    public static void main(String[] args) {


        Employee employee1 = new Employee("Kis Béci", 1980);
        Employee employee2 = new Employee("Vak Ond", 1970);
        Employee employee3 = new Employee("Jurij Medvejev", 1960);
        Employee employee4 = new Employee("Captain Jack", 1940);

        Company company = new Company();

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);
        company.addEmployee(employee4);


        System.out.println(company.findEmployeeByName("Kis Béci").getName());

        System.out.println(company.findEmployeeByName("Kamu Józsi").getName());

        System.out.println(company.listEmployeeNames());
    }
}
