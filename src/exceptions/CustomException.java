package exceptions;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomException  extends Exception implements Externalizable {

    public CustomException(String message){
        super(message);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        CustomException out1 = (CustomException) out;
        try(ExecutorService executorService  = Executors.newFixedThreadPool(1)){


        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
class TestException {

    public static final String kel = "";
    public static void main(String[] args)  throws Exception {
        int age = 10;

        String value = null;
        Optional<String> hello = Optional.ofNullable(null);
        hello.ifPresent(item -> {
            System.out.println("item = " + item);
        });


    }
}
