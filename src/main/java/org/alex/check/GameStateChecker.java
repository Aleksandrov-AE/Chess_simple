package org.alex.check;
import org.alex.Color;
import org.alex.board.Board;

public abstract class GameStateChecker {
        public abstract GameState check(Board board, Color color);
}
