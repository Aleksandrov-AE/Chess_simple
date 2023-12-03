package org.alex;


import org.alex.pieces.CoordinatesShift;

import java.util.Objects;

public class Coordinates {
    public final Horizontal horizontal;
    public final int vertical;

    public Coordinates(Horizontal horizontal, Integer vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public  Coordinates getShiftCoordinates(CoordinatesShift shift) {
        return  new Coordinates(Horizontal.values()[horizontal.ordinal() + shift.horizontalShift], vertical + shift.verticalShift);
    }

    public boolean canShift(CoordinatesShift coordinatesShift) {
        int h = this.horizontal.ordinal() + coordinatesShift.horizontalShift;
        int v = this.vertical + coordinatesShift.verticalShift;
        if (h < 0 || h > 7) {
            return false;
        }
        return v >= 1 && v <= 8;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) o;
        return horizontal == that.horizontal && Objects.equals(vertical, that.vertical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontal, vertical);
    }

    @Override
    public String toString() {
        return "Coordinates{"
                + "horizontal=" + horizontal
                + ", vertical=" + vertical
                + '}';
    }
}
