
/**
 * Bishop ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class Bishop extends ChessPiece
{
    /**
     * Creates a new Bishop ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if it is white or black
     */
    public Bishop(int startRow, char startCol, boolean white)
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
            if (getRow() - r == getCol() - c)//if difference in row locations equals difference in column locations, it will move diagonally
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the string value of the ChessPiece
     * @return string value of Bishop
     */
    public String toString()
    {
        if(getIsWhite())//if piece is white
            return "WB";
        else
            return "BB";
    }
}
