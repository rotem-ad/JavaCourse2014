package maze;

import model.algorithms.State;

public class BigMaze extends Maze {
	
	// Constants
	private static final int ROWS = 16;
	private static final int COLS = 16;
	
	// Methods
	public BigMaze()
	{
		this.mat = new int[COLS][ROWS];
		
		this.setRows(mat.length);
		this.setCols(mat[0].length);
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if ( (i==0) && (j==0) ) {
					mat[i][j] = CHEESE;
				}
				if ( (i==15) && (j==15) ) {
					mat[i][j] = MOUSE;
				}
				if ( (j>=1) && (j<=14) && (i==1) ) {
					mat[i][j] = WALL;
				}
				if ( (j==1) && (i>=1) && (i<=15) ) {
					mat[i][j] = WALL;
				}
			}
		}
		
		
		startState = new State();
		goalState = new State();
		
		startState.setState("15,15");
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

