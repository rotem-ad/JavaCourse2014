package model.algorithms;

public interface Action {
	public State doAction(State state); 
	public String getName();
}
