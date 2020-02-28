package interfaces;

import domain.Employee;

import java.util.Arrays;

/**
 * @author: zhouqian
 * @date: 2020/2/14
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);

        Arrays.sort(staff);

        for (Employee e: staff
             ) {
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
        }

    }
}
