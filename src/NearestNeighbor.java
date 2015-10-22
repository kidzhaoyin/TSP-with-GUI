//Yin Zhao
//yz2426
//Compute Traveling salesman problem with nearest neighbor algorithm

import java.util.ArrayList;

public class NearestNeighbor {

	private ArrayList<RandomCity.City> cities;
	double minLength;
	int bestStart;
	
	public NearestNeighbor(ArrayList<RandomCity.City> theCities){
		
		cities=theCities;
		minLength=100;
		bestStart=-1;

	}
	
	//method to try all cities as the starting point and return the best routine
	public ArrayList<RandomCity.City> findBest(){
		
		for(int i=0;i<cities.size();i++)
			{
			//after each findPath() for a city, reset all visited to false to compute the path for the next starting city
				findPath(i);
				for(int j=0;j<cities.size();j++)
					cities.get(j).visited=false;
			}
		return findPath(bestStart);
	}
	
	//method to find the shortest path starting from a particular city
	public ArrayList<RandomCity.City> findPath(int startIndex){
		ArrayList<RandomCity.City> path=new ArrayList<RandomCity.City>();
		double length=0;
		RandomCity.City current=cities.get(startIndex);
		path.add(current);
		current.visited=true;
		
		while(path.size()<cities.size()){
			RandomCity.Edge e=findNearestUnknown(current);
			if(e.a.visited)
				current=e.b;
			else current=e.a;
			path.add(current);
			current.visited=true;
			
			length+=e.distance;
		}
		if (length<minLength){
			minLength=length;
			bestStart=startIndex;
		}
		return path;
	}
	//method to find the nearest unknown city
	public RandomCity.Edge findNearestUnknown(RandomCity.City c){

		//find the first unvisited edge
		int i=0;
		RandomCity.Edge nearest=c.edges.get(i);
		
		while((nearest.a.visited)&&(nearest.b.visited))
				nearest=c.edges.get(++i);
	
		//find nearest unvisited city
		for(int j=i+1;j<c.edges.size();j++){
			
			if(c.edges.get(j).distance<nearest.distance&&((!c.edges.get(j).a.visited)||(!c.edges.get(j).b.visited)))
				nearest=c.edges.get(j);
		}
		return nearest;
	}
	
	
}
