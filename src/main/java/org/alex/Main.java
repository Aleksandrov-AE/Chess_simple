package org.alex;

import org.alex.pieces.Piece;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new BoardFactory().convertFen("R2R4//2r2Q/2P1r1/1B1Q1/3N1r1// w KQkq");
        BoardConsoleRender boardConsoleRender = new BoardConsoleRender();
        //boardConsoleRender.render(board);
        //List<Coordinates> list = BoardUtil.getDiagonalBetween(new Coordinates(Horizontal.A, 1), new Coordinates(Horizontal.H, 8));
        //System.out.println(list);
        Game game = new Game(board);
        game.gameLoop();
    }
}