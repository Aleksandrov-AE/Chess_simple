package org.alex;

public enum Horizontal {
    A, B, C, D, E, F, G, H;

    public static boolean checkChar(char ch) {
        for (Horizontal horizontal:Horizontal.values()) {
            if (horizontal.name().charAt(0) == Character.toUpperCase(ch)) {
                return  true;
            }
        }
        return false;
    }
}

