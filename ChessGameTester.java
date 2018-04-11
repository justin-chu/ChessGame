
/*Tests the ChessGame class
 *
 * @author Justin Chu
 * @version March 7th, 2018
 */
public class ChessGameTester
{
    /**
     * Tests the ChessGame class
     */
    public static void main(String[] args)
    {
        //initialize new chess game
        ChessGame game = new ChessGame(); 
        //start a new game
        game.newGame();
        //print the new game
        System.out.println(game);
        //start the game
        System.out.println(game.nextTurn());
    }
}   