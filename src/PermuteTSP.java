//Yin Zhao
//UNI:yz2426
//compute traveling salesman problem by permutation

import java.util.ArrayList;


public class PermuteTSP {

	//num number of cities, paths ArrayList of String representation of city sequence
	//path the chosen shortest path
	private int num;
	private ArrayList<String> paths;
	private ArrayList<RandomCity.City> path;
	private ArrayList<RandomCity.City> cities;
	private double minDis;
	
	
	public PermuteTSP(ArrayList<RandomCity.City> cities, int n) {
		this.cities = cities;
		num = n;
		minDis = 100;
		paths = new ArrayList<String>();
		path = new ArrayList<RandomCity.City>(n);
		
		//create a string of 0 to n-1 and generate all permutations
		String str = "";
		for(int i = 0;i < n; i++)
			str += i;
		permute(str);
	}
	
	private void permute(String str) {
		permute("", str);
	}
	//recursively generate all permutations
	public void permute(String str1, String str2) {
		int n = str2.length();
		if(n == 1) {
			paths.add(str1 + str2);
		}
		else {
			for(int i = 0; i < n; i++)
				permute(str1 + str2.charAt(i), str2.substring(0, i) + str2.substring(i + 1));
		}
	}
	
	public ArrayList<RandomCity.City> findShortest() {
		
		String shortest = "";
		for (String str : paths){
			double dis = 0;
			int x, y;
			RandomCity.City a;
			RandomCity.City b;
			for(int i = 0; i < num - 1; i++){
				if(str.charAt(i) > str.charAt(i + 1)) {
					x = str.charAt(i) - 48;
					y = str.charAt(i + 1) - 48;
				}
				else {
					x = str.charAt(i + 1) - 48;
					y = str.charAt(i) - 48;
				}
				a = cities.get(x);
				b = cities.get(y);
				dis += a.edges.get(y).distance;
			}
			
			if(dis < minDis) {
				minDis = dis;
				shortest = str;
			}
		}
		
		for(int i = 0; i < num; i++) {
			path.add(cities.get(shortest.charAt(i) - 48));
		}
		return path;
	}
	
}
