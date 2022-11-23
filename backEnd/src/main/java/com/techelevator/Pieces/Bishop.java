package com.techelevator.Pieces;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.techelevator.ChessBoard.*;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pieceType")
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
