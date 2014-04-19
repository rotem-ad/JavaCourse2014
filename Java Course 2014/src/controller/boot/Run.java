package controller.boot;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

import model.Model;

public class Run {

	public static void main(String[] args) {
		
		XStream xs = new XStream();
		
		// Handling big_maze_BFS.xml file
		BufferedReader xmlInputBFS = null;
		try {
			xmlInputBFS = new BufferedReader(new FileReader("resources/big_maze_BFS.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Load model object from xml file - big_maze_BFS.xml
		Model model1 = (Model) xs.fromXML(xmlInputBFS);
		
		// Close xml file
		try {
			xmlInputBFS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Handling big_maze_Astar.xml file
		BufferedReader xmlInputAstar = null;
		try {
			xmlInputAstar = new BufferedReader(new FileReader("resources/big_maze_Astar.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Load model object from xml file - big_maze_Astar.xml
		Model model2 = (Model) xs.fromXML(xmlInputAstar);
		
		// Close xml file
		try {
			xmlInputAstar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Solve each model
		int bfsNodes = 0;
		int astarNodes = 0;
		try {
			bfsNodes = model1.solveDomain();
			astarNodes=model2.solveDomain();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Number of evaluated nodes using BFS: " + bfsNodes);
		System.out.println("Number of evaluated nodes using Astar: " + astarNodes);
	}

}
