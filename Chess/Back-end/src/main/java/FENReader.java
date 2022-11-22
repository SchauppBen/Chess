import ChessBoard.*;
import Pieces.*;

public class FENReader {


    public String generateFEN(Board board) {

        String FEN = "";
        for(int i = 0; i < board.getBoard().length; i++) {
            int emptySpaces = 0;
            for (int j = 0; j < board.getBoard()[i].length; j++) {

                Square currentSquare = board.getBoard()[i][j];
                if (!currentSquare.hasPieceOnSquare()) {
                    emptySpaces++;
                    if (j == board.getBoard()[i].length - 1) {
                        FEN += emptySpaces;
                        emptySpaces = 0;
                    }
                } else {
                if (emptySpaces > 0) {
                    FEN += emptySpaces;
                    emptySpaces = 0;
                }
                switch(currentSquare.getPieceOnSquare().getPieceType()) {
                    case "Pawn":
                        if (currentSquare.getPieceOnSquare().getCOLOR() == 'b') {
                            FEN += "p";
                            break;
                        } else {
                            FEN += "P";
                            break;
                        }
                    case "Rook":
                        if (currentSquare.getPieceOnSquare().getCOLOR() == 'b') {
                            FEN += "r";
                            break;
                        } else {
                            FEN += "R";
                            break;
                        }
                    case "Knight":
                        if (currentSquare.getPieceOnSquare().getCOLOR() == 'b') {
                            FEN += "n";
                            break;
                        } else {
                            FEN += "N";
                            break;
                        }
                    case "Bishop":
                        if (currentSquare.getPieceOnSquare().getCOLOR() == 'b') {
                            FEN += "b";
                            break;
                        } else {
                            FEN += "B";
                            break;
                        }
                    case "Queen":
                        if (currentSquare.getPieceOnSquare().getCOLOR() == 'b') {
                            FEN += "q";
                            break;
                        } else {
                            FEN += "Q";
                            break;
                        }
                    case "King":
                        if (currentSquare.getPieceOnSquare().getCOLOR() == 'b') {
                            FEN += "k";
                            break;
                        } else {
                            FEN += "K";
                            break;
                        }
                    }
                }
            }
            if (!(i == 7)) {
                FEN += "/";
            }
        }

        return FEN;
    }

    public Board makeBoardFromFEN(String FEN) throws InvalidFENException {
        String[] FENArray = FEN.split("/");
        if(FENArray.length != 8) {
            throw new InvalidFENException();
        }
        Board board = new Board();

        for(int i = 0; i < board.getBoard().length; i++) {
            int counter = 0;
            String currentLine = FENArray[i];
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                int emptySquares = 0;
                try {
                    emptySquares = Integer.parseInt(currentLine.substring(counter, counter + 1));
                    counter++;
                    j += emptySquares - 1;
                    if (counter > currentLine.length() || j > board.getBoard()[i].length) {
                        throw new InvalidFENException();
                    }
                } catch (NumberFormatException nfe) {
                    switch(currentLine.charAt(counter)) {
                        case 'p':
                            board.getBoard()[i][j].setPieceOnSquare(new Pawn('b'));
                            counter++;
                            break;
                        case 'P':
                            board.getBoard()[i][j].setPieceOnSquare(new Pawn('w'));
                            counter++;
                            break;
                        case 'r':
                            board.getBoard()[i][j].setPieceOnSquare(new Rook('b'));
                            counter++;
                            break;
                        case 'b':
                            board.getBoard()[i][j].setPieceOnSquare(new Bishop('b'));
                            counter++;
                            break;
                        case 'n':
                            board.getBoard()[i][j].setPieceOnSquare(new Knight('b'));
                            counter++;
                            break;
                        case 'q':
                            board.getBoard()[i][j].setPieceOnSquare(new Queen('b'));
                            counter++;
                            break;
                        case 'k':
                            board.getBoard()[i][j].setPieceOnSquare(new King('b'));
                            counter++;
                            break;
                        case 'R':
                            board.getBoard()[i][j].setPieceOnSquare(new Rook('w'));
                            counter++;
                            break;
                        case 'B':
                            board.getBoard()[i][j].setPieceOnSquare(new Bishop('w'));
                            counter++;
                            break;
                        case 'N':
                            board.getBoard()[i][j].setPieceOnSquare(new Knight('w'));
                            counter++;
                            break;
                        case 'Q':
                            board.getBoard()[i][j].setPieceOnSquare(new Queen('w'));
                            counter++;
                            break;
                        case 'K':
                            board.getBoard()[i][j].setPieceOnSquare(new King('w'));
                            counter++;
                            break;
                        default:
                            throw new InvalidFENException();
                    }
                    board.addPiece(board.getBoard()[i][j].getPieceOnSquare());
                }
            }
        }

        return board;
    }

}
