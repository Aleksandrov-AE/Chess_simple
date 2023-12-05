package org.alex.pieces;

import java.util.HashSet;
import java.util.Set;

public interface IRook {
    default Set<CoordinatesShift> rookShift() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();
        for (int i = -7; i <= 7; i++) {
            if (i == 0) {
                continue;
            }
            coordinatesShifts.add(new CoordinatesShift(0, i));
            coordinatesShifts.add(new CoordinatesShift(i, 0));
        }
        return coordinatesShifts;
    }
}
