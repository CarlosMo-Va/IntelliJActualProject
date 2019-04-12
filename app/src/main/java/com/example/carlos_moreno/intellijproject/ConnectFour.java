package com.example.carlos_moreno.intellijproject;

public class ConnectFour extends MainActivity{

    private int column, row, numRows, numCols;
    private char[][] board;

    public ConnectFour(int rowNum, int colNum)
    {
        numRows = rowNum;
        numCols = colNum;
        board = new char[rowNum][colNum];
        for(int r = 0; r < rowNum; r++)
        {
            for(int c = 0; c < colNum; c++)
            {
                board[r][c] = ' ';
            }
        }
    }
    public boolean isColumnFull(int checkColumn)
    {
        boolean isFull = false;

        if(board[0][checkColumn-1] != ' ')
        {
            isFull = true;
        }
        return isFull;
    }
    public boolean isSpaceAvailable(int col)
    {
        boolean available = true;

        FOR_LOOP:
        for(int r = board.length-1; r >= 0; r--)
        {
            if(board[r][column] == ' ')
            {
                row = r;
                available = true;
                break FOR_LOOP;
            }
            else if(board[r][column] == 'X')
            {
                available = false;
            }
            else if(board[r][column] == 'O')
            {
                available = false;
            }
        }
        return available;
    }
    public void playMove(int col, char player)
    {
        column = col-1;

        if(isSpaceAvailable(col) == true)
        {
            board[row][column] = player;
        }
    }
    public int randomNum()
    {
        return (int)(Math.random()*(board[0].length)+1);
    }
    public String lastMove()
    {
        return "Row : " + (row+1) + "  Column : " + (column+1);
    }

    public boolean gameOver(char player)
    {
        for (int j = 0; j<board.length-3 ; j++ )
        {
            for (int i = 0; i<board[0].length; i++)
            {
                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player)         //Checks Horizontally
                {
                    return true;
                }
            }
        }
        for (int i = 0; i<board[0].length-3 ; i++ )
        {
            for (int j = 0; j<board.length; j++)
            {
                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player)         //Checks vertically
                {
                    return true;
                }
            }
        }
        for (int i=3; i<board[0].length; i++)
        {
            for (int j=0; j<board.length-3; j++)
            {
                if (board[i][j] == player && board[i-1][j+1] == player && board[i-2][j+2] == player && board[i-3][j+3] == player)   //diagonally upwards
                    return true;
            }
        }
        for (int i=3; i<board[0].length; i++)
        {
            for (int j=3; j<board.length; j++)
            {
                if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == player && board[i-3][j-3] == player)       //diagonally downwards
                    return true;
            }
        }
        return false;
    }
    public void resetBoard()
    {
        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                board[r][c] = ' ';
            }
        }
    }

    public boolean checkTies()
    {
        boolean isTie = false;
        int counter = 0;
        for(int i = 0; i < board[0].length; i++)
        {
            if(isColumnFull(i+1))
            {
                counter++;
            }
            else
            {
                counter = 0;
            }
        }

        if(counter == board[0].length+1)
            isTie = true;

        return isTie;
    }
    public String toString()
    {
        String output = "";
        for(char[] r: board)
        {
            output+= "|\t";
            for(char c: r)
            {
                output += "" + c + "\t|\t";
            }
            output += "\n-------------------------------------------------------------------------------------------------\n\n";
        }
        return output;
    }
}
