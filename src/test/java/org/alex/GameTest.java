package org.alex;

import org.alex.board.BoardFactory;
import org.alex.board.Board;
import org.alex.check.GameState;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void gameEndInStalemate() {
        Board board = new BoardFactory().createBoard("4k3/R7/4N3/7/8/4K3/8/8  w KQkq");
        Game game = new Game(board);
        assertEquals(GameState.STALEMATE, game.determineGameState(board, Color.BLACK));
    }

    @Test
    void gameEndsMateToWhite() {
        Board board = new BoardFactory().createBoard("rnb1kbnr/ppp2ppp/3pp3/8/5PPq/8/PPPPP2P/RNBQKBNR  w KQkq");
        Game game = new Game(board);
        assertEquals(GameState.CHECKMATE_TO_WHITE_KING, game.determineGameState(board, Color.WHITE));
    }

    @Test
    void gameEndsMateToBlack() {
        Board board = new BoardFactory().createBoard("rnbqkbnr/ppppp2p/8/5ppQ/8/4PP2/PPPP2PP/RNB1KBNR  w KQkq");
        Game game = new Game(board);
        assertEquals(GameState.CHECKMATE_TO_BLACK_KING, game.determineGameState(board, Color.BLACK));
    }

}
