package com.example.carlos_moreno.intellijproject;
import java.util.Scanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectFour game1 = new ConnectFour(6,6);
        Scanner scan = new Scanner(System.in);

        int computersMove;
        int round = 1;
        int move = 0;
        int playAgain = 0;

        if(round%2 == 0)
            System.out.println("Computer Starts");
        else
            System.out.println("Player Starts");

        BIG_LOOP:
        while(game1.gameOver('X') == false && game1.gameOver('O') == false && game1.checkTies() == false)
        {
            if(round%2 == 0)
            {
                computersMove = game1.randomNum();
                System.out.println("Computers Turn:");
                while(game1.isColumnFull(computersMove) == true)
                {
                    System.out.println(" Space unavailable, Computer tries again : ");
                    computersMove = game1.randomNum();
                    System.out.println(" " + game1.lastMove());
                    game1.isColumnFull(computersMove);
                    if(game1.checkTies() == true)
                        break;
                }
                game1.playMove(computersMove, 'O');
                System.out.println("\nComputers Move: " + game1.lastMove() + "\n" + game1.toString());

                System.out.println("Players Turn, make a move: ");
                move = scan.nextInt();
                while(move < 1 || move > 6)
                {
                    System.out.println("Column out of bounds, try again: ");
                    move = scan.nextInt();
                }
                while(game1.isColumnFull(move) == true)
                {
                    game1.isColumnFull(move);
                    System.out.println(" Space unavailable, Players Turn, make move : ");
                    move = scan.nextInt();
                    game1.isColumnFull(move);
                    if(game1.checkTies() == true)
                        break;
                }
                game1.playMove(move, 'X');
                System.out.println(game1.toString());
                game1.gameOver('X');
                game1.gameOver('O');
                game1.checkTies();
            }
            else {
                System.out.println("Players Turn, make move : ");
                move = scan.nextInt();
                while(move < 1 || move > 6)
                {
                    System.out.println("Column out of bounds, try again: ");
                    move = scan.nextInt();
                }
                while(game1.isColumnFull(move) == true)
                {
                    game1.isColumnFull(move);
                    System.out.println(" Space unavailable, Players Turn, make move : ");
                    move = scan.nextInt();
                    if(game1.checkTies() == true)
                        break;
                }
                game1.playMove(move, 'X');
                System.out.println(game1.toString());

                computersMove = game1.randomNum();
                System.out.println("Computers Turn: ");
                while(game1.isColumnFull(computersMove) == true)
                {
                    System.out.println(" Space unavailable, Computer tries again : ");
                    computersMove = game1.randomNum();
                    System.out.println(" " + game1.lastMove());
                    game1.isColumnFull(computersMove);
                    if(game1.checkTies() == true)
                        break;
                }
                game1.playMove(computersMove, 'O');
                System.out.println("\nComputers Move: " + game1.lastMove() + "\n" + game1.toString());

            }
        }

        if(game1.gameOver('X'))
        {
            System.out.println("PLYER WINS!!");
            System.out.println("\n\nWould you like to play again?\n\t1)yes\t2)no");
            playAgain = scan.nextInt();
        }
        if(game1.gameOver('O'))
        {
            System.out.println("COMPUTER WINS!!");
            System.out.println("\n\nWould you like to play again?\n\t1) Yes\t2) No");
            playAgain = scan.nextInt();
        }
        if(game1.checkTies() == true)
        {
            System.out.println("Its a Tie, Game over ");
            System.out.println("\n\nWould you like to play again?\n\t1) Yes\t2) No");
            playAgain = scan.nextInt();
        }
        if(playAgain == 1)
            round++;

        while(playAgain == 1)
        {
            game1.resetBoard();
            while(game1.gameOver('X') == false && game1.gameOver('O') == false && game1.checkTies() == false)
            {
                if(round%2 == 0)
                {
                    computersMove = game1.randomNum();
                    System.out.println("Computers Turn:");
                    while(game1.isColumnFull(computersMove) == true)
                    {
                        System.out.println(" Space unavailable, Computer tries again : ");
                        computersMove = game1.randomNum();
                        System.out.println(" " + game1.lastMove());
                        game1.isColumnFull(computersMove);
                        if(game1.checkTies() == true)
                            break;
                    }
                    game1.playMove(computersMove, 'O');
                    System.out.println("\nComputers Move: " + game1.lastMove() + "\n" + game1.toString());


                    System.out.println("Players Turn, make a move: ");
                    move = scan.nextInt();
                    while(move < 1 || move > 6)
                    {
                        System.out.println("Column out of bounds, try again: ");
                        move = scan.nextInt();
                    }
                    while(game1.isColumnFull(move) == true)
                    {
                        game1.isColumnFull(move);
                        System.out.println(" Space unavailable, Players Turn, make move : ");
                        move = scan.nextInt();
                        game1.isColumnFull(move);
                        if(game1.checkTies() == true)
                            break;
                    }
                    game1.playMove(move, 'X');
                    System.out.println(game1.toString());

                    game1.gameOver('X');
                    game1.gameOver('O');
                    game1.checkTies();
                }
                else {
                    System.out.println("Players Turn, make move : ");
                    move = scan.nextInt();
                    while(move < 1 || move > 6)
                    {
                        System.out.println("Column out of bounds, try again: ");
                        move = scan.nextInt();
                    }
                    while(game1.isColumnFull(move) == true)
                    {
                        game1.isColumnFull(move);
                        System.out.println(" Space unavailable, Players Turn, make move : ");
                        move = scan.nextInt();
                        game1.isColumnFull(move);
                        if(game1.checkTies() == true)
                            break;
                    }
                    game1.playMove(move, 'X');
                    System.out.println(game1.toString());

                    computersMove = game1.randomNum();
                    System.out.println("Computers Turn: ");
                    while(game1.isColumnFull(computersMove) == true)
                    {
                        System.out.println(" Space unavailable, Computer tries again : ");
                        computersMove = game1.randomNum();
                        System.out.println(" " + game1.lastMove());
                        game1.isColumnFull(computersMove);

                        if(game1.checkTies() == true)
                            break;
                    }
                    game1.playMove(computersMove, 'O');
                    System.out.println("\nComputers Move: " + game1.lastMove() + "\n" + game1.toString());

                }
            }
            if(game1.gameOver('X'))
            {
                System.out.println("PLYER WINS!!");
                System.out.println("\n\nWould you like to play again?\n\t1)yes\t2)no");
                playAgain = scan.nextInt();
            }
            if(game1.gameOver('O'))
            {
                System.out.println("COMPUTER WINS!!");
                System.out.println("\n\nWould you like to play again?\n\t1) Yes\t2) No");
                playAgain = scan.nextInt();
            }
            if(game1.checkTies() == true)
            {
                System.out.println("Its a Tie, Game over ");
                System.out.println("\n\nWould you like to play again?\n\t1) Yes\t2) No");
                playAgain = scan.nextInt();
            }
            if(playAgain == 1)
                round++;
        }
    }
}








