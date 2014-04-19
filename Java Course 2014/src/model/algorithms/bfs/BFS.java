/*
Author: Rotem Adhoh
ID: 301738845
*/

package model.algorithms.bfs;

import java.util.ArrayList;
import java.util.Stack;

import model.algorithms.AbsSearcher;
import model.algorithms.Action;
import model.algorithms.Distance;
import model.algorithms.Domain;
import model.algorithms.State;

public class BFS extends AbsSearcher {
	// Data Members
	private Domain domain;
	private Distance f;

	// Methods
	public BFS(Domain domain, Distance f) {
		setDomain(domain);
		this.f = f;
	}
	
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
	public Distance getF() {
		return f;
	}

	public void setF(Distance f) {
		this.f = f;
	}
	
	public ArrayList<Action> search(State start, State goal) {
	
		// Initialize start state
		start.setCameFrom(null);
		start.setPrevAction(null);
		//start.setG(0);
		start.setF(f.getDistance(start,goal));
		
		// Add start state to priority queue
		addToOpenList(start);	
		
		while ( !( isOpenListEmpty() ) ) {
			// q is a state with lowest f value
			State q = removeFromOpenList();
			
			// Check if goal is reached
			if (q.equals(goal))
				return reconstructPath(q);
			
			// Add q to closed list
			addToClosedList(q);
			
			// For each legal action a derived from state q
			for(Action a : domain.getActions(q)){
				State qTag = a.doAction(q);
				
				if (containedInClosedList(qTag))
					continue;
				
				if ( !(containedInOpenList(qTag)))
				{
					qTag.setCameFrom(q);
					qTag.setPrevAction(a);
					qTag.setF(f.getDistance(qTag, goal));
					if ( !( containedInOpenList(qTag) ) )
							addToOpenList(qTag);
				}
			}
		
		}
		return null;
	}
	
	private ArrayList<Action> reconstructPath(State current) {
		ArrayList<Action> actionList = new ArrayList<Action>(); 
		Stack<Action> actionStack = new Stack<Action>();
		
		while (current.getPrevAction() != null) {
			actionStack.push(current.getPrevAction());
			current = current.getCameFrom();
		}
		
		while (!(actionStack.isEmpty())) {
			actionList.add(actionStack.pop());
		}
		
		return actionList;
	}
	
}

