package org.alex;
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultBoard();
        Game game = new Game(board);
        game.gameLoop();
    }
}