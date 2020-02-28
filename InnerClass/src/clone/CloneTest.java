package clone;

import domain.Employee;

/**
 * @author: zhouqian
 * @date: 2020/2/14
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class CloneTest {
    public static void main(String[] args) {
        try {

            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(200,1,1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002,12,31);
            System.out.println("original = " + original);
            System.out.println("copy = " + copy);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

    }
}
