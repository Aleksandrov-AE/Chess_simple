package org.alex;

import org.alex.pieces.Bishop;
import org.alex.pieces.Knight;
import org.alex.pieces.Piece;

import java.util.HashMap;

public class Board {
    private final HashMap<Coordinates, Piece> piecePosition = new HashMap<>();

    public void  setPiece(Coordinates coordinates, Piece piece) {
        piece.setCoordinates(coordinates);
        piecePosition.put(coordinates, piece);
    }

    public  void  setupDefaultBoard() {
        for (Horizontal horizontal: Horizontal.values()) {
            setPiece(new Coordinates(horizontal, 1), new Knight(Color.WHITE, new Coordinates(horizontal, 1)));
            setPiece(new Coordinates(horizontal, 2), new Bishop(Color.WHITE, new Coordinates(horizontal, 2)));
            setPiece(new Coordinates(horizontal, 7), new Bishop(Color.BLACK, new Coordinates(horizontal, 7)));
            setPiece(new Coordinates(horizontal, 8), new Knight(Color.BLACK, new Coordinates(horizontal, 8)));
        }
    }
}
