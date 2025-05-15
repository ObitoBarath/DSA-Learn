package relfection;

import java.util.ArrayList;
import java.util.List;

import static relfection.StrategyPattern.getDefaultProvisioningHeaderFields;


public class ReflectionTester {

    public static void main(String[] args) {

        long longValue = 1000L;

        Student student = new Student("Leo" , 10 , 99999D);

        System.out.println("student = " + student);

        List<String> strings = new ArrayList<>();

        strings.add("name");

        strings.add("age");

        strings.add("phoeNumber");

        HelperClass helperClass = new HelperClass();

        strings.forEach(item -> {

            try {
                    Object defaultProvisioningHeaderFields = getDefaultProvisioningHeaderFields(student, item ,helperClass , "methodFounder");
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
//            System.out.println("item = " + defaultProvisioningHeaderFields);
        });



    }


}
