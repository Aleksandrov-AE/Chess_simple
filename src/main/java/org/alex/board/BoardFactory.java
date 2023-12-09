package org.alex.board;

import org.alex.Coordinates;
import org.alex.Horizontal;
import org.alex.Move;
import org.alex.pieces.PieceFactory;

public class BoardFactory {

    PieceFactory pieceFactory = new PieceFactory();

    public Board convertFen(String fen) {
        Board board = new Board(fen);
        String[] parts = fen.split(" ");
        String[] fenRows =    parts[0].split("/");
        for (int i = 0; i < fenRows.length; i++) {
            int vertical = 8 - i;
            int indexHorizont = 0;
            for (int j = 0; j < fenRows[i].length(); j++) {
                char ch = fenRows[i].charAt(j);
                if (Character.isDigit(ch)) {
                    indexHorizont += Character.getNumericValue(ch);
                    continue;
                } else {
                    Horizontal horizontal = Horizontal.values()[indexHorizont];
                    Coordinates coordinates = new Coordinates(horizontal, vertical);
                    board.setPiece(coordinates, pieceFactory.fromFenChar(ch, coordinates));
                }
                indexHorizont++;
            }
        }
        return board;
    }

    public Board copy(Board board) {
        Board clone = convertFen(board.startPotition);
        for (Move move: board.moveHistory) {
            clone.makeMove(move);
        }
        return  clone;
    }
}
