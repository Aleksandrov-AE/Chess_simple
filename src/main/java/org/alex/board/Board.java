package org.alex.board;

import org.alex.Color;
import org.alex.Coordinates;
import org.alex.Move;
import org.alex.pieces.*;

import java.util.*;

public class Board {

    final String startPotition;
    private final HashMap<Coordinates, Piece> pieces = new HashMap<>();

    List<Move> moveHistory = new ArrayList<>();

    public Board(String fen) {
        this.startPotition = fen;
    }

    public void  setPiece(Coordinates coordinates, Piece piece) {
        piece.setCoordinates(coordinates);
        pieces.put(coordinates, piece);
    }

    public Piece removePiece(Coordinates coordinates) {
        return pieces.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public Piece getPiese(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    public List<Piece> getPiesesWithColor(Color color) {
        List<Piece> result = new ArrayList<>();
        for (Piece piece: pieces.values()) {
            if (piece.getColor() == color) {
                result.add(piece);
            }
        }
        return  result;
    }

    public boolean isAttackSquareForColor(Coordinates coordinates, Color color) {
        List<Piece> piesesWithColor = getPiesesWithColor(color.opposite());
        for (Piece piece: piesesWithColor) {
            Set<Coordinates> attackSquare = piece.getAttackSquare(this);
            if (attackSquare.contains(coordinates)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.horizontal.ordinal() - 1) + coordinates.vertical) % 2) == 0;
    }

    public void makeMove(Move move) {
        Piece piece = removePiece(move.from);
        setPiece(move.to, piece);
        moveHistory.add(move);

    }

    public boolean isSquareAttackedByColor(Coordinates coordinates, Color color) {
        List<Piece> pieces = getPiesesWithColor(color);

        for (Piece piece : pieces) {
            Set<Coordinates> attackedSquares = piece.getAttackSquare(this);

            if (attackedSquares.contains(coordinates)) {
                return true;
            }
        }

        return false;
    }
}
