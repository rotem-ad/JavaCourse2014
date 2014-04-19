package letters;

import model.algorithms.Action;
import model.algorithms.State;

public class LetterAction implements Action {
	// Data Members
	private int firstPos;
	private int secondPos;
	private double cost;
	
	// Methods
	public LetterAction(int idx1,int idx2) {
			this.firstPos = idx1;
			this.secondPos = idx2;
	}

	@Override
	public State doAction(State state) {
		// Create new State object as copy of given State
		State newState = new State(state);
		int firstIdx = Math.min(firstPos, secondPos);
		int secondIdx = Math.max(firstPos, secondPos);
		String tmpString = new String(state.getState());
		char[] charArr = tmpString.toCharArray();
		// Perform the swap itself
		char tmpChar = charArr[firstIdx];
		charArr[firstIdx] = charArr[secondIdx];
		charArr[secondIdx] = tmpChar;
		// Update the swap cost
		this.setCost(secondIdx-firstIdx);
		// Update state data member of newState with newly created string
		tmpString = new String(charArr);
		newState.setState(tmpString);
		// Update g data member of newState by adding the cost of current action
		newState.setG(state.getG() + this.getCost());
		return newState;
	}

	@Override
	public String getName() {
		return "Swap character " + this.firstPos + " with character " + this.secondPos;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
