/*
 * AndreBetz.de
 *  Towers of Hanoi with three 
 */

package reinforcementlearning_hanoi;

/**
 *
 * @author  AndreBetz.de
 */
public class ReinforcementLearning_Hanoi {
    static int statesHanoi = 27;
    static int startState  = 0;
    static int endState    = 26;
    QLearning ql = new QLearning(statesHanoi,0.5);
    String[] moveArray = new String[statesHanoi];
    public ReinforcementLearning_Hanoi() {
        setRMatrix();
        setMovesVisible();
    }
    public void setLambda(double lambda) {
        ql.setLambda(lambda);
    }
    public void print() {
        System.out.print(ql.print());
    }
    public String learn() {
        return ql.episode(endState);        
    }
    public String bestMoves() {
        String res = "";
        int[] moves = ql.traceRoute(startState,endState);
        for ( int i = 0; i < moves.length; i++ ) {
            int pos = moves[i];
            res += Integer.toString(pos)+")\n";
            res += printState(pos);
            res += "-----------------\n";
        }
        return res;
    }
    /**
     * set the transitions, possible movements in this game.
     */
    private void setRMatrix() {
        ql.setTransition(1,0,0);   ql.setTransition(2,0,0); 
        ql.setTransition(0,1,0);   ql.setTransition(2,1,0);   ql.setTransition(5,1,0); 
        ql.setTransition(0,2,0);   ql.setTransition(1,2,0);   ql.setTransition(3,2,0); 
        ql.setTransition(2,3,0);   ql.setTransition(4,3,0);   ql.setTransition(7,3,0); 
        ql.setTransition(3,4,0);   ql.setTransition(7,4,0);   ql.setTransition(8,4,0); 
        ql.setTransition(1,5,0);   ql.setTransition(6,5,0);   ql.setTransition(9,5,0); 
        ql.setTransition(5,6,0);   ql.setTransition(7,6,0);   ql.setTransition(9,6,0); 
        ql.setTransition(3,7,0);   ql.setTransition(4,7,0);   ql.setTransition(6,7,0);
        ql.setTransition(4,8,0);   ql.setTransition(10,8,0);  ql.setTransition(11,8,0);
        ql.setTransition(5,9,0);   ql.setTransition(6,9,0);   ql.setTransition(12,9,0);
        ql.setTransition(8,10,0);  ql.setTransition(11,10,0); ql.setTransition(14,10,0);
        ql.setTransition(8,11,0);  ql.setTransition(10,11,0); ql.setTransition(15,11,0);
        ql.setTransition(9,12,0);  ql.setTransition(16,12,0); ql.setTransition(18,12,0);
        ql.setTransition(14,13,0); ql.setTransition(17,13,0); 
        ql.setTransition(10,14,0); ql.setTransition(13,14,0); ql.setTransition(17,14,0);
        ql.setTransition(11,15,0); ql.setTransition(20,15,0); ql.setTransition(22,15,0);
        ql.setTransition(12,16,0); ql.setTransition(18,16,0); ql.setTransition(19,16,0);
        ql.setTransition(13,17,0); ql.setTransition(14,17,0); ql.setTransition(20,17,0);
        ql.setTransition(12,18,0); ql.setTransition(16,18,0); ql.setTransition(24,18,0);
        ql.setTransition(16,19,0); ql.setTransition(22,19,0); ql.setTransition(23,19,0);
        ql.setTransition(15,20,0); ql.setTransition(17,20,0); ql.setTransition(21,20,0);
        ql.setTransition(15,21,0); ql.setTransition(20,21,0); ql.setTransition(23,21,0);
        ql.setTransition(19,22,0); ql.setTransition(23,22,0); ql.setTransition(25,22,0);
        ql.setTransition(19,23,0); ql.setTransition(21,23,0); ql.setTransition(22,23,0);
        ql.setTransition(18,24,0); ql.setTransition(25,24,0); ql.setTransition(26,24,100);
        ql.setTransition(22,25,0); ql.setTransition(24,25,0); ql.setTransition(26,25,100);
        ql.setTransition(26,26,100);                
    }
    /**
     * all possible moves in thre slices Hanoi Tower.
     */
    private void setMovesVisible() {
        moveArray[0]   = "  +     |     |  \n"; 
        moveArray[0]  += " -+-    |     |  \n";   
        moveArray[0]  += "--+--   |     |  \n";
        
        moveArray[1]   = "  |     |     |  \n";
        moveArray[1]  += " -+-    |     |  \n";
        moveArray[1]  += "--+--   |     +  \n";
        
        moveArray[2]   = "  |     |     |  \n";
        moveArray[2]  += " -+-    |     |  \n";
        moveArray[2]  += "--+--   +     |  \n";
        
        moveArray[3]   = "  |     |     |  \n";
        moveArray[3]  += "  |     |     |  \n";
        moveArray[3]  += "--+--   +    -+- \n";
        
        moveArray[4]   = "  |     |     |  \n";
        moveArray[4]  += "  |     |     +  \n";
        moveArray[4]  += "--+--   |    -+- \n";
        
        moveArray[5]   = "  |     |     |  \n";
        moveArray[5]  += "  |     |     |  \n";
        moveArray[5]  += "--+--  -+-    +  \n";
        
        moveArray[6]   = "  |     |     |  \n";
        moveArray[6]  += "  +     |     |  \n";
        moveArray[6]  += "--+--  -+-    |  \n";
        
        moveArray[7]   = "  |     |     |  \n";
        moveArray[7]  += "  +     |     |  \n";
        moveArray[7]  += "--+--   |    -+- \n";
        
        moveArray[8]   = "  |     |     |  \n";
        moveArray[8]  += "  |     |     +  \n";
        moveArray[8]  += "  |   --+--  -+- \n";
        
        moveArray[9]   = "  |     |     |  \n";
        moveArray[9]  += "  |     +     |  \n";
        moveArray[9]  += "--+--  -+-    |  \n";
        
        moveArray[10]  = "  |     |     |  \n";
        moveArray[10] += "  |     |     |  \n";
        moveArray[10] += "  +   --+--  -+- \n";
        
        moveArray[11]  = "  |     |     |  \n";
        moveArray[11] += "  |     +     |  \n";
        moveArray[11] += "  |   --+--  -+- \n";
        
        moveArray[12]  = "  |     |     |  \n";
        moveArray[12] += "  |     +     |  \n";
        moveArray[12] += "  |    -+-  --+--\n";
        
        moveArray[13]  = "  |     +     |  \n";
        moveArray[13] += "  |    -+-    |  \n";
        moveArray[13] += "  |   --+--   |  \n";
        
        moveArray[14]  = "  |     |     |  \n";
        moveArray[14] += "  |    -+-    |  \n";
        moveArray[14] += "  +   --+--   |  \n";
        
        moveArray[15]  = "  |     |     |  \n";
        moveArray[15] += "  |     +     |  \n";
        moveArray[15] += " -+-  --+--   |  \n";
        
        moveArray[16]  = "  |     |     |  \n";
        moveArray[16] += "  |     |     +  \n";
        moveArray[16] += "  |    -+-  --+--\n";
        
        moveArray[17]  = "  |     |     |  \n";
        moveArray[17] += "  |    -+-    |  \n";
        moveArray[17] += "  |   --+--   +  \n";
        
        moveArray[18]  = "  |     |     |  \n";
        moveArray[18] += "  |     |     |  \n";
        moveArray[18] += "  +    -+-  --+--\n";

        moveArray[19]  = "  |     |     |  \n";
        moveArray[19] += "  |     |     +  \n";
        moveArray[19] += " -+-    |   --+--\n";
        
        moveArray[20]  = "  |     |     |  \n";
        moveArray[20] += "  |     |     |  \n";
        moveArray[20] += " -+-  --+--   +  \n";
        
        moveArray[21]  = "  |     |     |  \n";
        moveArray[21] += "  +     |     |  \n";
        moveArray[21] += " -+-  --+--   |  \n";
        
        moveArray[22]  = "  |     |     |  \n";
        moveArray[22] += "  |     |     |  \n";
        moveArray[22] += " -+-    +   --+--\n";
        
        moveArray[23]  = "  |     |     |  \n";
        moveArray[23] += "  +     |     |  \n";
        moveArray[23] += " -+-    |   --+--\n";

        moveArray[24]  = "  |     |     |  \n";
        moveArray[24] += "  |     |    -+- \n";
        moveArray[24] += "  +     |   --+--\n";

        moveArray[25]  = "  |     |     |  \n";
        moveArray[25] += "  |     |    -+- \n";
        moveArray[25] += "  |     +   --+--\n";

        moveArray[26]  = "  |     |     +  \n";
        moveArray[26] += "  |     |    -+- \n";
        moveArray[26] += "  |     |   --+--\n";
    }
    public String printState(int nr) {
        String res = "";
        if ( nr < statesHanoi && nr >= 0) {
            res = moveArray[nr];
        }
        return res;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReinforcementLearning_Hanoi hanoiGame = 
                new ReinforcementLearning_Hanoi();

        int rounds = 1000;
        if ( args.length == 1 ) {
            rounds =  Integer.valueOf(args[0]);
        }
        if ( args.length == 2 ) {
            double lambda =  Double.parseDouble(args[1]);
            hanoiGame.setLambda(lambda);
        }
        for ( int i = 0; i < rounds; i++ ) {
            String res = hanoiGame.learn();
            System.out.print(".");
//            System.out.print(res);
        }
        hanoiGame.print();
        System.out.print(hanoiGame.bestMoves());
                        
    }
    
}
