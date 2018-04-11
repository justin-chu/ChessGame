
/**
 * Abstract ChessPiece class
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
abstract class ChessPiece
{
    //instance variables
    private int row;
    private char col;
    private boolean isWhite; // false = black

    /**
     * Creates a new ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if the piece is white
     */
    public ChessPiece(int startRow, char startCol, boolean white)
    {
        //change instance variables to location of piece
        row = startRow;
        col = startCol;
        isWhite = white;
    }

    /**
     * subclasses must implement this method
     * checks if a move is legal
     * @param new row location
     * @param new column location
     * @return if this move is legal or not
     */
    abstract boolean isLegalMove(int r, char c);

    /**
     * change the instance variables to parameters
     * @param new row location
     * @param new column location
     */
    final void move(int r, char c)
    {
        //if it is a legal move
        if (isLegalMove(r,c))
        {
            //change old location to new location
            row = r;
            col = c;
        }
    }

    /**
     * gets row instance variable value
     * @return row value
     */
    public int getRow()
    {
        return row;
    }

    /**
     * gets column instance variable value
     * @return col value
     */
    public char getCol()
    {
        return col;  
    }

    /**
     * checks if a piece is white
     * @return true if a piece is white
     */
    public boolean getIsWhite()
    {
        return isWhite;
    }
}
