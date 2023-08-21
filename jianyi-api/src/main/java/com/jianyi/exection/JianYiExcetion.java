package com.jianyi.exection;

public class JianYiExcetion  extends RuntimeException{

    private JianYiExcetion(String message) {
        super(message);
    }

    private JianYiExcetion(Throwable t) {
        super(t);
    }

    public static void throwException(String message) {
        throw new JianYiExcetion(message);
    }

    public static JianYiExcetion getException(String message) {
        throw new JianYiExcetion(message);
    }

    public static void throwException(Throwable t) {
        throw new JianYiExcetion(t);
    }
}
