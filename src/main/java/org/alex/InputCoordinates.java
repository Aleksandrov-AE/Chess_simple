package org.alex;

import org.alex.board.Board;
import org.alex.board.BoardConsoleRender;
import org.alex.board.BoardFactory;
import org.alex.pieces.King;
import org.alex.pieces.Piece;

import java.util.Scanner;
import java.util.Set;

public class InputCoordinates {

    Scanner scanner = new Scanner(System.in);

    public Coordinates input() {
        while (true) {
            String line = scanner.nextLine();
            if (line.length() != 2) {
                System.out.println("Invalid format");
                continue;
            }
            char horizontal =  Character.toUpperCase(line.charAt(0));
            char vertical = line.charAt(1);
            if (!Character.isLetter(horizontal) || !Character.isDigit(vertical)) {
                System.out.println("Invalid format");
                continue;
            }

            if (!Horizontal.checkChar(horizontal)) {
                System.out.println("Invalid format");
                continue;
            }
            int verticalInt = Character.getNumericValue(vertical);
            if (verticalInt < 1 || verticalInt > 8) {
                System.out.println("Invalid format");
                continue;
            }
            return new Coordinates(Horizontal.valueOf(String.valueOf(horizontal)), verticalInt);

        }

    }

    public Coordinates inputForColors(Board board, Color color) {
        while (true) {
            System.out.println("Enter coordinate piece to move " + color.name());
            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty square");
                continue;
            }

            if (board.getPiese(coordinates).getColor() != color) {
                System.out.println("Wrong color");
                continue;
            }

            if (board.getPiese(coordinates).getAvailableSquare(board).isEmpty()) {
                System.out.println("Blocked piece");
                continue;
            }
            return coordinates;
        }

    }

    public Coordinates inputAvailableSquare(Set<Coordinates> availbleMove) {
        while (true) {
            System.out.println("Enter movement coordinates");
            Coordinates coordinates = input();
            if (!availbleMove.contains(coordinates)) {
                System.out.println("Inaccessible move");
                continue;
            }
            return coordinates;
        }
    }

    public static Move inputMove(Board board, Color color, BoardConsoleRender render) {
        while (true) {
            Coordinates from = new InputCoordinates().inputForColors(board, color);
            Piece piece = board.getPiese(from);
            render.render(board, piece);
            Set<Coordinates> availbleMove = piece.getAvailableSquare(board);
            Coordinates target = new InputCoordinates().inputAvailableSquare(availbleMove);
            Move move = new Move(from, target);
            if (checkKingAfterMove(board, color, move)) {
                System.out.println("Your King is under attack");
                continue;
            }
            return move;
        }
    }

    private static boolean checkKingAfterMove(Board board, Color color, Move move) {
        Board clone = new BoardFactory().copy(board);
        clone.makeMove(move);
        //King exist
        Piece king = clone.getPiesesWithColor(color)
                .stream().filter(piece -> piece instanceof King).findFirst().get();
        return clone.isSquareAttackedByColor(king.getCoordinates(), color.opposite());
    }
}
