package com.techelevator.Pieces;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.techelevator.ChessBoard.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pieceType")
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
