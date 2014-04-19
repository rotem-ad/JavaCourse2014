/*
Author: Rotem Adhoh
ID: 301738845
*/

package model.algorithms.a_star;

import java.util.ArrayList;
import java.util.Stack;

import model.algorithms.AbsSearcher;
import model.algorithms.Action;
import model.algorithms.Distance;
import model.algorithms.Domain;
import model.algorithms.State;

public class Astar extends AbsSearcher {
	// Data Members
	private Domain domain;
	private Distance g;
	private Distance h;

	// Methods
	public Astar(Domain domain, Distance g, Distance h) {
		setDomain(domain);
		this.g = g;
		this.h = h;
	}
	
	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
	public Distance getG() {
		return g;
	}

	public void setG(Distance g) {
		this.g = g;
	}

	public Distance getH() {
		return h;
	}

	public void setH(Distance h) {
		this.h = h;
	}
	
	public ArrayList<Action> search(State start, State goal) {
	
		// Initialize start state
		start.setCameFrom(null);
		start.setPrevAction(null);
		start.setG(0);
		start.setF(g.getDistance(start,start) + h.getDistance(start,goal));
		
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
				
				double tentativeG = q.getG() + distBetween(q, qTag);
				
				if (containedInClosedList(qTag) && (tentativeG >= qTag.getG()))
					continue;
				
				if ( !(containedInOpenList(qTag)) || (tentativeG < qTag.getG()))
				{
					qTag.setCameFrom(q);
					qTag.setPrevAction(a);
					qTag.setG(tentativeG);
					qTag.setF(qTag.getG() + h.getDistance(qTag, goal));
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
	
	private double distBetween(State from, State to){
		return (to.getG() - from.getG());
	}

}

