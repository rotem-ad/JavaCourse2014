package model.algorithms;

import java.util.ArrayList;

public interface Searcher {
	// Methods
	public ArrayList<Action> search(State start, State goal);
	public int getNumOfEvaluatedNodes();
}
