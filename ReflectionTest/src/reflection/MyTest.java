package reflection;

import domain.Employee;
import domain.Manager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @author: zhouqian
 * @date: 2020/2/10
 * @blog:
 * @version:1.0.0
 * @description:
 */

public class MyTest {
    public static void main(String[] args) throws Exception{
        Employee e = new Employee("Harry Hacker", 560000, 2012,3,4);
        System.out.println(e.getClass().getName() + " " + e.getName());

        //获取Class对象的第一种方法：对象实例调用getClass()方法
        Class c1 = e.getClass();
        String name = c1.getName();
        System.out.println(name);

        //获取Class对象的第二种方法：调用静态方法forName
        String className = "java.util.Random";
        Class c2 = Class.forName(className);
        System.out.println(c2.getName());

        //获取Class对象的第三种方法：如果T是任意的Java类型，使用T.class
        Class c3 = Double[].class;
        System.out.println(c3.getName());

        //获取雇员类的name字段，并对它进行修改
        Field f = c1.getDeclaredField("name");
        //由于是私有域，所以要县使用setAccessible方法来覆盖访问控制
        f.setAccessible(true);
        //get方法返回的是Object对象，要想正常打印，需要进行类型转换
        Object v = f.get(e);
        System.out.println((String) v);
        //set方法可以更改对应字段的值
        f.set(e, "Tom Smith");
        System.out.println((String) f.get(e));


        //获取雇员类的salary字段，并对它进行修改
        Field f1 = c1.getDeclaredField("salary");
        //由于是私有域，所以要县使用setAccessible方法来覆盖访问控制
        f1.setAccessible(true);
        //get方法返回的是Object对象，要想正常打印，需要进行类型转换
        Object v1 = f1.getDouble(e);
        System.out.println(v1);
        //set方法可以更改对应字段的值
        f1.set(e, 67000);
        System.out.println(f1.get(e));

        Method m = c1.getMethod("raiseSalary", double.class);
        Object[] v2 = m.getParameterTypes();


        Manager manager = new Manager("Bob Black", 1230, 2014,4,4);
        System.out.println(manager);

        Class managerClass = manager.getClass();
        Constructor constructor = managerClass.getConstructor(String.class,double.class, int.class,int.class,int.class);
        Manager manager1 =( Manager) constructor.newInstance("123",6127,1978,7,7);
        System.out.println(manager1);

        Method method = managerClass.getMethod("setBonus", double.class, boolean.class);
        //invoke传参数的方法一：传入Object数组
        Object[] obj = { 123, true};
        method.invoke(manager, obj);
        System.out.println(manager.getSalary());

        //invoke传参数的方法二：直接传入值
        method.invoke(manager, 63767, false);
        System.out.println(manager.getSalary());
    }
}
