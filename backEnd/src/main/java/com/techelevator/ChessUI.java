package com.techelevator;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ChessUI {
    private final Scanner keyboard = new Scanner(System.in);
    public String getUserInput() {
        return keyboard.nextLine();
    }

    public void askForMove() {
        System.out.println("What move would you like to play?");
    }

    public void pieceToMove() {
        System.out.println("Please enter the square that the piece you want to move is on.");
    }

    public void invalidSquare() {
        System.out.println("Invalid square. Please enter the square with a lowercase letter followed by a single number");
        System.out.println("Ex. e2");
    }

    public void errorMessage() {
        System.out.println("Please enter your move in Chess Notation (for more info go to chess.com/terms/chess-notation)");

    }

    public void printEndOfBoard() {
        System.out.print("\n  _________________________________________________________________");
    }
    public void printEmptySpace() {
        System.out.println("\n  |       |       |       |       |       |       |       |       |");
    }
    public void printEndOfLine() {
        System.out.print("\n  |_______|_______|_______|_______|_______|_______|_______|_______|");
    }
    public void printRowLetters() {
        System.out.println("\n      A       B       C       D       E       F       G       H ");
    }

    public void printFEN(String fen) {

        String[] fenArray = fen.split("/");
        int column = 8;

        printEndOfBoard();
        for (String currentLine : fenArray) {
            printEmptySpace();
            int numEmptySpaces = 0;
            int i = 0;
            while(i < currentLine.length()) {

                try {
                    numEmptySpaces = Integer.parseInt(currentLine.substring(i, i + 1));
                    int counter = 0;
                    while (numEmptySpaces > 0) {
                        if (i == 0 && counter == 0) {
                            printEmptySquare(column);
                            numEmptySpaces--;

                        }else {
                            printEmptySquare();
                            numEmptySpaces--;
                        }
                        counter++;
                    }
                    i++;

                } catch(NumberFormatException nfe) {
                    if (i == 0) {
                        printSquare(currentLine.substring(i, i +1), column);
                        i++;
                    } else {
                        printSquare(currentLine.substring(i, i + 1));
                        i++;
                    }
                }
            }
            printEndOfLine();
            column--;
            }
        printRowLetters();
        }

    public void printSquare(String piece, int column) {

        System.out.print(column + " |   " + piece + "   |");
        
    }

    public void printSquare(String piece) {
        System.out.print("   " + piece + "   |");
    }

    public void printEmptySquare(int column) {
        System.out.print(column + " |       |");
    }

    public void printEmptySquare() {
        System.out.print("       |");
    }
    

}
