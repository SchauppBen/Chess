package Pieces;

import ChessBoard.*;

public class Queen extends Piece{

    private final String pieceType = "Queen";

    public Queen(char color) {
        super(9, color);
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
