package org.leisure;

public class Test {
    public static class One{
        String a = "111";
    }

    public static void main(String[] args) {
        One one = new One();
        One two = one;
        two.a = "123";

    }
}
