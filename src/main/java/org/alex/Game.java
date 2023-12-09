package org.alex;

import org.alex.board.Board;
import org.alex.board.BoardConsoleRender;
import org.alex.check.GameState;
import org.alex.check.GameStateChecker;
import org.alex.check.MateGameStateChecker;
import org.alex.check.StaleMateChecker;

import java.util.List;

public class Game {

    private final Board board;

    private  Color colorMove = Color.WHITE;

    private final BoardConsoleRender render = new BoardConsoleRender();

    private final List<GameStateChecker> gameStateCheckers = List.of(
            new StaleMateChecker(), new MateGameStateChecker());

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        GameState state = determineGameState(board, colorMove);
        while (state == GameState.ONGOING) {
            render.render(board);
            Move move = InputCoordinates.inputMove(board, colorMove, render);
            board.makeMove(move);
            colorMove = colorMove.opposite();
            state = determineGameState(board, colorMove);
            // make move
            // pass move
        }
        render.render(board);
        System.out.println("Game ended with state: " + state);
    }

    public GameState determineGameState(Board board, Color color) {
        for (GameStateChecker gameStateChecker: gameStateCheckers) {
            GameState state = gameStateChecker.check(board, color);
            if (state != GameState.ONGOING) {
                return state;
            }
        }
        return  GameState.ONGOING;
    }
}
