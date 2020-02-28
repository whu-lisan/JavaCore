package domain;

/**
 * @author: zhouqian
 * @date: 2020/2/10
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double bonus, boolean b) {
        this.bonus = bonus;
        System.out.println("boolean is " + b);
    }

}
