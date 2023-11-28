package org.alex;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultBoard();
        BoardConsoleRender boardConsoleRender = new BoardConsoleRender();
        boardConsoleRender.render(board);
    }
}