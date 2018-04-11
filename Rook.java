
/**
 * Rook ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class Rook extends ChessPiece
{
    /**
     * Creates a new Rook ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if it is white or black
     */
    public Rook(int startRow, char startCol, boolean white)
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
        if ((r >= 0 && r <= 7) && (c >= 'a' && c <= 'h'))//if the location is on the board
        {
            if(r == getRow())//if the new row is the same as old row,it will move horizontally
                return true;
            else if(c == getCol())//if the new column is the same as old column, it will move vertically
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the string value of the ChessPiece
     * @return string value of Rook
     */
    public String toString()
    {
        if(getIsWhite())//if piece is white
            return "WR";
        else
            return "BR";
    }
}