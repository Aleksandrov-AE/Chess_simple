package org.alex;

public enum Color {
    WHITE,
    BLACK;

    public Color opposit() {
        if (this == Color.WHITE) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }
}
