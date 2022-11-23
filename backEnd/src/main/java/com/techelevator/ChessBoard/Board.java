package com.techelevator.ChessBoard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techelevator.Pieces.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Board {

    private final int NUM_SQUARES = 64;
    private Square[][] board = new Square[8][8];
    private List<Piece> listOfPieces = new ArrayList<>();
    private Map<String, Square> mapCoordinatesToSquare = new HashMap<>();

    public Board() {
        char letter = 'a';
        int row = 8;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if ((j + i) % 2 == 0) {
                    board[i][j] = new Square(letter, row, "Light");
                    mapCoordinatesToSquare.put(letter + "" + row, board[i][j]);

                } else {
                    board[i][j] = new Square(letter, row, "Dark");
                    mapCoordinatesToSquare.put(letter + "" + row, board[i][j]);
                }
                letter++;
            }
            row--;
            letter = 'a';
        }
    }

    public void addPiece(Piece piece) {
        listOfPieces.add(piece);
    }

    public Square getSquareAtCoordinate(String coordinate) {
        return mapCoordinatesToSquare.get(coordinate);
    }

    public Square[][] getBoard() {
        return board;
    }

}
