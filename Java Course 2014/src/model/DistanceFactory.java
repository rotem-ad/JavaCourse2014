package model;

import java.util.HashMap;

import letters.HLettersDist;
import letters.StandardLettersDist;
import maze.AirDist;
import maze.StandardMazeDist;
import model.algorithms.Distance;

public class DistanceFactory {

	private interface DistanceCreator {
		public Distance create();
	}
	
	private class AirDisCreator implements DistanceCreator {
		public AirDist create() {
			return new AirDist();
		}
	}

	private class StandardMazeDistCreator implements DistanceCreator {
		public StandardMazeDist create() {
			return new StandardMazeDist();
		}
	}
	
	private class StandardLetterDistCreator implements DistanceCreator {
		public StandardLettersDist create() {
			return new StandardLettersDist();
		}
	}

	private class HLetterDistCreator implements DistanceCreator {
		public HLettersDist create() {
			return new HLettersDist();
		}
	}

	
	HashMap<String, DistanceCreator> distancesCreators;

	public DistanceFactory() {
		distancesCreators = new HashMap<String, DistanceCreator>();
		distancesCreators.put("standard_maze", new StandardMazeDistCreator());
		distancesCreators.put("air_distance", new AirDisCreator());
		distancesCreators.put("standard_letters", new StandardLetterDistCreator());
		distancesCreators.put("h_letters", new HLetterDistCreator());
	}

	
	public Distance createDistance(String type){
		  DistanceCreator c=distancesCreators.get(type);
		  if(c!=null) return c.create(); 
		  return null;
		 }

}
