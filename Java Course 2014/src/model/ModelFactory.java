package model;

import model.algorithms.Distance;
import model.algorithms.Domain;
import model.algorithms.Searcher;

public class ModelFactory {

	public Domain createDomain(String type) {
		// Create required domain using the domain factory
		DomainFactory factory = new DomainFactory();
		return factory.createDomain(type);
	}

	public Distance createDistance(String type) {
		// Create required distance using the distance factory
		DistanceFactory factory = new DistanceFactory();
		return factory.createDistance(type);
	}

	public Searcher createSearcher(String type, Domain domain, Distance[] distances) {
		// Create required searcher using the searcher factory
		SearcherFactory factory = new SearcherFactory(domain, distances);
		return factory.createSearcher(type);
	}

}
