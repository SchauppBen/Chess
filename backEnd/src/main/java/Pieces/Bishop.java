package Pieces;

import ChessBoard.*;

public class Bishop extends Piece{

    private final String pieceType = "Bishop";

    public Bishop(char color) {
        super(3, color);
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
