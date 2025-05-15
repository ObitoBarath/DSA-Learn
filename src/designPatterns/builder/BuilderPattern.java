package designPatterns.builder;

class Car{

    private String engine;
    private Integer wheels;


    public static  class  Builder{
        private String engine;
        private Integer wheels;

        public Builder setEngine(String engineName){
            this.engine = engineName;
            return  this;
        }


        public Builder setWheels(int wheels){
            this.wheels = wheels;
            return  this;
        }



        public Car build(){
            return  new Car(this);
        }
    }

    public void show(){
        System.out.println("Car with " + engine + " and " + wheels + " wheels");
    }


    public Car(Builder builder){
        this.engine = builder.engine;
        this.wheels = builder.wheels;
    }
}



public class BuilderPattern {
    public static void main(String[] args) {
        Car v8 = new Car.Builder().setWheels(2).setEngine("V8").build();

        v8.show();
    }


}
