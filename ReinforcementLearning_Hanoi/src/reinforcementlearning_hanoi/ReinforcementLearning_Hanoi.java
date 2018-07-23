/*
 * AndreBetz.de
 */

package reinforcementlearning_hanoi;

/**
 *
 * @author  AndreBetz.de
 */
public class ReinforcementLearning_Hanoi {
    QLearning ql = new QLearning(27,0.5);
    public ReinforcementLearning_Hanoi() {
        setRMatrix();        
    }
    public void print() {
        System.out.print(ql.print());
    }
    public void learn() {
        ql.episode();
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReinforcementLearning_Hanoi hanoiGame = 
                new ReinforcementLearning_Hanoi();
        
        for ( int i = 0; i < 100; i++ ) {
            hanoiGame.print();
            hanoiGame.learn();
        }
        
    }
    
}
