package pizzeria;
import java.util.ArrayList;
import java.util.List;

public class matrix {
	public boolean [][] edge;

	public matrix(int n) {
		edge = new boolean[n][n];
	}

	public void addEdge(int o, int d) {
		edge[o][d] = true;
	}

	public void removeEdge(int o, int d) {
		edge[o][d] = false;
	}

	public boolean hasEdge(int o, int d) {
		return edge[o][d];
	}

	public List<Integer> inEdge(int v) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < edge.length; i++) {
			if (edge[i][v]) {
				list.add(i);
			}
		}
		return list;
	}

	public List<Integer> outEdge(int v) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < edge.length; i++) {
			if (edge[v][i]) {
				list.add(i);
			}
		}
		return list;
	}
}