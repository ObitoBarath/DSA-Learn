package OOPs.encapsulation;

class Student{

        private String name; //private field cannot access directly 
        private int age;

        public String getName(){// public field , accessible
            return this.name;
        }
        public void setName (String name){
            this.name = name;
        }
        public int getAge(){
            return this.age;
        }
        public void setAge(int age){
            this.age = age;
        }

    }