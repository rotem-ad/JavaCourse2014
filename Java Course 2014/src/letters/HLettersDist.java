package letters;

import model.algorithms.Distance;
import model.algorithms.State;

public class HLettersDist implements Distance {
	// Represents h score in letters problem
	
	@Override
	public double getDistance(State from, State to) {
		String currStr = from.getState();
		String goalStr = to.getState();
		double count = 0;
		for (int i = 0; i < currStr.length(); i++) {
			if (currStr.charAt(i) != goalStr.charAt(i))
				count++;
		}
		// Divide count by 2 because of swap duplicates 
		count /=2;
		return (count * LetterDomain.STEP_COST);
	}

}


