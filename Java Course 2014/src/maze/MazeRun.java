package maze;

import java.util.ArrayList;

import model.algorithms.Action;
import model.algorithms.bfs.BFS;

public class MazeRun {

	public static void main(String[] args) {
		
		//SmallMaze maze= new SmallMaze();
		BigMaze maze= new BigMaze();
		//Astar as =new Astar(new MazeDomain(maze),new StandardMazeDist(),new AirDist());
		
		BFS as =new BFS(new MazeDomain(maze),new AirDist());
		
		ArrayList<Action> actions = as.search(maze.getStartState(),maze.getGoalState());
		for (Action a : actions)
			System.out.println(a.getName());
		
		System.out.println(as.getNumOfEvaluatedNodes());
		
	}

}
