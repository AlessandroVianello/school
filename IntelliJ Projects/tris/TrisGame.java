package tris;

import javax.swing.JOptionPane;
import static tris.TrisGame.Symbols.*;

public class TrisGame implements TrisDisplayListener {

    public enum Symbols { EMPTY, CROSS, CIRCLE };

    private TrisDisplayComponent display;
    private Configuration gameBoard;
    private boolean[] losers;

    public TrisGame(TrisDisplayComponent display) {
        this.display = display;
        display.addListener(this);
        losers = new boolean[19683];
        clear();
    }

    public void clear() {
        gameBoard = new Configuration();
        display.clear();
    }

    private void endGame(String message) {
        JOptionPane.showMessageDialog(display, message);
        clear();
    }

    public void cellClicked(int x, int y) {
        
        if (!gameBoard.isEmpty(x, y))
            return;
        
        display.set(x, y, CROSS);
        Configuration playerMove = new Configuration(gameBoard, x, y, CROSS);
        if (playerMove.checkWin(CROSS)) {
            losers[gameBoard.hashCode()] = true;
            endGame("you win !");
            return;
        }
        
        Configuration nextMove = null;
        for (y = 0; nextMove == null && y < 3; y++)
            for (x = 0; nextMove == null && x < 3; x++)
                if (playerMove.isEmpty(x, y)) {
                    nextMove = new Configuration(playerMove, x, y, CIRCLE);
                    if (losers[nextMove.hashCode()])
                        nextMove = null;
                    else
                        display.set(x, y, CIRCLE);
                }
        
        if (losers[gameBoard.hashCode()] = nextMove == null)
            endGame("I surrend !");
        else if ((gameBoard = nextMove).checkWin(CIRCLE))
            endGame("You lose !");
    }
}
