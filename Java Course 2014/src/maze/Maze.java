package maze;

import model.algorithms.DomainInstance;
import model.algorithms.State;

public abstract class Maze implements DomainInstance{
	// Data Members
	protected State startState;
	protected State goalState;
	protected int[][] mat;
	protected int rows;
	protected int cols;
	
	// Constants
	protected static final int FREE = 0;
	protected static final int WALL = -1;
	protected static final int MOUSE = 1;
	protected static final int CHEESE = 2;
	
	// Methods
	public Maze() {}
	
	public abstract State getStartState();
	
	public abstract void setStartState(State startState);
	
	public abstract State getGoalState();
	
	public abstract void setGoalState(State goalState);

	public abstract int[][] getMat();

	public abstract void setMat(int[][] mat);

	public abstract int getRows();

	public abstract void setRows(int rows);

	public abstract int getCols() ;

	public abstract void setCols(int cols);
}
