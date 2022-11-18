package chapter1.test;

import chapter1.UnsafeSequence;
import org.junit.jupiter.api.Test;

public class TestUnsafeSequence {

    @Test
    void testUnsafeSequence(){
        UnsafeSequence unsafeSequence = new UnsafeSequence();

        Runnable runnable = unsafeSequence::getNextValue;

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
            new Thread(runnable).start();

        }
        System.out.println(unsafeSequence.getValue());


    }
}
