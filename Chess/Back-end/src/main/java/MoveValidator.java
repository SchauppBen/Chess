import ChessBoard.*;


public class MoveValidator {

    public boolean validateMove(String squarePieceIsOn, String move, Board board, char playerTurn) {

        if (move.length() < 2 || move.length() > 6) {
            return false;
        }

        Square square = board.getSquareAtCoordinate(squarePieceIsOn);
        if (!square.hasPieceOnSquare()) {
            return false;
        }

        if (square.getPieceOnSquare().getCOLOR() != playerTurn) {
            return false;
        }

        if (move.length() == 2) {
            if (square.getPieceOnSquare().getPieceType().equals("Pawn")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            } else {
                return false;
            }
        } else if (move.length() == 3) {
            if (move.charAt(0) == 'N' && square.getPieceOnSquare().getPieceType().equals("Knight")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            } else if (move.charAt(0) == 'B' && square.getPieceOnSquare().getPieceType().equals("Bishop")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            } else if (move.charAt(0) == 'R' && square.getPieceOnSquare().getPieceType().equals("Rook")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            } else if (move.charAt(0) == 'Q' && square.getPieceOnSquare().getPieceType().equals("Queen")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            } else if (move.charAt(0) == 'K' && square.getPieceOnSquare().getPieceType().equals("King")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            }
            return false;
        } else if (move.length() == 4) {
            if (move.charAt(1) == 'x') {
                if (move.charAt(0) >= 97 && move.charAt(0) <= 104 &&
                        square.getPieceOnSquare().getPieceType().equals("Pawn")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                } else if (move.charAt(0) == 'N' && square.getPieceOnSquare().getPieceType().equals("Knight")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                } else if (move.charAt(0) == 'B' && square.getPieceOnSquare().getPieceType().equals("Bishop")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                } else if (move.charAt(0) == 'R' && square.getPieceOnSquare().getPieceType().equals("Rook")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                } else if (move.charAt(0) == 'Q' && square.getPieceOnSquare().getPieceType().equals("Queen")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                } else if (move.charAt(0) == 'K' && square.getPieceOnSquare().getPieceType().equals("King")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                }
            } else if (move.charAt(2) == '=') {
                if (move.charAt(0) >= 97 && move.charAt(0) <= 104 &&
                        square.getPieceOnSquare().getPieceType().equals("Pawn")) {
                    return square.getPieceOnSquare().isValidMove(move, board);
                }
            }
        } else if(move.length() == 5) {

        } else if (move.length() == 6) {
            if (move.charAt(0) >= 97 && move.charAt(0) <= 104 &&
                    square.getPieceOnSquare().getPieceType().equals("Pawn")) {
                return square.getPieceOnSquare().isValidMove(move, board);
            }
        }

        return false;
    }


    public boolean validateSquare(String squarePieceIsOn) {
        if (squarePieceIsOn.length() != 2) {
            return false;
        }
        return squarePieceIsOn.charAt(0) >= 97 && squarePieceIsOn.charAt(0) <= 104 &&
                squarePieceIsOn.charAt(1) >= 49 && squarePieceIsOn.charAt(1) <= 56;
    }

}
