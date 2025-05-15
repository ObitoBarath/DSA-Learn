import accessModifiers.AccessModifiers;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class TCS extends AccessModifiers {



    public void hello(){
        String phoneNumber1 = phoneNumber;
    }
    @FunctionalInterface
    interface C {

        void h();

        default void hello() {
            System.out.println("true = " + true);
        }

    }

    class A implements C {

        @Override
        public void h() {

        }

        @Override
        public void hello() {

        }

    }


    static public void main(String[] args) {
        int vehicle = 200;
        int tires = 541;

        Map<String, Float> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("4Wheeler", 0.1f);
        vehicleMap.put("2Wheeler", (tires / 2f));
        System.out.println("vehicleMap = " + vehicleMap);
//        recursiveHelper(vehicleMap, vehicle);

    }


    static {

        cruiseMemberLeft();
    }

    private static void cruiseMemberLeft() {
        int[] in = {3, 5, 2, 0};
        int[] out = {0, 2, 4, 4};

        int n = in.length;
        Map<Integer, Integer> hourToMember = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);

            int currentMember = in[i] - out[i];

            if (hourToMember.containsKey(i - 1)) {
                currentMember += hourToMember.get(i - 1);  // Fix: Use (i - 1) instead of 'flag - 1'
            }

            hourToMember.put(i, currentMember);
            System.out.println("hourToMember = " + hourToMember);
        }

        Integer maxHour = hourToMember.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Max members at hour: " + (maxHour + 1));
    }


    public static void recursiveHelper(Map<String, Float> vehicleMap, int vehicle) {


        float countOfAllVehicle = vehicleMap.get("4Wheeler") + vehicleMap.get("2Wheeler");
        System.out.println("countOfAllVehicle = " + countOfAllVehicle);

        if (countOfAllVehicle == vehicle) {
            System.out.println("vehicleMap = " + vehicleMap);
            return;
        }


        vehicleMap.put("2Wheeler", vehicleMap.get("2Wheeler") - 2);
        vehicleMap.put("4Wheeler", vehicleMap.get("4Wheeler") + 1);

        recursiveHelper(vehicleMap, vehicle);

    }


}
