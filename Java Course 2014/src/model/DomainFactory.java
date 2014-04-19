package model;

import java.util.HashMap;

import letters.LetterDomain;
import letters.Letters;
import maze.BigMaze;
import maze.MazeDomain;
import maze.SmallMaze;
import model.algorithms.Domain;

public class DomainFactory {

	private interface DomainCreator {
		public Domain create();
	}

	private class SmallMazeDomainCreator implements DomainCreator {
		public Domain create() {
			SmallMaze sMaze = new SmallMaze();
			return new MazeDomain(sMaze);
		}
	}

	private class BigMazeDomainCreator implements DomainCreator {
		public Domain create() {
			BigMaze bMaze = new BigMaze();
			return new MazeDomain(bMaze);
		}
	}

	private class LettersDomainCreator implements DomainCreator {
		// Data Members
		String goal;
		
		public LettersDomainCreator(String goal) {
			this.goal = goal;
		}
		
		public Domain create() {
			Letters letters = new Letters(this.goal);
			return new LetterDomain(letters);
		}
	}

	HashMap<String, DomainCreator> domainCreators;

	public DomainFactory() {
		domainCreators = new HashMap<String, DomainCreator>();
		domainCreators.put("small_maze", new SmallMazeDomainCreator());
		domainCreators.put("big_maze", new BigMazeDomainCreator());
	}

	public Domain createDomain(String type) {
		// Check type of domain - maze or letters
		if (type.contains("_maze")) {
			DomainCreator c = domainCreators.get(type);
			if (c != null)
				return c.create();
			return null;
		}

		if (type.contains("_word")) {
			String[] parseArr = type.split("_");
			DomainCreator c = new LettersDomainCreator(parseArr[0]);
			return c.create();
		}

		return null;
	}

}
