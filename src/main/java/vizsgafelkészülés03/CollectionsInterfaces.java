package vizsgafelkészülés03;

import java.util.*;

public class CollectionsInterfaces {


    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (Iterator<Integer> i = values.iterator(); i.hasNext();) {
            int value = i.next();
            if (value % 2 == 0) {
                i.remove();
            }
        }


        Set<List> set = new HashSet<>();

        set.add(Arrays.asList(1,2,3));
        List<Integer> n = new ArrayList<>();
        set.add(n);




        Employee e1 = new Employee("Macika", 1000000101, new Location(3,4));
        Employee e2 = new Employee("Gézu", 1000101, new Location(3,4));

        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        List<Employee> texts = new ArrayList<>(Arrays.asList(new Employee("Géza", 100, new Location(5,2)),
                new Employee("Géza", 100, new Location(5,2)),
                        null, new Employee("Géza", 300, new Location(5,2))));

        for (int i =1; i < texts.size(); i++) {
            if (Objects.equals(texts.get(i),(texts.get(i-1)))) {
                System.out.println("talált");
            }
        }




    /*    Deque<Integer> keetvegusor = new ArrayDeque<>();

        keetvegusor.push(1);
        keetvegusor.push(2);
        keetvegusor.push(3);
        keetvegusor.push(4);
        keetvegusor.push(5);

    *//*    System.out.println(keetvegusor.removeLast());
        System.out.println(keetvegusor);*//*


        Queue<Employee> sor = new PriorityQueue<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.valueOf(o1.getSalary()).compareTo(Integer.valueOf(o2.getSalary()));
            }
        });

        sor.add(new Employee("Géza", 1500, new Location(10, 12)));
        sor.add(new Employee("Béla", 3000, new Location(4, 12)));
        sor.add(new Employee("Babu", 500, new Location(1, 12)));
        sor.add(new Employee("Joci", 2000, new Location(7, 12)));
        sor.add(new Employee("Kiskati", 100, new Location(12, 12)));


        for (Iterator<Employee> employeeIterator = sor.iterator(); employeeIterator.hasNext(); ) {
            Employee tobeRemoved = employeeIterator.next();
            //System.out.println(tobeRemoved);
            employeeIterator.remove();
        }

        System.out.println(Objects.equals(new Employee("Géza", 1000, new Location(4, 3)),
                new Employee("Géza", 1000, new Location(4, 3))));*/


    }
}
