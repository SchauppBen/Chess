package ChessBoard;

import Pieces.*;

public class Square {

    private final char charCoordinate;
    private final int numCoordinate;
    private final String color;
    private Piece pieceOnSquare;
    private boolean hasPieceOnSquare;

    public Square(char charCoordinate, int numCoordinate, String color) {
        this.charCoordinate = charCoordinate;
        this.numCoordinate = numCoordinate;
        this.color = color;
    }

    public void removePiece() {
        this.pieceOnSquare = null;
        hasPieceOnSquare = false;
    }

    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }

    public void setPieceOnSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
        pieceOnSquare.setSquareOn(this);
        hasPieceOnSquare = true;
    }

    public boolean hasPieceOnSquare() {
        return hasPieceOnSquare;
    }

    public char getCharCoordinate() {
        return charCoordinate;
    }

    public int getNumCoordinate() {
        return numCoordinate;
    }

    public String getColor() {
        return color;
    }
}
