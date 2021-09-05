package reflection_examples;

import java.lang.reflect.Field;

public class Example3 { //reflection is able to bypass the principle of encapsulation
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee emp = new Employee(10, "Grisha", "IT");
        Class employeeClass = emp.getClass();
        Field field = employeeClass.getDeclaredField("salary");

        field.setAccessible(true);

        double salary = (Double) field.get(emp);
        System.out.println(salary);

        field.set(emp, 1400);
        System.out.println(emp);
    }
}
