package org.alex.board;

import org.alex.Color;
import org.alex.Coordinates;
import org.alex.Horizontal;
import org.alex.pieces.Piece;

import java.util.Set;

import static java.util.Collections.emptySet;

public class BoardConsoleRender {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public static final String ANSI_HIGHLIGHTED_SQUARE_BACKGROUND = "\u001B[42m";

    public void render(Board board, Piece piece) {
        Set<Coordinates> avilableMovePiece = emptySet();
        if (piece != null) {
            avilableMovePiece = piece.getAvailableSquare(board);
        }

        for (int i = 8; i >= 1; i--) {
            StringBuilder line = new StringBuilder();
            for (Horizontal horizontal: Horizontal.values()) {
                Coordinates coordinates = new Coordinates(horizontal, i);
                boolean highlighted = avilableMovePiece.contains(coordinates);
                if (board.isSquareEmpty(coordinates)) {
                    line.append(getSpriteForEmptySquare(coordinates, highlighted));
                } else {
                    line.append(getPieceSprite(board.getPiese(coordinates), highlighted));
                }
            }
            line.append(ANSI_RESET);
            line.append(i);
            System.out.println(line);

        }

        for (Horizontal horizontal: Horizontal.values()) {
            System.out.print(" " + horizontal.name() + "  ");
        }
        System.out.println();
    }

    public void render(Board board) {
        render(board, null);
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark, boolean highlighted) {
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (highlighted) {
            result = ANSI_HIGHLIGHTED_SQUARE_BACKGROUND +  result;
        }

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND +  result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates, boolean highlighted) {
        return colorizeSprite("    ", Color.WHITE, Board.isSquareDark(coordinates), highlighted);
    }

    private String selectUnicodePiece(Piece piece) {
        switch (piece.getClass().getSimpleName()) {
            case "Pawn":
                return "♟︎";

            case "Knight":
                return "♞";

            case "Bishop":
                return "♝";

            case "Rook":
                return "♜";

            case "Queen":
                return "♛";

            case "King":
                return "♚";
            default:
                return "  ";
        }
    }

    private String getPieceSprite(Piece piece, boolean highlighted) {
        return colorizeSprite(" " + selectUnicodePiece(piece) + " ", piece.getColor(), Board.isSquareDark(piece.getCoordinates()), highlighted);
    }
}
