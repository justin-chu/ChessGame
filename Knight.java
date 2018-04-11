
/**
 * Knight ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class Knight extends ChessPiece  
{

    /**
     * Creates a new Knight ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if it is white or black
     */
    public Knight(int startRow, char startCol, boolean white)
    {
        super(startRow, startCol, white);
    }

    /**
     * Returns whether or not a move is possible
     * @param new row location
     * @param new column location
     * @return if a move is possible
     */
    public boolean isLegalMove(int r, char c)
    {
        if((r >= 0 && r <= 7) && (c >= 'a' && c <= 'h'))//if the location is on the board
        {
            //if the move is shaped like an 'L' when it moves 2 in one direction, and 1 in perpendicular direction
            if((Math.abs(getRow() - r) == 2 && Math.abs(getCol() - c) == 1)) 
                return true;
            else if(Math.abs(getRow() - r) == 1 && Math.abs(getCol() - c) == 2)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the string value of the ChessPiece
     * @return string value of Knight
     */
    public String toString()
    {
        if(getIsWhite())//if piece is white
            return "WN";
        else
            return "BN";
    }
}
