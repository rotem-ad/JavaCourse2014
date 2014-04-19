package model.algorithms;

public class State implements Comparable<State> {
	// Data Members
	private double f;
	private double g;
	private String state;
	private State cameFrom; 
	private Action prevAction;
	
	// Methods
	public State() {
		this.f = 0;
		this.g= 0;
		this.state = null;
		this.prevAction = null;
		this.cameFrom = null;
	}
	
	public State(State other) {
		this.setF(other.getF());
		this.setG(other.getG());
		this.setState(other.getState());
		this.setPrevAction(other.getPrevAction());
		this.setCameFrom(other.getCameFrom());
	}
	
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public State getCameFrom() {
		return cameFrom;
	}

	public void setCameFrom(State cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	public Action getPrevAction() {
		return prevAction;
	}

	public void setPrevAction(Action prevAction) {
		this.prevAction = prevAction;
	}
	
	@Override
	public int compareTo(State s) {
		return (int) (this.getF() - s.getF());
	}
	
	@Override
	public int hashCode() {
		String stateString = this.getState();
		return stateString.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		State other = (State) obj;
		
		if (!((this.getState().equals(other.getState()))))
			return false;
		
		return true;
	}
	
}
