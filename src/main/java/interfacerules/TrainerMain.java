package interfacerules;

public class TrainerMain {


    public static void main(String[] args) {
        HasName hasName = new Trainer();
        CanWork canWork = new Trainer();
        canWork.doWork();
        hasName.getName();

        System.out.println(EmployeeType.FULL_TIME);
    }
}
