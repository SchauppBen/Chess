package Pieces;

import ChessBoard.*;

public class Rook extends Piece{

    private boolean hasMoved = false;
    private final String pieceType = "Rook";

    public Rook(char color) {
        super(5, color);
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
