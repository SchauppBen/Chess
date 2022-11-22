package Pieces;

import ChessBoard.*;

public abstract class Piece {

    private final int VALUE;
    private final char COLOR;
    private String pieceType;
    private Square squareOn;

    public Piece(int value, char color) {
        this.VALUE = value;
        this.COLOR = color;
    }

    public abstract boolean isValidMove(String move, Board board);
    public abstract void move(Square square);
    public abstract String getPieceType();

    public Square getSquareOn() {
        return squareOn;
    }

    public void setSquareOn(Square squareOn) {
        this.squareOn = squareOn;
    }

    public String getSquareCoordinates() {
        return squareOn.getCharCoordinate() + "" + squareOn.getNumCoordinate();
    }

    public int getVALUE() {
        return VALUE;
    }

    public char getCOLOR() {
        return COLOR;
    }
}
