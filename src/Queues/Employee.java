package Queues;

import java.util.Objects;

class Employee  {
    private String name;

    public Employee(int id , String name){
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object e){

        if (this == e) return true;

        if (e == null && getClass() != e.getClass() ) return false;
        Employee employee = (Employee) e;
        return Objects.equals(this.name.toLowerCase() , employee.name.toLowerCase());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}