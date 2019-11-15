package tris;

import tris.TrisGame.Symbols;
import static tris.TrisGame.Symbols.*;

public class Configuration {

    private final Symbols[] board = new Symbols[9];    
        
    public Configuration()
    {
        for(int i=0; i<9; i++)
            board[i] = EMPTY;
    }
        
    public Configuration(Configuration base, int x, int y, Symbols symbol)
    {
        for(int i=0; i<9; i++)
            board[i] = i==x+y*3?symbol:base.board[i];
    }
        
    public boolean isEmpty(int x, int y)
    {
        return board[x+y*3] == EMPTY;
    }
    
    public boolean checkWin(Symbols symbol)
    {
        for(int[] check : new int[][]{{0,1},{3,1},{6,1},{0,3},{1,3},{2,3},{0,4},{2,2}})
        {
            int count = 0;
            for(int pos = check[0]; count<3 && board[pos]==symbol; pos+=check[1])
                count++;
            if(count==3)
                return true;
        }
        return false;
    }
    
    public int hashCode()
    {
        int hash = 0;
        for(int p=0; p<9; p++)
            hash = hash * 3 + board[p].ordinal();
        return hash;
    }
}
