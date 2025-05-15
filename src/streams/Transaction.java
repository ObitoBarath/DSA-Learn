package streams;

import java.time.LocalDate;

public class Transaction{
        int value;
        LocalDate localDate;

        @Override
        public String toString() {
            return "Transaction{" +
                    "value=" + value +
                    ", localDate=" + localDate +
                    '}';
        }

        public Transaction(int value , LocalDate localDate){
            this.value  = value;
            this.localDate = localDate;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }