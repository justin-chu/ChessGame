/**
 * Pawn ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class Pawn extends ChessPiece
{
    /**
     * Creates a new Pawn ChessPiece
     * @param starting row location
     * @param starting column location
     * @param if it is white or black
     */
    public Pawn(int startRow, char startCol, boolean white)
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
            //if pawn is at starting position and it will move 2 spaces forward
            if((((getRow() == 6 && getIsWhite()) && (getRow() - r == 2)) || (getRow() == 1 && !getIsWhite()) && (getRow() - r == -2)))
                return true;
            //else if pawn wants to move 1 space forward
            else if((getIsWhite()) && (getRow() - r == 1) || !getIsWhite() && (getRow() - r == -1))
                return true;
            //else if pawn wants to move 1 space diagonal forward (later check if it can eat a piece)
            else if(((getIsWhite()) && (getRow() - r == 1 && getCol() - c == (1|-1) 
            || (!getIsWhite() && getRow() - r == -1 && getCol() - c == (1|-1)))))
                return true;
            else 
                return false;
        }
        else
            return false;
    }

    /**
     * Returns the string value of the ChessPiece
     * @return string value of Pawn
     */
    public String toString()
    {
        if(super.getIsWhite())
            return "WP";
        else
            return "BP";
    }
}