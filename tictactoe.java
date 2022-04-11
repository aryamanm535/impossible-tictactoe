import java.util.*;
class tictactoe
{
    ArrayList <Integer> input = new ArrayList();
    String[][] board = {{"-","-","-"},{"-","-","-",},{"-","-","-"}}; 
    void game()
    {
        Scanner game = new Scanner(System.in);
        displayBoard();
        boolean x = false;
        for(int i=0; i<9;)
        {
            if(x)
            {
                System.out.println("X's turn to play");
                int p = game.nextInt();
                if(!inArray(p))
                {
                    input.add(p);
                    switch(p)
                    {
                        case 1: board[0][0] = "X";
                            break;
                        case 2: board[0][1] = "X";
                            break;
                        case 3: board[0][2] = "X";
                            break;
                        case 4: board[1][0] = "X";
                            break;
                        case 5: board[1][1] = "X";
                            break;
                        case 6: board[1][2] = "X";
                            break;
                        case 7: board[2][0] = "X";
                            break;
                        case 8: board[2][1] = "X";
                            break;
                        case 9: board[2][2] = "X";
                            break;
                        default: board[2][2] = "X";
                    }
                    x = false;
                    System.out.println();
                    displayBoard();
                    i++;
                }
                else
                {
                    System.out.println("This position is full, enter a valid number");
                    continue;
                }
            }
            else
            {
                System.out.println("O's turn to play");
                int p = game.nextInt();
                if(!inArray(p))
                {
                    input.add(p);
                    switch(p)
                    {
                        case 1: board[0][0] = "O";
                            break;
                        case 2: board[0][1] = "O";
                            break;
                        case 3: board[0][2] = "O";
                            break;
                        case 4: board[1][0] = "O";
                            break;
                        case 5: board[1][1] = "O";
                            break;
                        case 6: board[1][2] = "O";
                            break;
                        case 7: board[2][0] = "O";
                            break;
                        case 8: board[2][1] = "O";
                            break;
                        case 9: board[2][2] = "O";
                            break;
                        default: board[2][2] = "O";
                    }
                    x = true;
                    System.out.println();
                    displayBoard();
                    i++;
                }
                else
                {
                    System.out.println("This position is full, enter a valid number");
                    continue;
                }
            }
            if(gameWon() == "X")
            {
                System.out.println("\n X wins!");
                break;
            }
            else if(gameWon() == "O")
            {
                System.out.println("\n O wins!");
                break;
            }
            else if(gameWon() == "n" && i==8)
                System.out.println("Draw!");
        }
    }

    boolean inArray(int x)
    {
        for(int i=0; i<input.size(); i++)
            if(x == input.get(i))
                return true;
        return false;
    }

    void displayBoard()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
                System.out.print(board[i][j]+"  ");
            System.out.println();
        }
    }

    String gameWon()
    {
        //rows and columns
        for(int i=0; i<3; i++)
        {
            if((board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) && !(board[0][i].equals("-")))
                return board[0][i];
            else if((board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) && !(board[i][0].equals("-")))
            {
                return board[i][0];
            }
        }
        //primary diagonal
        if((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) && !(board[0][0].equals("-")))
            return board[0][0];
        //secondary diagonal
        else if((board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) && !(board[0][2].equals("-")))
            return board[0][2];
        return "n";
    }

    public static void main()
    {
        tictactoe game1 = new tictactoe();
        game1.game();
    }
}   
