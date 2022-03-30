import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HW4 {
	
	public static void main(String[] args) {
 
  
  	Scanner scan = new Scanner(System.in);
		Graph graph = new Graph();
				
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] parts = line.split(" ");
			if (parts[0].equals("end")) break;
			String src = parts[0];
			String dst = parts[1];
			int cost = Integer.parseInt(parts[2]);
			int latency = Integer.parseInt(parts[3]);
			
			graph.addVertex(src);
			graph.addVertex(dst);
			Edge edge = new Edge(src, dst, cost, latency);
			graph.addEdge(edge);
		}
		
		System.out.println(Arrays.deepToString(graph.asArray(false)));
    
		//System.out.println(Arrays.deepToString(graph.asArray(true)));
		
		HW4 hw4 = new HW4();
		scan.close();
		
		System.out.println(hw4.totalLinkCost(graph));
		System.out.println(hw4.cheapestNetwork(graph.asArray(false)));
		System.out.println(hw4.savedAmount(graph));
	
	}
	
	// You can add any methods you need, both to this file and Graph.java file

	// The method for task 1 
	int totalLinkCost(Graph graph) {
		// TODO Auto-generated method stub
    int sum=0;

    for(Edge e : graph.edges){
      sum+=e.cost;
    }
		return sum;
	}
	// The method for task 2 
	int cheapestNetwork(int[][] array_graph) {
		// TODO Auto-generated method stub
    int sum=0;
	
    PriorityQueue<Edge> edgeHeap=new PriorityQueue<>();

    for(int i=0;i<array_graph[0].length;i++){
    for(int j=i+1;j<array_graph[0].length;j++){

      if(array_graph[i][j]>0){
      Edge e= new Edge(Integer.toString(i),Integer.toString(j),array_graph[i][j],0);
      edgeHeap.add(e);
      }
    }
  }
  UnionSet unionSet=new UnionSet();
  unionSet.makeSet(array_graph);
  Edge current;
  for(int i=0;i<array_graph[0].length;i++){
      current=edgeHeap.remove();
        if(unionSet.find(Integer.parseInt(current.src))!=unionSet.find(Integer.parseInt(current.dst))){
          sum+=current.cost;
          unionSet.makeUnion(Integer.parseInt(current.src),Integer.parseInt(current.dst));
        }

  }
    
    return sum;
	}
	// The method for task 3 
	int savedAmount(Graph graph) {
		// TODO Auto-generated method stub
		return totalLinkCost(graph)-cheapestNetwork(graph.asArray(false));
	}
}
