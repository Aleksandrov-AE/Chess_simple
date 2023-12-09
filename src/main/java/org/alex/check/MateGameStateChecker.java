package org.alex.check;
import org.alex.Color;
import org.alex.Coordinates;
import org.alex.Move;
import org.alex.board.BoardFactory;
import org.alex.pieces.King;
import org.alex.pieces.Piece;
import org.alex.board.Board;
import java.util.List;
import java.util.Set;

public class MateGameStateChecker extends GameStateChecker {
    @Override
    public GameState check(Board board, Color color) {
        //king exist
        Piece king = board.getPiesesWithColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();

        if (!board.isSquareAttackedByColor(king.getCoordinates(), color.opposite())) {
            return GameState.ONGOING;
        }

        List<Piece> pieces = board.getPiesesWithColor(color);
        for (Piece piece : pieces) {
            Set<Coordinates> availableMoveSquares = piece.getAvailableSquare(board);

            for (Coordinates coordinates : availableMoveSquares) {
                Board clone = new BoardFactory().copy(board);
                clone.makeMove(new Move(piece.getCoordinates(), coordinates));

                Piece clonedKing = clone.getPiesesWithColor(color).stream().filter(p -> p instanceof King).findFirst().get();

                if (!clone.isSquareAttackedByColor(clonedKing.getCoordinates(), color.opposite())) {
                    return GameState.ONGOING;
                }
            }
        }

        if (color == Color.WHITE) {
            return GameState.CHECKMATE_TO_WHITE_KING;
        } else {
            return GameState.CHECKMATE_TO_BLACK_KING;
        }
    }
}
