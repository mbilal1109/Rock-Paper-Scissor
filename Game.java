package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick An Option To Play: (Pick 1, 2, or 3)");
        System.out.println("1.Rock \n2.Paper\n3.Scissor");
        int player = scan.nextInt();
        showWinner(player);
    }

    static Selection selectionByUser = Selection.ROCK;
    static Selection selectionByComp = Selection.PAPER;

    static boolean matchDraw = false;
    static boolean userWinner = true;

    public static void showWinner(int player) {
        selectionByUser = userSelection(player);
        selectionByComp = randomlySelectedByCpu();
        checkWinner();
        System.out.println(getTheResultInString());
    }

    public static String getTheResultInString() {
        String result;

        System.out.println("Computer Selected: " + selectionByComp);
        System.out.println("User Selected: " + selectionByUser);

        if(matchDraw) {
            result = "It's a draw, try again!";
        }
        else {
            if(userWinner) {
                result = "You win!!";
            }
            else {
                result = "You loose, try again!!";
            }
        }
        return result;
    }

    public static Selection userSelection(int player) {
        if(player == 1) selectionByUser = Selection.ROCK;
        else if(player == 2) selectionByUser = Selection.PAPER;
        else selectionByUser = Selection.SCISSOR;
        return selectionByUser;
    }

    public static Selection randomlySelectedByCpu() {
        int random = new Random().nextInt(3);
        if(random == 0) selectionByComp = Selection.ROCK;
        else if(random == 1) selectionByComp = Selection.PAPER;
        else selectionByComp = Selection.SCISSOR;
        return selectionByComp;
    }

    public static void checkWinner() {
        if(selectionByUser == selectionByComp) {
            matchDraw = true;
            return;
        }

        // Rock loosing from paper, wins from scissor
        if(selectionByUser == Selection.ROCK) {
            if(selectionByComp == Selection.SCISSOR) {
                userWinner = true;
                return;
            }
            else if(selectionByComp == Selection.PAPER) {
                userWinner = false;
                return;
            }
        }

        // Paper loosing from scissor, wins from rock
        if(selectionByUser == Selection.PAPER) {
            if(selectionByComp == Selection.ROCK) {
                userWinner = true;
                return;
            }
            else if(selectionByComp == Selection.SCISSOR) {
                userWinner = false;
                return;
            }
        }

        // Scissor loosing from rock, wins from paper
        if(selectionByUser == Selection.SCISSOR) {
            if(selectionByComp == Selection.PAPER) {
                userWinner = true;
                return;
            }
            else if(selectionByComp == Selection.ROCK) {
                userWinner = false;
                return;
            }
        }
    }
}
