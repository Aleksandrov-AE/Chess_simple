package org.alex;

import org.alex.pieces.Piece;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().convertFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        BoardConsoleRender boardConsoleRender = new BoardConsoleRender();
        //boardConsoleRender.render(board);
        //List<Coordinates> list = BoardUtil.getDiagonalBetween(new Coordinates(Horizontal.A, 1), new Coordinates(Horizontal.H, 8));
        //System.out.println(list);
        Game game = new Game(board);
        game.gameLoop();
    }
}