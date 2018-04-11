public interface Game
{
    //starts a new game
    void newGame();

    //plays out the next turn, returns true if successful, false if move was invalid
    boolean nextTurn();
    //returns a string representing the current score of the game
    String toScore();

    //returns a string with a visual representation of the current state of the game
    String toString();

    //returns true if the game has been won by someone
    boolean winner();
}