package com.run.practice.programs.practixce_programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GraphArrayList {
	static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
		
		System.out.println("here:"+adj);
	}

// A utility function to print the adjacency list 
// representation of graph 
	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			System.out.println("\nAdjacency list of vertex" + i);
			System.out.print("head");
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(" -> " + adj.get(i).get(j));
			}
			System.out.println();
		}
	}

// Driver Code 
	public static void main(String[] args) {
// Creating a graph with 5 vertices 
		int V = 7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

// Adding edges one by one 
		/*
		 * addEdge(adj, 0, 1); addEdge(adj, 0, 4); addEdge(adj, 1, 2); addEdge(adj, 1,
		 * 3); addEdge(adj, 1, 4); addEdge(adj, 2, 3); addEdge(adj, 3, 4);
		 */
		
		addEdge(adj, 0, 1);
		addEdge(adj, 1, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 5);
		addEdge(adj, 5, 6);
		addEdge(adj, 4, 6);
		addEdge(adj, 4, 5);
		
		/*
		 * addEdge(adj, 1, 3); addEdge(adj, 3, 5); addEdge(adj, 5, 4); addEdge(adj, 5,
		 * 6); addEdge(adj, 4, 6);
		 */
		 

		printGraph(adj);
		
		System.out.println("\n"+adj);
		
		
		for(int i=1;i<adj.size();i++) {
			if(adj.get(i).size() > 1) {
				int loopCount=0;
				int count=0;
				Set<Integer> set = new HashSet<Integer>();
				for(int j=0;j<adj.get(i).size();j++) {
					//System.out.println("jth value::"+adj.get(i));
					//System.out.println("j2th value::"+adj.get(i).get(j));
					loopCount++;
					set.add(adj.get(i).get(j));
					for(int k=0;k<adj.get(adj.get(i).get(j)).size();k++) {
						if(!set.add(adj.get(adj.get(i).get(j)).get(k))) {
							count++;
						}
						//System.out.println("kth one::"+adj.get(adj.get(i).get(j)));
						
					}
					
					if(loopCount>1 && count==1) {
						System.out.println("intersect value"+i);
					}
					
					/*
					 * System.out.println("loopCount::"+loopCount);
					 * System.out.println("count::"+count); System.out.println("here::"+set);
					 */
				}
			}
		}
	}
}
