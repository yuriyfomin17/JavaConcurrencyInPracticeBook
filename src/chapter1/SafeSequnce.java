package chapter1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Random;

@ThreadSafe
public class SafeSequnce {

    private static final long MIN_DELAY = 10;
    private static final long MAX_DELAY = 100;
    private static final Random RANDOM = new Random();
    @GuardedBy("this") private int value = 1;


    public synchronized void getNextValue() {
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
