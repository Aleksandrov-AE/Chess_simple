package org.alex.pieces;

import java.util.HashSet;
import java.util.Set;

public interface IBishop {
    public default Set<CoordinatesShift> bishopShift() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();
        for (int i = -7; i < 7; i++) {
            if (i == 0) {
                continue;
            }
            coordinatesShifts.add(new CoordinatesShift(i, i));
        }
        for (int i = -7; i < 7; i++) {
            if (i == 0) {
                continue;
            }
            coordinatesShifts.add(new CoordinatesShift(-i, i));
        }

        return coordinatesShifts;
    }
}
