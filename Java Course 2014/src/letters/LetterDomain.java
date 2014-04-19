package letters;

import java.util.ArrayList;

import model.algorithms.Action;
import model.algorithms.Domain;
import model.algorithms.State;

public class LetterDomain implements Domain {
	
	// Data Members
	private Letters letters;
	
	// Constants
		protected static final int STEP_COST = 1;
	
	// Methods
	public LetterDomain(Letters letters) {
		this.setLetters(letters);
	}

	@Override
	public ArrayList<Action> getActions(State state) {
		String stateStr = state.getState();
		ArrayList<Action> actionsArr = new ArrayList<Action>();
		for (int i = 0; i < stateStr.length(); i++) {
			for (int j = i + 1; j < stateStr.length(); j++) {
				// Add potential swap action, in case letters are different
				if (stateStr.charAt(i) != stateStr.charAt(j))
					actionsArr.add(new LetterAction(i,j));
			}
		}
		return actionsArr;
	}

	public Letters getLetters() {
		return letters;
	}

	public void setLetters(Letters letters) {
		this.letters = letters;
	}

	@Override
	public State getStartState() {
		return letters.getStartState();
	}

	@Override
	public State getGoalState() {
		return letters.getGoalState();
	}

}
