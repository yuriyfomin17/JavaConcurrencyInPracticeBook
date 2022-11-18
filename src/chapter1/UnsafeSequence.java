package chapter1;

import annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    public int getNextValue() {
        return value++;
    }
}
