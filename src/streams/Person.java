package streams;

 class Person implements Comparable {
        String name;
        String city;
        Person(String name, String city) { this.name = name; this.city = city; }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }

     @Override
     public int compareTo(Object o) {


            Integer i = (Integer) o;

         return 0;
     }
 }