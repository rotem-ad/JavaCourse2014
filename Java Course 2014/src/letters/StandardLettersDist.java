package letters;

import model.algorithms.Distance;
import model.algorithms.State;

public class StandardLettersDist implements Distance {

	// Represents g score in letters problem
	
	@Override
	public double getDistance(State from, State to) {
		return ( to.getG() - from.getG() ); 
	}

}

