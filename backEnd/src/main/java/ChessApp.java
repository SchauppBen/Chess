import ChessBoard.*;
import Pieces.*;

public class ChessApp {

    private static ChessUI ui = new ChessUI();
    private static FENReader fen = new FENReader();
    private static boolean gameOver = false;
    private static char playerTurn = 'w';
    public static void main(String[] args) {

        MoveValidator moveValidator = new MoveValidator();
        Board board = defaultPosition();
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
        }
    }

    public static Board defaultPosition() {
        try {
            return fen.makeBoardFromFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR");

        } catch(InvalidFENException fenE) {
            System.out.println(fenE.getStackTrace());
        }
        return new Board();
    }
}
