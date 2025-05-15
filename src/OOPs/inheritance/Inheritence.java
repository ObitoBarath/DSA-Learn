package OOPs.inheritance;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Inheritence {

        interface A{
            void show();
        }
        interface B{
            void show();
        }

    public  class Animal implements A , B {
        String name = "animal";
        String animalAge;

        @Override
        public void show() {
            System.out.println("name = @@@@@@@@@@@@@@@@@@" + name);
        }
    }

    public class Forest extends Animal {
        String name = "forest";
        String place;

        public  void hello(){

        }
    }

    public  class Country extends Forest{
        String countryName;

        @Override
        public void hello(){

        }

    }

    public void main(String[] args) {


            Animal animal = new Animal();
            animal.show();
        Forest forest = new Forest();
        String animalAge = forest.animalAge;
        String name = forest.name;
        System.out.println("name = " + name);
        Country country = new Country();
        Class<? extends Country> aClass = country.getClass();
        System.out.println("aClass = " + aClass);



            try{
                Map<String , List<String>> stringIntegerMap  = new LinkedHashMap<>();
            }catch (NullPointerException n){
                System.out.println("Null pointer gotten");
            }catch (Exception e){
                System.out.println("Exception pointer gotten");
            }
    }



}
