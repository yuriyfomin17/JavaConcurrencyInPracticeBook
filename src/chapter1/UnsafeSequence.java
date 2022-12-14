package chapter1;

import net.jcip.annotations.NotThreadSafe;

import java.util.Random;

@NotThreadSafe
public class UnsafeSequence {
    private static final long MIN_DELAY = 10;
    private static final long MAX_DELAY = 100;
    private static final Random RANDOM = new Random();
    private int value = 1;


    public void getNextValue() {
        try {
            Thread.sleep((long) Math.floor(RANDOM.nextDouble() * ((MAX_DELAY - MIN_DELAY) + MIN_DELAY)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        value++;
    }

    public int getValue() {
        return value;
    }
}
