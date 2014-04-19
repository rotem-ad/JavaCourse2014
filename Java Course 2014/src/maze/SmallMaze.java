package maze;

import model.algorithms.State;

public class SmallMaze extends Maze {
	
	// Methods
	public SmallMaze()
	{
		this.mat = new int[][]{
				  {CHEESE,FREE,FREE,FREE},
				  {WALL,WALL,FREE,FREE},
				  {FREE,FREE,FREE,MOUSE}
				};
		
		this.setRows(mat.length);
		this.setCols(mat[0].length);
		
		startState = new State();
		goalState = new State();
		
		startState.setState("2,3");
		goalState.setState("0,0");
	}
	
	public State getStartState() {
		return startState;
	}
	public void setStartState(State startState) {
		this.startState = startState;
	}
	public State getGoalState() {
		return goalState;
	}
	public void setGoalState(State goalState) {
		this.goalState = goalState;
	}

	public int[][] getMat() {
		return mat;
	}

	public void setMat(int[][] mat) {
		this.mat = mat;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}
}
