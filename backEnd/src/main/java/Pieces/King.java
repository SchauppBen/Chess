package Pieces;

import ChessBoard.*;

public class King extends Piece {

    private boolean hasMoved;
    private final String pieceType = "King";

    public King(char color) {
        super(Integer.MAX_VALUE, color);
    }

    @Override
    public boolean isValidMove(String move, Board board) {
        return false;
    }

    @Override
    public void move(Square square) {

    }

    @Override
    public String getPieceType() {
        return pieceType;
    }
}
