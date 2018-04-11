
/**
 * Queen ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class Queen extends ChessPiece
{  
    /**
     * Creates a new Queen ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if it is white or black
     */
    public Queen(int startRow, char startCol, boolean white)
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
            if((getRow() - r) == getCol() - c)//if it will move diagonally
                return true;
            else if(c == getCol())//if it will move vertically
                return true;
            else if(r == getRow())//if it will move horizontally
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the string value of the ChessPiece
     * @return string value of Queen
     */
    public String toString()
    {
        if(getIsWhite())//if piece is white
            return "WQ";
        else
            return "BQ";
    }
}
