
/**
 * King ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class King extends ChessPiece
{
    /**
     * Creates a new King ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if it is white or black
     */
    public King(int startRow, char startCol, boolean white)
    {
        super(startRow, startCol, white);
    }

    /**
     * Returns whether or not a move is possible
     * @param new row location
     * @param new column location
     */
    public boolean isLegalMove(int r, char c)
    {
        if((r >= 0 && r <= 7) && (c >= 'a' && c <= 'h'))//if the location is on the board
        {
            if(getCol() - c == (1|-1) && getRow() == r)//if it will move 1 horizontally
                return true;
            else if(getRow() - r == (-1|1) && getCol() == c)//if it will move 1 vertically
                return true;
            else if(getRow() - r == (-1|1) && getCol() - c == (1|-1))//if it will move 1 diagonally
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the string value of the ChessPiece
     * @return string value of King
     */
    public String toString()
    {
        if(getIsWhite())//if piece is white
            return "WK";
        else
            return "BK";
    }
}