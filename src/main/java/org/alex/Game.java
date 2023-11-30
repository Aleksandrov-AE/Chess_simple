package org.alex;

import org.alex.pieces.Piece;

import java.util.Set;

public class Game {

    private Board board;

    private BoardConsoleRender render = new BoardConsoleRender();

    public Game(Board board) {
        this.board = board;
    }

    private  boolean isWhiteMove = true;

    public void gameLoop() {
        while (true) {
            render.render(board);
            Coordinates coordinates = new InputCoordinates().inputForColors(board, isWhiteMove ? Color.WHITE : Color.BLACK);
            Piece piece = board.getPiese(coordinates);
            Set<Coordinates> availbleMove = piece.getAvailableSquare(board);
            Coordinates newCoordinates = new InputCoordinates().inputAvailableSquare(availbleMove);
            board.movePiece(coordinates, newCoordinates);
            isWhiteMove = !isWhiteMove;

            // make move
            // pass move
        }

    }
}
