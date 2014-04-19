package maze;

import model.algorithms.Distance;
import model.algorithms.State;

public class StandardMazeDist implements Distance {

	// Represents g score in maze problem
	
	@Override
	public double getDistance(State from, State to) {
		return ( to.getG() - from.getG() ); 
	}

}
