package letters;

import java.util.ArrayList;

import model.algorithms.Action;
import model.algorithms.bfs.BFS;

public class LetterRun {

	public static void main(String[] args) {
		//Letters letters=new Letters("VAJA","JAVA");
		
		Letters letters=new Letters("JAVA");
		
		System.out.println(letters.getStartState().getState());
		System.out.println(letters.getGoalState().getState());
		
		//Astar as=new Astar(new LetterDomain(letters),new StandardLettersDist(),new HLettersDist());
		
		BFS as=new BFS(new LetterDomain(letters),new HLettersDist());
		
		ArrayList<Action> actions = as.search(letters.getStartState(),letters.getGoalState());
		for (Action a : actions)
		System.out.println(a.getName());
		
		System.out.println(as.getNumOfEvaluatedNodes());
	}

}
