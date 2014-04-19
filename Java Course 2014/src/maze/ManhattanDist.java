package maze;

import java.awt.Point;

import model.algorithms.Distance;
import model.algorithms.State;

public class ManhattanDist implements Distance {

	// Represents h score in maze problem

	@Override
	public double getDistance(State from, State to) {
		// Manhattan distance
		Point a = MazeDomain.stateToPoint(from);
		Point b = MazeDomain.stateToPoint(to);
		
		int deltaX = (int) Math.abs(a.getX() - b.getX());
		int deltaY = (int) Math.abs(a.getY() - b.getY());
		return ( deltaX + deltaY ) * MazeDomain.STEP_COST;
	}

}
