/*
 * AndreBetz.de
 */

package reinforcementlearning_hanoi;

import java.util.ArrayList;

/**
 *
 * @author AndreBetz.de
 */
public class QLearning {
    private double lambda;
    private int states;   
    private int lastState;
    private my2DMatrix Q;
    private my2DMatrix R;
    public QLearning(int states, double lambda) {
      this.states = states;
      Q = new my2DMatrix(states, states);
      R = new my2DMatrix(states, states);
      Q.init(0);
      R.init(-1);
      this.lambda = lambda;
      lastState = states - 1;
    }
    public void setTransition(int x, int y, int val) {
        R.set(x, y, val);
    }
    public String print() {
        return R.print();
    }
    public void learnStep() {
        int currState = chooseNextState(states);        
        while ( currState != lastState ) {
            int[] nextPossStates = getActions(R,currState);       
            int nextState = chooseNextState(nextPossStates.length);
            int[] possActions = getActions(Q,nextState);
            int maxQ = getMaximumActions(possActions);
    //        double newVal = R.get()
            currState = nextState;
        }        
    }
    private int[] getActions(my2DMatrix m, int state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for ( int x = 0; x < m.getSizeX(); x++ ) {
            if ( m.get(x,state) >= 0 ) {
                actions.add(x);
            }
        }
        if ( actions.size() == 0 ) {
            return null;
        } else {
            int[] liste = new int[actions.size()];
            for ( int i = 0; i < actions.size(); i++ ) {
                liste[i] = actions.get(i);
            }
            return liste;
        }
    }
    private int getMaximumActions(int[] actions) {
        int maxVal = 0;
        for ( int i = 0; i < actions.length; i++ ) {
            if ( actions[i] > maxVal ) {
                maxVal = actions[i];
            }
        }
        return maxVal;
    }
    private int chooseNextState(int states) {
        return (int)(Math.random() * states);
    }
}
