package reflection_examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class employeeClass = Class.forName("reflection_examples.Employee"); // 1 option to create Class object
        Class employeeClass2 = Employee.class; // 2 option to create Class object
        Employee emp = new Employee();
        Class employeeClass3 = emp.getClass(); // 3 option to create Class object

        Field field = employeeClass.getField("id");
        System.out.println("Type of id field = " + field.getType());
        System.out.println("******");

        Field[] fields = employeeClass.getFields();
        for (Field f : fields) {
            System.out.println("Type of " + f.getName() + " = " + f.getType());
        }
        System.out.println("******");

        Field[] declaredFields = employeeClass.getDeclaredFields();// all fields including private
        for (Field f : declaredFields) {
            System.out.println("Type of " + f.getName() + " = " + f.getType());
        }
        System.out.println("******");

        Method increaseSalary = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary = " + increaseSalary.getReturnType()
                + ", parameter types = " + Arrays.toString(increaseSalary.getParameterTypes()));

        Method setSalary = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method setSalary = " + setSalary.getReturnType()
                + ", parameter types = " + Arrays.toString(setSalary.getParameterTypes()));
        System.out.println("******");

        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println("Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("******");

        Method[] allMethods = employeeClass.getDeclaredMethods(); // all methods including private except inherited methods
        for (Method method : allMethods) {
            System.out.println("Name of method = " + method.getName() +
                    ", return type = " + method.getReturnType() +
                    ", parameter types = " + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("******");

        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.println("Name of method = " + method.getName() +
                        ", return type = " + method.getReturnType() +
                        ", parameter types = " + Arrays.toString(method.getParameterTypes()));
            }
        }
        System.out.println("******");

        Constructor constructor = employeeClass.getConstructor();
        System.out.println("Constructor has " + constructor.getParameterCount() +
                " parameters, their types are " + Arrays.toString(constructor.getParameterTypes()));
        System.out.println("******");

        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor2 has " + constructor2.getParameterCount() +
                " parameters, their types are " + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("******");

        Constructor[] constructors = employeeClass.getConstructors();
        for(Constructor cons:constructors){
            System.out.println("Constructor " + cons.getName() + " has " + cons.getParameterCount() +
                    " parameters, their types are: " + Arrays.toString(cons.getParameterTypes()));
        }
    }
}
