/*
 * AndreBetz.de
 */

package reinforcementlearning_hanoi;

/**
 * @author AndreBetz.de
 */
public class my2DMatrix {
    private int[] field; 
    private int sizeX;
    private int sizeY;
    public my2DMatrix(int x, int y) {
        if ( x > 0 && y > 0 ) {
            this.sizeX = x;
            this.sizeY = y;
            field = new int[x*y];
        }
    }
    public void init(int val) {
        for ( int y = 0; y < sizeY; y++ ) {
            for ( int x = 0; x < sizeX; x++ ) {
                set(x,y,val);
            }            
        }
    }
    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public void set(int x, int y, int val) {
        if ( x < sizeX && x >= 0 && y < sizeY && y >= 0) {
            field[y*sizeX + x] = val;
        }
    }
    public int get(int x, int y) {
        if ( x < sizeX && x >= 0 && y < sizeY && y >= 0) {
            return field[y*sizeX + x];
        }
        return -1;
    }
    public String print() {
        String res = "";
        for ( int y = 0; y < sizeY; y++ ) {
            for ( int x = 0; x < sizeX; x++ ) {
                res += get(x,y) + "\t";
            }
            res += "\n";
        }
        return res;
    }
}
