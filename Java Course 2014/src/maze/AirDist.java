package maze;

import java.awt.Point;

import model.algorithms.Distance;
import model.algorithms.State;

public class AirDist implements Distance {

	// Represents h score in maze problem

	@Override
	public double getDistance(State from, State to) {
		// New corrected air distance
		Point a = MazeDomain.stateToPoint(from);
		Point b = MazeDomain.stateToPoint(to);
		
		int deltaX = (int) Math.abs(a.getX() - b.getX());
		int deltaY = (int) Math.abs(a.getY() - b.getY());
		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2))) * MazeDomain.STEP_COST;
	}

}
