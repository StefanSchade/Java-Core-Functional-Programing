package Lambdas;

import java.util.*;

import static java.util.Comparator.*;

public class ComparatorExample {

    public static void main(String[] args) {

        // employees
        List<Employee> staff = new ArrayList<>();
        staff.add(new Employee(1000, "Mike"));
        staff.add(new Employee(2000, "John"));
        staff.add(new Employee(1200, "Susan"));
        staff.add(new Employee(1300, "Megan"));
        staff.add(new Employee(1700, "Xavier"));
        staff.add(new Employee(2000, "Julien"));
        staff.add(new Employee(3000, "Monica"));

        System.out.println();
        System.out.println("Sort by Name using Anonymous Class:");
        System.out.println("-----------------------------------");
        System.out.println();

        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        printStaff((List<Employee>) staff);

        System.out.println();
        System.out.println("Sort by Name using Lambda:");
        System.out.println("---------------------------");
        System.out.println();


        Collections.sort(staff,(e1, e2) -> e1.getName().compareTo(e2.getName()));
        printStaff((List<Employee>) staff);



        System.out.println();
        System.out.println("Sort by salary using a 2 line lambda:");
        System.out.println("--------------------------------------");
        System.out.println();

        Collections.sort(staff, (e1, e2) -> {if (e1.getSalary() < e2.getSalary()) { return -1; } else return 1; });
        printStaff((List<Employee>) staff);



        System.out.println();
        System.out.println("Sort by name comparing:");
        System.out.println("--------------------------");
        System.out.println();



        staff.sort(Comparator.comparing(e -> e.getName()));
        printStaff(staff);


        System.out.println();
        System.out.println("Sort by salary comparing with a method reference:");
        System.out.println("-------------------------------------------------");
        System.out.println();

        staff.sort(Comparator.comparing(Employee::getSalary));
        printStaff(staff);

    }

    private static void printStaff(List<Employee> staff) {
        for (Employee employee : staff) {
            System.out.println("Name: " + employee.getName() + ' '
                    + nChars(20 - employee.getName().length(), '.')
                    + ' ' + employee.getSalary());
        }
    }

    static String nChars(int n, Character c) {
        char[] charArray = new char[n];
        Arrays.fill(charArray, c);
        String str = new String(charArray);
        return str;
    }
}

class Employee {
    private int salary;
    private String name;

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
