package org.alex;

import org.alex.pieces.*;

import java.util.HashMap;

public class Board {
    private final HashMap<Coordinates, Piece> piecePosition = new HashMap<>();

    public void  setPiece(Coordinates coordinates, Piece piece) {
        piece.setCoordinates(coordinates);
        piecePosition.put(coordinates, piece);
    }

    public Piece removePiece(Coordinates coordinates) {
        return piecePosition.remove(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !piecePosition.containsKey(coordinates);
    }

    public Piece getPiese(Coordinates coordinates) {
        return piecePosition.get(coordinates);
    }

    public  void  setupDefaultBoard() {
        for (Horizontal horizontal: Horizontal.values()) {
            setPiece(new Coordinates(horizontal, 1), new Knight(Color.WHITE, new Coordinates(horizontal, 1)));
            setPiece(new Coordinates(horizontal, 2), new Bishop(Color.WHITE, new Coordinates(horizontal, 2)));
            setPiece(new Coordinates(horizontal, 7), new Bishop(Color.BLACK, new Coordinates(horizontal, 7)));
            setPiece(new Coordinates(horizontal, 8), new Knight(Color.BLACK, new Coordinates(horizontal, 8)));
        }

        setPiece(new Coordinates(Horizontal.A, 1), new Rook(Color.WHITE, new Coordinates(Horizontal.A, 1)));
        setPiece(new Coordinates(Horizontal.H, 1), new Rook(Color.WHITE, new Coordinates(Horizontal.H, 1)));
        setPiece(new Coordinates(Horizontal.A, 8), new Rook(Color.BLACK, new Coordinates(Horizontal.A, 8)));
        setPiece(new Coordinates(Horizontal.H, 8), new Rook(Color.BLACK, new Coordinates(Horizontal.H, 8)));

        // set knights
        setPiece(new Coordinates(Horizontal.B, 1), new Knight(Color.WHITE, new Coordinates(Horizontal.B, 1)));
        setPiece(new Coordinates(Horizontal.G, 1), new Knight(Color.WHITE, new Coordinates(Horizontal.G, 1)));
        setPiece(new Coordinates(Horizontal.B, 8), new Knight(Color.BLACK, new Coordinates(Horizontal.B, 8)));
        setPiece(new Coordinates(Horizontal.G, 8), new Knight(Color.BLACK, new Coordinates(Horizontal.G, 8)));

        // set bishops
        setPiece(new Coordinates(Horizontal.C, 1), new Bishop(Color.WHITE, new Coordinates(Horizontal.C, 1)));
        setPiece(new Coordinates(Horizontal.F, 1), new Bishop(Color.WHITE, new Coordinates(Horizontal.F, 1)));
        setPiece(new Coordinates(Horizontal.C, 8), new Bishop(Color.BLACK, new Coordinates(Horizontal.C, 8)));
        setPiece(new Coordinates(Horizontal.F, 8), new Bishop(Color.BLACK, new Coordinates(Horizontal.F, 8)));

        // set queens
        setPiece(new Coordinates(Horizontal.D, 1), new Queen(Color.WHITE, new Coordinates(Horizontal.D, 1)));
        setPiece(new Coordinates(Horizontal.D, 8), new Queen(Color.BLACK, new Coordinates(Horizontal.D, 8)));

        // set kings
        setPiece(new Coordinates(Horizontal.E, 1), new King(Color.WHITE, new Coordinates(Horizontal.E, 1)));
        setPiece(new Coordinates(Horizontal.E, 8), new King(Color.BLACK, new Coordinates(Horizontal.E, 8)));
    }

    public static boolean isSquareDark(Coordinates coordinates) {
        return (((coordinates.horizontal.ordinal() - 1) + coordinates.vertical) % 2) == 0;
    }

    public void movePiece(Coordinates coordinates, Coordinates newCoordinates) {
        Piece piece = removePiece(coordinates);
        setPiece(newCoordinates, piece);

    }
}
