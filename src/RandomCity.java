//Yin Zhao
//yz2426

import java.util.ArrayList;


public class RandomCity {

	private ArrayList<City> cities;
	
	private int num;
	//each city has x,y coordinates, boolean visited, an ArrayList of Edges
	class City {
		double x,y;
		boolean visited;
		ArrayList<Edge> edges;
		City(double x1, double y1) {
			x = x1;
			y = y1;
			visited = false;
			edges = new ArrayList<Edge>(num);
		}
	}
	//each Edge has references to its two cities/vertices, and a distance
	class Edge {
		City a,b;
		double distance;
		Edge(City a, City b, double dis) {
			this.a = a;
			this.b = b;
			distance = dis;
		}
	}
	
	public RandomCity(int n) {
		num = n;
		cities = new ArrayList<City>(n);
		generate();
	}
	//method to create an ArrayList of cities out of n random pairs of coordinates
	//fill out a list of edges for each city
	public void generate() {
		for(int i = 0; i < num; i++) {
			double x = Math.random();
			double y = Math.random();
			cities.add(new City(x, y));
		}

		for (int i = 0; i < num - 1; i++) {
			for(int j = i + 1; j < num; j++) {
				City a = cities.get(i);
				City b = cities.get(j);
				Edge e = new Edge(a, b, Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
				a.edges.add(e);
				b.edges.add(e);
			}
		}
	}
	
	//method to get the ArrayList of Cities
	public ArrayList<City> getCities() {
		return cities;
	}
	
}
