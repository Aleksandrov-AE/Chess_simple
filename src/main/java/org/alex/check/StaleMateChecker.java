package org.alex.check;

import org.alex.Color;
import org.alex.Coordinates;
import org.alex.board.Board;
import org.alex.pieces.Piece;

import java.util.List;
import java.util.Set;

public class StaleMateChecker extends GameStateChecker {
    @Override
    public GameState check(Board board, Color color) {
        List<Piece> pieses = board.getPiesesWithColor(color);
        for (Piece piece: pieses) {
            Set<Coordinates> availableSquare = piece.getAvailableSquare(board);
            if (availableSquare.size() > 0) {
                return GameState.ONGOING;
            }
        }
        return GameState.STALEMATE;
    }
}
