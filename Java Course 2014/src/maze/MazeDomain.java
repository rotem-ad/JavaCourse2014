package maze;

import java.awt.Point;
import java.util.ArrayList;

import model.algorithms.Action;
import model.algorithms.Domain;
import model.algorithms.State;

public class MazeDomain implements Domain {
	//Data Members
	private Maze maze;
	
	// Constants
	protected static final int STEP_COST = 10;
	
	//Methods
	public MazeDomain(Maze maze) {
		setMaze(maze);
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	

	@Override
	public ArrayList<Action> getActions(State state) {
		// Create empty array
		ArrayList<Action> actionsArr = new ArrayList<Action>();
		
		// Check feasibility for every possible action 
		for (int i = MazeAction.MIN_ACTION_CODE; i <= MazeAction.MAX_ACTION_CODE; i++) {
			MazeAction action = new MazeAction(i);
			State newState = action.doAction(state);
			Point statePoint = stateToPoint(newState);
			// Check if new state in bounds of 2d array
			if ((statePoint.getX() >= 0) && (statePoint.getX() < maze.getRows()) && (statePoint.getY() >= 0) && (statePoint.getY() < maze.getCols())) {
				// Check if new location is free or contains cheese
				if ((maze.getMat()[(int)statePoint.getX()][(int)statePoint.getY()] == Maze.FREE) || (maze.getMat()[(int)statePoint.getX()][(int)statePoint.getY()] == Maze.CHEESE)) {
					actionsArr.add(action);
				}
			}
		}
		return actionsArr;
	}

	
	@Override
	public State getStartState() {
		return maze.getStartState();
	}

	@Override
	public State getGoalState() {
		return maze.getGoalState();
	}
	
	// Method that converts State to Point
	protected static Point stateToPoint(State st) {
		Point point = new Point();
		String[] arr = st.getState().split(",");
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		point.setLocation(x,y);
		return point;
	}
	
	// Method that converts Point to State String
		protected static String pointToString(Point point) {
			String stateString = ""+(int)point.getX()+","+(int)point.getY();
			return stateString;
		}

}
