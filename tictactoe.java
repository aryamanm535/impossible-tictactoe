import java.util.*;
class tictactoe
{
    ArrayList <Integer> input = new ArrayList<>();
    String[][] board = {{"-","-","-"},{"-","-","-",},{"-","-","-"}}; 
    boolean human = false;
    void game()
    {
        System.out.println("Input 1,2,3,4,5,6,7,8,9 for the position of your input");
        System.out.println("X always plays first for now, I still have to make the algorithm for when player starts game");
        Scanner game = new Scanner(System.in);
        for(int i=0; i<9;)
        {
            if(!human)
            {  
                aiPlay();
                System.out.println();
                displayBoard();
                i++;
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
                    human = false;
                    System.out.println();
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
        }
        if(gameWon() == "n")
            System.out.println("Draw!");
        game.close();
    }

    void aiPlay()
    {
        int bestI = 0;
        int bestJ = 0;
        int bestScore = Integer.MIN_VALUE;
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
            {
                if(board[i][j] == "-")
                {
                    board[i][j] = "X";
                    int score = minimax(0, false);
                    board[i][j] = "-";
                    if(score>bestScore)
                    {
                        bestScore = score;
                        bestI = i;
                        bestJ = j;
                    }
                }

            }

        board[bestI][bestJ] = "X";
        human = true;

    }

    int minimax(int depth, boolean isMaximizing)
    {
        String result = gameWon();
        if(result == "X")
            return 1;
        else if(result == "O")
            return -1;

        if(isMaximizing)
        {
            int bestScore = Integer.MIN_VALUE;
            for(int i = 0; i<3; i++)
            {
                for(int j = 0; j<3; j++)
                {
                    if(board[i][j] == "-")
                    {
                        board[i][j] = "X";
                        int score = minimax(depth+1, false);
                        board[i][j] = "-";
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
        else
        {
            int bestScore = Integer.MAX_VALUE;
            for(int i = 0; i<3; i++)
            {
                for(int j = 0; j<3; j++)
                {
                    if(board[i][j] == "-")
                    {
                        board[i][j] = "O";
                        int score = minimax(depth+1, true);
                        board[i][j] = "-";
                        bestScore = Math.min(bestScore, score);
                    }
                }
            }
            return bestScore;
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
        String row, col, d1, d2;
        for(int i=0; i<3; i++)
        {
            row = ""; col = ""; d1 = ""; d2 = "";
            for(int j=0; j<3; j++)
            {
                row += board[i][j];
                col += board[j][i];
                d1 += board[j][j];
                d2 += board[j][2-j];
                if(row.equals("XXX") || col.equals("XXX")||d1.equals("XXX")||d2.equals("XXX"))
                    return "X";
                else if(row.equals("OOO") || col.equals("OOO")||d1.equals("OOO")||d2.equals("OOO"))
                    return "O";
                else
                    continue;
            }
        }
        return "n";
    }

    public static void main()
    {
        tictactoe game1 = new tictactoe();
        game1.game();
    }
}
