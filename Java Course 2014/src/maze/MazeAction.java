package maze;

import java.awt.Point;

import model.algorithms.Action;
import model.algorithms.State;

public class MazeAction implements Action{
	// Data Members
	private String name;
	private int xShift;
	private int yShift;
	private double cost;
	
	// Constants
	protected static final int MIN_ACTION_CODE = 1;
	protected static final int MAX_ACTION_CODE = 8;
	protected static final double STRAIGHT_MOVE_COST  = 10;
	protected static final double DIAGONAL_MOVE_COST = 15;
	protected static final int MOVE_UP = 1;
	protected static final int MOVE_DOWN = 2;
	protected static final int MOVE_RIGHT = 3;
	protected static final int MOVE_LEFT = 4;
	protected static final int MOVE_UP_RIGHT = 5;
	protected static final int MOVE_UP_LEFT = 6;
	protected static final int MOVE_DOWN_RIGHT = 7;
	protected static final int MOVE_DOWN_LEFT = 8;
		
	public MazeAction(int actionCode) {
		switch (actionCode) {
		case MOVE_UP:
			this.setName("Move Up");
			this.setxShift(-1);
			this.setyShift(0);
			this.setCost(STRAIGHT_MOVE_COST);
			break;
		case MOVE_DOWN:
			this.setName("Move Down");
			this.setxShift(1);
			this.setyShift(0);
			this.setCost(STRAIGHT_MOVE_COST);
			break;
		case MOVE_RIGHT:
			this.setName("Move Right");
			this.setxShift(0);
			this.setyShift(1);
			this.setCost(STRAIGHT_MOVE_COST);
			break;
		case MOVE_LEFT:
			this.setName("Move Left");
			this.setxShift(0);
			this.setyShift(-1);
			this.setCost(STRAIGHT_MOVE_COST);
			break;
		case MOVE_UP_RIGHT:
			this.setName("Move Up Right");
			this.setxShift(-1);
			this.setyShift(1);
			this.setCost(DIAGONAL_MOVE_COST);
			break;
		case MOVE_UP_LEFT:
			this.setName("Move Up Left");
			this.setxShift(-1);
			this.setyShift(-1);
			this.setCost(DIAGONAL_MOVE_COST);
			break;
		case MOVE_DOWN_RIGHT:
			this.setName("Move Down Right");
			this.setxShift(1);
			this.setyShift(1);
			this.setCost(DIAGONAL_MOVE_COST);
			break;
		case MOVE_DOWN_LEFT:
			this.setName("Move Down Left");
			this.setxShift(1);
			this.setyShift(-1);
			this.setCost(DIAGONAL_MOVE_COST);
			break;
		default:
			this.setName("NONE");
			this.setxShift(0);
			this.setyShift(0);
			this.setCost(0);
			break;
		}
	}
	
	@Override
	public State doAction(State state) {
		// Create new State object as copy of given State
		State newState = new State(state);
		// Convert it to Point type
		Point point = MazeDomain.stateToPoint(newState);
		
		//Change x,y values according to xShift and yShift 
		point.move((int)point.getX()+this.getxShift(),(int)point.getY()+this.getyShift());
		
		// Update state data member with new string location
		newState.setState(MazeDomain.pointToString(point));
		
		// Update g data member of newState
		newState.setG(state.getG() + this.getCost());
		
		return newState;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int getxShift() {
		return xShift;
	}

	private void setxShift(int xShift) {
		this.xShift = xShift;
	}

	private int getyShift() {
		return yShift;
	}

	private void setyShift(int yShift) {
		this.yShift = yShift;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}


}