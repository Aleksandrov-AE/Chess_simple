package org.alex.pieces;

import org.alex.board.Board;
import org.alex.Color;
import org.alex.Coordinates;
import org.alex.board.BoardUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getShift() {
        Set<CoordinatesShift> coordinatesShifts = new HashSet<>();
        if (this.getColor() == Color.WHITE) {
            coordinatesShifts.add(new CoordinatesShift(0, 1));
            coordinatesShifts.add(new CoordinatesShift(1, 1));
            coordinatesShifts.add(new CoordinatesShift(-1, 1));
            if (this.getCoordinates().vertical == 2) {
                coordinatesShifts.add(new CoordinatesShift(0, 2));
            }

        } else {
            coordinatesShifts.add(new CoordinatesShift(0, -1));
            coordinatesShifts.add(new CoordinatesShift(1, -1));
            coordinatesShifts.add(new CoordinatesShift(-1, -1));
            if (this.getCoordinates().vertical == 7) {
                coordinatesShifts.add(new CoordinatesShift(0, -2));
            }
        }
        return coordinatesShifts;
    }

    @Override
    protected boolean squareAvailableForMove(Coordinates newCoordinates, Board board) {
        if (newCoordinates.horizontal.ordinal() == this.getCoordinates().horizontal.ordinal()) {
            if (Math.abs(newCoordinates.vertical - this.getCoordinates().vertical) == 2) {
                List<Coordinates> between = BoardUtil.getVerticalCoordinates(newCoordinates, this.getCoordinates());
                return board.isSquareEmpty(between.get(0))
                        && board.isSquareEmpty(newCoordinates);
            } else {
                return board.isSquareEmpty(newCoordinates);
            }

        } else {
            return squareAvailableForAttack(newCoordinates, board);
        }
    }

    @Override
    protected boolean squareAvailableForAttack(Coordinates newCoordinates, Board board) {
        return (!board.isSquareEmpty(newCoordinates) && board.getPiese(newCoordinates).getColor() != this.getColor());
    }
}
