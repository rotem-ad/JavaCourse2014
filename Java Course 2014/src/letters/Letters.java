package letters;

import java.util.ArrayList;
import java.util.Collections;

import model.algorithms.DomainInstance;
import model.algorithms.State;

public class Letters implements DomainInstance {
	// Data Members
	private State startState;
	private State goalState;
	
	// Methods
	public Letters(String start, String goal) {
		startState = new State();
		goalState = new State();
		
		startState.setState(start);
		goalState.setState(goal);
		
	}
	
	public Letters(String goal) {
		startState = new State();
		goalState = new State();
		
		// Set goal state as given goal word
		goalState.setState(goal);
		
		// Shuffle given goal word and set as start state
		startState.setState(shuffleWord(goal));
	}
	
	public State getStartState() {
		return startState;
	}
	public void setStartState(State startState) {
		this.startState = startState;
	}
	public State getGoalState() {
		return goalState;
	}
	public void setGoalState(State goalState) {
		this.goalState = goalState;
	}
	
	// Method that shuffles a given string
	private String shuffleWord(String word) {
		ArrayList<Character> chars = new ArrayList<Character>(word.length());
		for ( char c : word.toCharArray() ) {
		   chars.add(c);
		}
		Collections.shuffle(chars);
		char[] shuffled = new char[chars.size()];
		for ( int i = 0; i < shuffled.length; i++ ) {
		   shuffled[i] = chars.get(i);
		}
		
		return new String(shuffled);
	}
	
	
}
