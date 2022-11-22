package Pieces;

import ChessBoard.*;

public class Pawn extends Piece{

    private boolean hasMoved;
    private final String pieceType = "Pawn";

    public Pawn(char color) {
        super(1, color);
    }

    @Override
    public boolean isValidMove(String move, Board board) {

        if (move.length() > 6 || move.length() < 2 || move.length() == 3) {
            return false;
        }

        if (move.contains("=")) {
            return isValidPromotion(move, board);
        }

        char charCoordinate = super.getSquareCoordinates().charAt(0);
        int numCoordinate = Integer.parseInt(super.getSquareCoordinates().substring(1));

        String coordinate = "";
        if (move.length() == 2) {
            coordinate = move.charAt(0) + "" + move.charAt(1);
        } else {
            coordinate = move.charAt(2) + "" + move.charAt(3);
        }
        int moveNumCoordinate = Character.getNumericValue(coordinate.charAt(1));

        if ((moveNumCoordinate == 1 || moveNumCoordinate == 8) && !move.contains("=")) {
            return false;
        }

        if (charCoordinate != move.charAt(0)) {
            return false;
        }
        if (super.getCOLOR() == 'w') {
            if (move.charAt(1) == 'x') {
                if (numCoordinate + 1 != moveNumCoordinate) {
                    return false;
                } 
                if (charCoordinate - 1 == coordinate.charAt(0)) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        move(newSquare);
                        return true;
                    } else {
                        return false;
                    }
                } else if(charCoordinate + 1 == coordinate.charAt(0)) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        move(newSquare);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (move.length() != 2) {
                return false;
            } else if (numCoordinate + 1 != moveNumCoordinate &&
            (numCoordinate + 2) != moveNumCoordinate) {
                return false;
            } else if (numCoordinate + 2 <= moveNumCoordinate && hasMoved) {
                return false;
            } else if (numCoordinate + 2 == moveNumCoordinate && !hasMoved) {
                if (!board.getSquareAtCoordinate(coordinate).hasPieceOnSquare()) {

                }
                if  (!board.getSquareAtCoordinate(charCoordinate + "" + (numCoordinate + 1)).hasPieceOnSquare() &&
                        !board.getSquareAtCoordinate(coordinate).hasPieceOnSquare()) {
                    move(board.getSquareAtCoordinate(coordinate));
                    return true;
                } else {
                    return false;
                }
            } else if (!board.getSquareAtCoordinate(charCoordinate + "" + (numCoordinate + 1)).hasPieceOnSquare()) {
                move(board.getSquareAtCoordinate(charCoordinate + "" + (numCoordinate + 1)));
                return true;
            } else {
                return false;
            }
        } else {
            if (move.charAt(1) == 'x') {
                if (numCoordinate - 1 != moveNumCoordinate) {
                    return false;
                }
                if (charCoordinate - 1 == coordinate.charAt(0)) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        move(newSquare);
                        return true;
                    } else {
                        return false;
                    }
                } else if (charCoordinate + 1 == coordinate.charAt(0)) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        move(newSquare);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (move.length() != 2) {
                return false;
            } else if (numCoordinate - 1 != moveNumCoordinate &&
                    (numCoordinate - 2) != moveNumCoordinate) {
                return false;
            } else if (numCoordinate - 2 >= moveNumCoordinate && hasMoved) {
                return false;
            } else if (numCoordinate - 2 == moveNumCoordinate && !hasMoved) {
                if (!board.getSquareAtCoordinate(coordinate).hasPieceOnSquare()) {

                }
                if (!board.getSquareAtCoordinate(charCoordinate + "" + (numCoordinate - 1)).hasPieceOnSquare() &&
                        !board.getSquareAtCoordinate(coordinate).hasPieceOnSquare()) {
                    move(board.getSquareAtCoordinate(coordinate));
                    return true;
                } else {
                    return false;
                }
            } else if (!board.getSquareAtCoordinate(charCoordinate + "" + (numCoordinate - 1)).hasPieceOnSquare()) {
                move(board.getSquareAtCoordinate(charCoordinate + "" + (numCoordinate - 1)));
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean isValidPromotion(String move, Board board) {

        char thisCharCoordinate = super.getSquareCoordinates().charAt(0);
        int  thisNumCoordinate = Integer.parseInt(super.getSquareCoordinates().substring(1));
        if (move.length() == 4) {
            int moveNumCoordinate = Character.getNumericValue(move.charAt(1));
            if (moveNumCoordinate == 8 && super.getCOLOR() == 'w') {
                String coordinate = move.charAt(0) + "" + move.charAt(1);
                if (thisNumCoordinate + 1 == moveNumCoordinate &&
                        !board.getSquareAtCoordinate(move.substring(0, 2)).hasPieceOnSquare()) {
                    if (move.charAt(3) == 'Q') {
                        promote(new Queen('w'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    } else if (move.charAt(3) == 'N') {
                        promote(new Knight('w'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    } else if (move.charAt(3) == 'B') {
                        promote(new Bishop('w'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    } else if (move.charAt(3) == 'R') {
                        promote(new Rook('w'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    }
                }
            } else if (moveNumCoordinate == 1 && super.getCOLOR() == 'b') {
                String coordinate = move.charAt(0) + "" + move.charAt(1);
                if (thisNumCoordinate - 1 == moveNumCoordinate &&
                        !board.getSquareAtCoordinate(move.substring(0, 2)).hasPieceOnSquare()) {
                    if (move.charAt(3) == 'Q') {
                        promote(new Queen('b'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    } else if (move.charAt(3) == 'N') {
                        promote(new Knight('b'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    } else if (move.charAt(3) == 'B') {
                        promote(new Bishop('b'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    } else if (move.charAt(3) == 'R') {
                        promote(new Rook('b'), board.getSquareAtCoordinate(coordinate));
                        return true;
                    }
                }
            }
        } else if (move.length() == 6) {
            int moveNumCoordinate = Character.getNumericValue(move.charAt(3));
            if (moveNumCoordinate == 8 && super.getCOLOR() == 'w') {
                char moveCharCoordinate = move.charAt(2);
                String coordinate = moveCharCoordinate + "" + moveNumCoordinate;
                if (thisCharCoordinate - 1 == moveCharCoordinate) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        if (move.charAt(5) == 'Q') {
                            promote(new Queen('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'N') {
                            promote(new Knight('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'B') {
                            promote(new Bishop('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'R') {
                            promote(new Rook('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        }
                    }
                } else if (thisCharCoordinate + 1 == moveCharCoordinate) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        if (move.charAt(5) == 'Q') {
                            promote(new Queen('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'N') {
                            promote(new Knight('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'B') {
                            promote(new Bishop('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'R') {
                            promote(new Rook('w'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        }
                    }
                }
            } else if (moveNumCoordinate == 1 && super.getCOLOR() == 'b') {
                char moveCharCoordinate = move.charAt(2);
                String coordinate = moveCharCoordinate + "" + moveNumCoordinate;
                if (thisCharCoordinate - 1 == moveCharCoordinate) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        if (move.charAt(5) == 'Q') {
                            promote(new Queen('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'N') {
                            promote(new Knight('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'B') {
                            promote(new Bishop('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'R') {
                            promote(new Rook('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        }
                    }
                } else if (thisCharCoordinate + 1 == moveCharCoordinate) {
                    Square newSquare = board.getSquareAtCoordinate(coordinate);
                    if (newSquare != null && newSquare.hasPieceOnSquare()) {
                        if (move.charAt(5) == 'Q') {
                            promote(new Queen('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'N') {
                            promote(new Knight('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'B') {
                            promote(new Bishop('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        } else if (move.charAt(5) == 'R') {
                            promote(new Rook('b'), board.getSquareAtCoordinate(coordinate));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void move(Square square) {
        hasMoved = true;
        getSquareOn().removePiece();
        square.setPieceOnSquare(this);
    }

    public void promote(Piece piece, Square square) {
        getSquareOn().removePiece();
        square.setPieceOnSquare(piece);
    }

    @Override
    public String getPieceType() {
        return pieceType;
    }
}
