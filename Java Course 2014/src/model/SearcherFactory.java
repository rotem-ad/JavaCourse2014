package model;

import java.util.HashMap;

import model.algorithms.Distance;
import model.algorithms.Domain;
import model.algorithms.Searcher;
import model.algorithms.a_star.Astar;
import model.algorithms.bfs.BFS;

public class SearcherFactory {
	
	private Domain domain;
	private Distance[] distances;
	

	private interface SearcherCreator {
		public Searcher create(Domain domain, Distance[] distances);
	}
	
	private class AstarSearcherCreator implements SearcherCreator {
		public Astar create(Domain domain, Distance[] distances) {
			Distance gDist = distances[Model.G_LOCATION];
			Distance hDist = distances[Model.H_LOCATION];
			return new Astar(domain,gDist,hDist);
		}
	}
	
	private class BFSSearcherCreator implements SearcherCreator {
		public BFS create(Domain domain, Distance[] distances) {
			Distance hDist = distances[Model.H_LOCATION];
			return new BFS(domain,hDist);
		}
	}

	HashMap<String, SearcherCreator> searcherCreators;

	public SearcherFactory(Domain domain, Distance[] distances) {
		this.domain = domain;
		this.distances = distances;
		searcherCreators = new HashMap<String, SearcherCreator>();
		searcherCreators.put("A*",new AstarSearcherCreator() );
		searcherCreators.put("bfs",new BFSSearcherCreator() );
	}

	
	public Searcher createSearcher(String type){
		  SearcherCreator c=searcherCreators.get(type);
		  if(c!=null) return c.create(domain,distances); 
		  return null;
		 }

}
