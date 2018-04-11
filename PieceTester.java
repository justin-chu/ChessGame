
/**
 * Tests objects of class ChessPiece
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class PieceTester
{
    /**
     * Tests the ChessPiece method
     */
    public static void main(String[] args)
    {
        //Rook
        System.out.println("Testing rook piece");
        Rook rook = new Rook(1, 'a', false);//if rook is in bottom left square
        //test rook's isLegalMove method
        System.out.println(rook.isLegalMove(1, 'h'));//moving horizontally should return true
        System.out.println(rook.isLegalMove(7, 'a'));//moving vertically should return true
        System.out.println(rook.isLegalMove(3, 'b'));//should return false
        //test rook's toString method
        System.out.println(rook + "\n");

        //Knight
        System.out.println("Testing knight piece");
        Knight knight = new Knight(1, 'b', true);//if knight is in bottom left square
        //test knight's isLegalMove method
        System.out.println(knight.isLegalMove(3, 'a'));//Up 2, right 1 should return true
        System.out.println(knight.isLegalMove(2, 'd'));//Up 1, right 2 should return true
        System.out.println(knight.isLegalMove(3, 'h'));//should return false
        //test knight's toString method
        System.out.println(knight + "\n");

        //Bishop
        System.out.println("Testing bishop piece");
        Bishop bishop = new Bishop(1, 'a', false);//if bishop is in bottom left square
        //test bishop's isLegalMove method
        System.out.println(bishop.isLegalMove(7, 'g'));//moving diagonally to top right should return true
        System.out.println(bishop.isLegalMove(4, 'h'));//should return false
        //test bishop's toString method
        System.out.println(bishop + "\n");

        //Queen
        System.out.println("Testing queen piece");
        Queen queen = new Queen(1, 'a', false);//if queen is in bottom left square
        //test queen's isLegalMove method
        System.out.println(queen.isLegalMove(1, 'h'));//moving horizontally should return true
        System.out.println(queen.isLegalMove(7, 'a'));//moving vertically should return true
        System.out.println(queen.isLegalMove(4, 'd'));//moving diagonally should return true
        System.out.println(queen.isLegalMove(3, 'b'));//should return false
        //test queen's toString method
        System.out.println(queen + "\n");

        //King
        System.out.println("Testing king piece");
        King king = new King(1, 'a', false);//if king is in bottom left square
        //test king's isLegalMove method
        System.out.println(king.isLegalMove(1, 'b'));//moving horizonyally by 1 should return true
        System.out.println(king.isLegalMove(2, 'a'));//moving vertically by 1 should return true
        System.out.println(king.isLegalMove(2, 'b'));//moving diagonally by 1 should return true
        System.out.println(king.isLegalMove(1, 'c'));//should return false
        //test king's toString method
        System.out.println(king + "\n");

        //Pawn
        System.out.println("Testing pawn piece");
        Pawn pawn = new Pawn(1, 'a', false);//if pawn is in bottom left square
        //test pawn's isLegalMove method
        System.out.println(pawn.isLegalMove(2, 'a'));//pawn moves forward should return true
        System.out.println(pawn.isLegalMove(0, 'a'));//pawn moves backward should return false
        //test pawn's toString method
        System.out.println(pawn);

    }
}