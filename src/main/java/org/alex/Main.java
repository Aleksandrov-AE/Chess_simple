package org.alex;

import org.alex.board.Board;
import org.alex.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().convertFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq");
        Game game = new Game(board);
        game.gameLoop();
    }
}