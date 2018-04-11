
/**
 * Implementation of the game interface
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
import java.util.Scanner; //import scanner
public class ChessGame implements Game
{
    //instance variables
    private ChessPiece[][]GameBoard; //declaring 2d-array chessboard variable
    private boolean isWhite = true; //whos turn it is
    private boolean isWinner = false; //if a player has won yet
    /**
     * Starts a new game
     */
    public ChessGame()
    {
        GameBoard = new ChessPiece[8][8];//instantiates GameBoard
        newGame();//calls newGame() method
    }    

    /**
     * Prepares a new game
     */
    public void newGame()
    {
        //intializing all pieces on the chess board

        //initializing black rook pieces
        GameBoard[0][0] = new Rook(0, 'a', false);
        GameBoard[0][7] = new Rook(0, 'h', false);

        //initializing black knight pieces
        GameBoard[0][1] = new Knight(0, 'b', false);
        GameBoard[0][6] = new Knight(0, 'g', false);

        //initializing black bishop pieces
        GameBoard[0][2] = new Bishop(0, 'c', false);
        GameBoard[0][5] = new Bishop(0, 'f', false);

        //initializing black queen and king pieces
        GameBoard[0][3] = new Queen(0, 'd', false);
        GameBoard[0][4] = new King(0, 'e', false);

        //initializing black pawn pieces
        for(int i = 0; i < 8; i++)
        {
            GameBoard[1][i] = new Pawn(1, (char)(i + 97), false);
        }

        //initializing white rook pieces
        GameBoard[7][0] = new Rook(7, 'a', true);
        GameBoard[7][7] = new Rook(7, 'h', true);

        //initializing white knight pieces
        GameBoard[7][1] = new Knight(7, 'b', true);
        GameBoard[7][6] = new Knight(7, 'g', true);

        //initializing white bishop pieces
        GameBoard[7][2] = new Bishop(7, 'c', true);
        GameBoard[7][5] = new Bishop(7, 'f', true);

        //initializing white queen and king pieces
        GameBoard[7][3] = new Queen(7, 'd', true);
        GameBoard[7][4] = new King(7, 'e', true);

        //initializing white pawn pieces
        for(int i = 0; i < 8; i++)
        {
            GameBoard[6][i] = new Pawn(6, (char)(i + 97), true);
        }
    }

    /**
     * method for players to take turns moving
     * @return if switching to next turn is successful
     */
    public boolean nextTurn()
    {
        Scanner sc = new Scanner(System.in); //create a scanner

        while(!isWinner)//while there is no winner
        {
            if(isWhite) //if it is white's turn
            {
                //prompt user
                System.out.println("White's turn. To move, enter original space location \n(space) new space location. Eg. a3 a4 \nTo resign, enter \"resign\"");
                String user = sc.nextLine();//recieve user input
                if(user.equals("resign"))//if user wants to resign
                    isWinner = true;//black wins
                else
                {
                    int originalCol = user.charAt(0) - 97;//change char old column to int
                    int originalRow = 7 - (user.charAt(1) - 49);//change char old row to int
                    int newCol = user.charAt(3) - 97; //change char new column to int
                    int newRow = 7 - (user.charAt(4) - 49); //change char new row to int

                    char charOldCol = user.charAt(0);//keep old column as char
                    char charNewCol = user.charAt(3);//keep new column as char

                    //if the location user wants to move to is a ChessPiece and is white, 
                    //and the new location is empty or not white
                    //and the move is a legal move
                    //and as long as it doesn't go over pieces (except for knight)
                    if(GameBoard[originalRow][originalCol] instanceof ChessPiece && GameBoard[originalRow][originalCol].getIsWhite()
                    && (GameBoard[newRow][newCol] == null || !(GameBoard[newRow][newCol].getIsWhite()))
                    && GameBoard[originalRow][originalCol].isLegalMove(newRow, charNewCol)
                    && (GameBoard[originalRow][originalCol] instanceof Knight
                    || !(GameBoard[originalRow][originalCol] instanceof Knight) && goesOver(originalRow, originalCol, newRow, newCol)))
                    {
                        //change ChessPiece instance variables
                        GameBoard[originalRow][originalCol].move(newRow, charNewCol);
                        //move ChessPiece to new location
                        GameBoard[newRow][newCol] = GameBoard[originalRow][originalCol];
                        //old location becomes empty
                        GameBoard[originalRow][originalCol] = null;
                        //clear screen and print the chess board
                        System.out.print('\u000C');
                        System.out.println(toString());
                        //now it's blacks turn
                        isWhite = false;
                    }
                    else
                    {
                        //clear screen, print board, and tell user that there was an error
                        System.out.print('\u000C');
                        System.out.println(toString());
                        System.out.println("This is not a legal move! Please re-enter your move: ");
                    }
                }
            }
            else if(!isWhite)//if it's blacks turn
            {
                //prompt user
                System.out.println("Black's turn. To move, enter original space location \n(space) new space location. Eg. a3 a4 \nTo resign, enter \"resign\"");
                String user = sc.nextLine();//recieve user input
                if(user.equals("resign"))//if user wants to resign
                    isWinner = true;//white wins
                else
                {

                    int originalCol = user.charAt(0) - 97;//change char old column to int
                    int originalRow = 7 - (user.charAt(1) - 49);//change char old row to int
                    int newCol = user.charAt(3) - 97; //change char new column to int
                    int newRow = 7 - (user.charAt(4) - 49); //change char new row to int

                    char charOldCol = user.charAt(0);//keep old column as char
                    char charNewCol = user.charAt(3);//keep new column as char

                    //if the location user wants to move to is a ChessPiece and is black, 
                    //and the new location is empty or white
                    //and the move is a legal move
                    //and as long as it doesn't go over pieces (except for knight)
                    if(GameBoard[originalRow][originalCol] instanceof ChessPiece && !(GameBoard[originalRow][originalCol].getIsWhite())
                    && (GameBoard[newRow][newCol] == null || GameBoard[newRow][newCol].getIsWhite())
                    && (GameBoard[originalRow][originalCol].isLegalMove(newRow, charNewCol))
                    && (GameBoard[originalRow][originalCol] instanceof Knight
                    || (GameBoard[originalRow][originalCol] instanceof Knight) && goesOver(originalRow, originalCol, newRow, newCol)))
                    {
                        //change ChessPiece instance variables
                        GameBoard[originalRow][originalCol].move(newRow, charNewCol);
                        //move ChessPiece to new location
                        GameBoard[newRow][newCol] = GameBoard[originalRow][originalCol];
                        //old location becomes empty
                        GameBoard[originalRow][originalCol] = null;
                        //clear screen and print the chess board
                        System.out.print('\u000C');
                        System.out.println(toString());
                        //now it's whites turn
                        isWhite = true;
                    }
                    else
                    {
                        //clear screen, print board, and tell user that there was an error
                        System.out.print('\u000C');
                        System.out.println(toString());
                        System.out.println("This is not a legal move! Please re-enter your move: ");
                    }
                }
            }
        }
        return winner();//after while loop is over, that means there is a winner
    }

    /**
     * Checks if there are pieces in between the old location and new location
     * @param old row location
     * @param old column location
     * @param new row location
     * @param new column location
     * @return true if there are no pieces between the old location and new location
     */
    public boolean goesOver(int oldRow, int oldCol, int newRow, int newCol)
    {
        if(oldRow == newRow)//if piece is moving horizontally
        {
            for(int i = 1; i < Math.abs(oldCol - newCol); i++)//checks pieces between old location and new location
            {
                if (!isWhite && !(GameBoard[oldRow][oldCol + i] == null)
                ||isWhite&& !(GameBoard[oldRow][oldCol - i] == null))//if this space is not empty
                    return false;
            }
            return true;
        }
        else if(oldCol == newCol)//if piece is moving vertically
        {
            if(GameBoard[oldRow][oldCol] instanceof Pawn && !(GameBoard[newRow][newCol] == null))//if there is a piece where pawn wants to gox
            {
                return false;
            }
            else
            {
                for(int i = 1; i < Math.abs(oldRow - newRow); i++)//checks pieces between old location and new location
                {
                    if (!isWhite && !(GameBoard[oldRow + i][oldCol] == null)
                    ||isWhite&& !(GameBoard[oldRow-i][oldCol] == null))//if this space is not empty
                        return false;
                }
            }
            return true;
        }
        else//else if the piece is moving diagonally
        {
            //if there is a pawn wanting to eat an enemy and there is no piece where pawn wants to go
            if(GameBoard[oldRow][oldCol] instanceof Pawn && GameBoard[newRow][newCol] == null)
            {
                return false;
            }
            else
            {
                for(int i = 1; i < Math.abs(oldCol - newCol); i++)//checks pieces between old location and new location
                {
                    if (!isWhite && !(GameBoard[oldRow + i][oldCol + i] == null)
                    ||isWhite&& !(GameBoard[oldRow-i][oldCol-i] == null))//if this space is not empty
                        return false;
                }
            }
            return true;
        }
    }

    /**
     * returns score
     * @return empty string for now
     */
    public String toScore()
    {
        return "";
    }

    /**
     * returns string version of ChessBoard
     * @return printed ChessBoard
     */
    public String toString()
    {
        String board = "";//create a board string
        for(int r = 0; r < 8; r++)//for 8 rows
        {
            board = board + (8-r) + "|";//print location row number on the left side
            for(int c = 0; c < 8; c++)//for 8 columns
            {
                if(GameBoard[r][c] == null)//if there is no piece at this location print nothing
                    board = board + "    |";
                else//else print the piece
                    board =  board + " " + GameBoard[r][c].toString() + " |";
            }
            board = board + "\n";//go to next line
        }
        board = board + " |  a |  b |  c |  d |  e |  f |  g |  h | ";//print location column letter on bottom
        return board;
    }

    /**
     * Ends game if there is a winner
     * @return true if there is a winner
     */
    public boolean winner()
    {
        if(isWinner && isWhite)//if it was whites turn
        {
            System.out.println("Black wins!");
            return true;//return that there was a winner
        }
        else if (isWinner && !isWhite)//if it was blacks turn
        {
            System.out.println("White wins!");
            return true;//return that there was a winner
        }
        else
            return false;//return that there was not a winner
    }
}
