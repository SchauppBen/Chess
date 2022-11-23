package com.techelevator;

import com.techelevator.ChessBoard.*;
import com.techelevator.Pieces.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

    private final ChessUI ui;
    private final FENReader fen;
    private char playerTurn = 'w';

    public ChessController(ChessUI ui, FENReader fen) {
        this.ui = ui;
        this.fen = fen;
    }

    @GetMapping(path = "/board")
    public Board startGame() {
        MoveValidator moveValidator = new MoveValidator();
        return defaultPosition();
        /*boolean gameOver = false;
        while(!gameOver) {
            ui.printFEN(fen.generateFEN(board));
            boolean checkMove = false;
            String squarePieceIsOn = "";
            while (!checkMove) {
                ui.pieceToMove();
                squarePieceIsOn = ui.getUserInput();
                if (!moveValidator.validateSquare(squarePieceIsOn)) {
                    ui.invalidSquare();
                    continue;
                }
                ui.askForMove();
                checkMove = moveValidator.validateMove(squarePieceIsOn, ui.getUserInput(), board, playerTurn);
                if (!checkMove) {
                    ui.errorMessage();
                }
            }
            if(playerTurn == 'w') {
                playerTurn = 'b';
            } else {
                playerTurn = 'w';
            }
        }*/
    }

    public Board defaultPosition() {
        try {
            return fen.makeBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");

        } catch(InvalidFENException fenE) {
            System.out.println(fenE.getStackTrace());
        }
        return new Board();
    }
}
