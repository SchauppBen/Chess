package Pieces;

import ChessBoard.*;
public class Knight extends Piece{

    private final String pieceType = "Knight";

    public Knight(char color) {
        super(3, color);
    }

    @Override
    public boolean isValidMove(String move, Board board) {

        if (move.length() == 3) {
            char moveCharCoordinate = move.charAt(1);
            int moveNumCoordinate = Character.getNumericValue(2);

            Square newSquare = board.getSquareAtCoordinate(moveCharCoordinate + "" + moveNumCoordinate);
            if (newSquare != null && !newSquare.hasPieceOnSquare()) {
                move(newSquare);
                return true;
            }
        } else if (move.length() == 4) {
            if (move.charAt(1) == 'x') {
                char moveCharCoordinate = move.charAt(2);
                int moveNumCoordinate = Character.getNumericValue(3);
                Square newSquare = board.getSquareAtCoordinate(moveCharCoordinate + "" + moveNumCoordinate);
                if (newSquare!= null && newSquare.hasPieceOnSquare() && newSquare.getPieceOnSquare().getCOLOR() != super.getCOLOR()) {
                    move(newSquare);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void move(Square square) {

        getSquareOn().removePiece();
        square.setPieceOnSquare(this);
    }

    @Override
    public String getPieceType() {
        return pieceType;
    }
}
