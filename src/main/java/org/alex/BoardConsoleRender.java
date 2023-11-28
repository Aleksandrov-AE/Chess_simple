package org.alex;

import org.alex.pieces.Piece;

public class BoardConsoleRender {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    public static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";

    public static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public void render(Board board) {
        for (int i = 8; i >= 1; i--) {
            StringBuilder line = new StringBuilder();
            for (Horizontal horizontal: Horizontal.values()) {
                if (board.isSquareEmpty(new Coordinates(horizontal, i))) {
                    line.append(getSpriteForEmptySquare(new Coordinates(horizontal, i)));
                } else {
                    line.append(getPieceSprite(board.getPiese(new Coordinates(horizontal, i))));
                }
            }
            line.append(ANSI_RESET);
            System.out.println(line);

        }
    }

    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareDark) {
        String result = sprite;

        if (pieceColor == Color.WHITE) {
            result = ANSI_WHITE_PIECE_COLOR + result;
        } else {
            result = ANSI_BLACK_PIECE_COLOR + result;
        }

        if (isSquareDark) {
            result = ANSI_BLACK_SQUARE_BACKGROUND +  result;
        } else {
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        }
        return result;
    }

    private String getSpriteForEmptySquare(Coordinates coordinates) {
        return colorizeSprite("    ", Color.WHITE, Board.isSquareDark(coordinates));
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

    private String getPieceSprite(Piece piece) {
        return colorizeSprite(" " + selectUnicodePiece(piece) + " ", piece.getColor(), Board.isSquareDark(piece.getCoordinates()));
    }
}
