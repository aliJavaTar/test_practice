package org.travel;

public record Odd(int number) {
    public boolean isOdd() {
        return number % 2 != 0;
    }
}
