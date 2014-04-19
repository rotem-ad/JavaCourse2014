package model;

import java.io.Serializable;

import model.algorithms.Distance;
import model.algorithms.Domain;
import model.algorithms.Searcher;

public class Model implements Serializable {
	// Data Members
	Domain domain;
	Distance[] distances;
	Searcher searcher;
	
	// Constants
	protected static final int G_LOCATION = 0;
	protected static final int H_LOCATION = 1;
	
	// Methods
	public Model() {
		this.domain = null;
		this.distances = null;
		this.searcher = null;
	}
	
	public void setDomain(String key) throws Exception {
		ModelFactory factory = new ModelFactory();
		this.domain = factory.createDomain(key);
		// Check that returned domain is not null, otherwise throw exception
		if (this.domain == null) {
			throw new Exception("Domain not found for given key");
		}
	}
	
	public void setHeuristics(String[] keys) {
		ModelFactory factory = new ModelFactory();
		this.distances = new Distance[2];
		this.distances[H_LOCATION] = factory.createDistance(keys[0]);
		this.distances[G_LOCATION] = factory.createDistance(keys[1]);
	}
	
	public void setSearcher(String key) throws Exception {
		// Verify that domain and distances are set, otherwise throw exception
		if ( (this.domain == null) || (this.distances==null) ) {
			throw new Exception("Must initialize domain and distances before setting searcher");
		}
		
		// Set the searcher according to given key
		ModelFactory factory = new ModelFactory();
		this.searcher = factory.createSearcher(key,this.domain,this.distances);
		
		// Check that returned searcher is not null, otherwise throw exception
		if (this.searcher == null) {
			throw new Exception("Searcher not found for given key");
		}
		
	}
	
	public int solveDomain() throws Exception {
		// Verify that all data members are initialized, otherwise throw exception
		if ( (this.domain == null) || (this.distances==null) || (this.searcher==null) ) {
			throw new Exception("Some of Model data members are not initialized");
		}
		searcher.search(domain.getStartState(), domain.getGoalState());
		return searcher.getNumOfEvaluatedNodes();
	}

}
