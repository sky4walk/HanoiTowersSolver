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
    private my2DMatrix Q;
    private my2DMatrix R;
    public QLearning(int states, double lambda) {
      this.states = states;
      Q = new my2DMatrix(states, states);
      R = new my2DMatrix(states, states);
      Q.init(0);
      R.init(-1);
      this.lambda = lambda;
    }
    public void setTransition(int x, int y, int val) {
        R.set(x, y, val);
    }
    public void setLambda(double lambda) {
      this.lambda = lambda;        
    }
    public String print() {
        String res = "R-Matrix\n";
        res += R.print();
        res += "\nQ-Matrix\n";
        res += Q.print();
        return res;
    }
    public String episode(int endState) {
        String res = "";
        if ( endState >= states ) {
            endState = states - 1;
        }
        int currState = chooseNextState(states);        
        while ( currState != endState ) {
            res += "CS:" + currState;
            int[] nextPossStates = getActions(R,currState);
            int nextStatePos = chooseNextState(nextPossStates.length);
            int nextState = nextPossStates[nextStatePos];
            res += " NS:" + nextState;
            int[] possActions = getActions(R,nextState);
            int maxQ = getMaximumActions(possActions,nextState);
            res += " max:" + maxQ +"\n";
            double newVal = R.get(nextState,currState) + lambda * maxQ;
            Q.set(nextState,currState, (int)newVal);
            currState = nextState;
        }
        return res;
    }
    private int[] getActions(my2DMatrix m, int state) {
        ArrayList<Integer> actions = new ArrayList<Integer>();
        for ( int x = 0; x < m.getSizeX(); x++ ) {
            int transition = m.get(x,state);
            if ( transition >= 0 ) {
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
    private int getMaximumActions(int[] actions, int state) {
        int maxVal = 0;
        for ( int i = 0; i < actions.length; i++ ) {
            int action = actions[i];
            int weight = Q.get(action, state);
            if ( weight > maxVal ) {
                maxVal = weight;
            }
        }
        return maxVal;
    }
    private int chooseNextState(int states) {
        return (int)(Math.random() * states);
    }
    public int[] traceRoute(int startState, int endState) {
        return null;
    }
}
