package reflection;

import java.util.*;
import java.lang.reflect.*;



public class ReflectionTest {
    public static void main(String[] args) {

        String name;
        //从命令行或者用户输入来读取类名
        if(args.length > 0)
            name = args[0];
        else{
            Scanner in = new Scanner(System.in);
            //输入的必须是完整类名
            System.out.println("Please enter class name(e.g. java.util.Date)");
            name = in.next();
        }

        try {
            //如果不为空，就输出类名和它的父类
            Class c1 = Class.forName(name);
            Class superClass = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class "+name);

            if (superClass != null && superClass != Object.class ) {
                System.out.print("extends "+ superClass.getName());
            }

            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 打印所有的构造函数
     * @param c1 一个Class对象
     */
    public static void printConstructors(Class c1){
        Constructor[] constructors = c1.getDeclaredConstructors();

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("	");
            String modifiers  = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(name + "(");

            //构造方法的参数类型
            Class[] papramTypes = c.getParameterTypes();
            for (int j = 0; j < papramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(papramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印所有的方法
     * @param c1
     */
    public static void printMethods(Class c1){
        Method[] methods = c1.getDeclaredMethods();

        for(Method m : methods){
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("	");

            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print(retType.getName() + " "+ name + "(");

            //打印参数类型
            Class[] papramTypes = m.getParameterTypes();
            for (int j = 0; j < papramTypes.length; j++) {
                if (j > 0) {
                    System.out.print(",");
                }
                System.out.print(papramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的所有域
     * @param c1
     */
    public static void printFields(Class c1){
        Field[] fields = c1.getDeclaredFields();

        for(Field f : fields){
            Class type = f.getType();
            String name = f.getName();

            System.out.print("	");

            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.println(type.getName() + " "+ name + ";");
        }

    }
}