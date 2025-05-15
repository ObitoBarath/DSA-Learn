package streams;

import java.util.List;

public class User {
    String name;
    List<String> phoneNumber;

    User(String name , List<String> phoneNumberList){
        this.name = name;
        this.phoneNumber = phoneNumberList;
    }
}
