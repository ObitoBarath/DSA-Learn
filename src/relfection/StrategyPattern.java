package relfection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class StrategyPattern {

    public static <T> Object getDefaultProvisioningHeaderFields(T classInstance, String headerName ,T helperClassInstance , String methodNotFoundListenerMethodName) throws NoSuchMethodException {

        if (classInstance == null || headerName == null || headerName.isEmpty()) {
            return "Invalid Input";
        }



        Class<?> clazz = classInstance.getClass();

        Optional<Method> getterMethod = Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.getName().equals(headerName)).findFirst().map(field -> getGetterMethod(clazz, field.getName()));

        if (getterMethod.isEmpty()){

            Method method = null;
            try {
                Method[] methods = helperClassInstance.getClass().getDeclaredMethods();
                System.out.println("helper methods" + Arrays.toString(methods));
                method = Arrays.stream(helperClassInstance.getClass().getDeclaredMethods()).filter(item -> item.getName().equals(methodNotFoundListenerMethodName)).findFirst().orElse(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String exactMethodName = null;

            try {
                exactMethodName = (String)  method.invoke(helperClassInstance , classInstance , headerName);
            }catch (Exception  e){
                throw new RuntimeException(e);
            }

            getterMethod = Optional.of( clazz.getDeclaredMethod(exactMethodName));

        }

        return getterMethod.map(method -> invokeGetter(method, classInstance , headerName)).map(item -> processObject(item ,headerName)).orElse(null);

    }

    private static Method getGetterMethod(Class<?> clazz, String fieldName) {
        String getterName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getName().equals(getterName))
                .findFirst()
                .orElse(null);
    }

    private static Object invokeGetter(Method method, Object classInstance , String header) {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(classInstance);
        } catch (Exception e) {
            System.err.println("Error invoking method: " + method.getName());
            return null;
        }
    }

    private static Object processObject(Object object, String headerName) {
        if (object == null) {
            return "-";
        }
        if (object instanceof String) {
            return getStandardTableData((String) object);
        }
        if (headerName.equals("age")){
            return "age";
        }
        if (object instanceof Double) {
            return getStandardTableData(String.valueOf(object));
        }
        if (object instanceof Long) {
            return object;
        }
        return "Not specified instance check";
    }

    private static String getStandardTableData(String value) {
        return value.trim(); // Simulated processing
    }


}
