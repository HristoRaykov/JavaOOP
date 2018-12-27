package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Organism {
	
	private String name;
	
	private List<Cluster> clusters;
	
	private int clusterInOrderIndex;
	
	public Organism(String name) {
		this.name = name;
		this.clusters = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Cluster> getClusters() {
		return clusters;
	}
	
	private int getCellsCount() {
		return clusters.stream()
				.mapToInt(cluster -> cluster.getCells().size())
				.sum();
	}
	
	public Cluster getClusterInOrder(){
		int length = this.getClusters().size();
		if (length==0){
			return null;
		}
		
		Cluster cluster = clusters.get(clusterInOrderIndex);
		if (clusterInOrderIndex==length-1){
			clusterInOrderIndex=0;
		}else {
			clusterInOrderIndex++;
		}
		
		return cluster;
	}
	
	public void addCluster(Cluster cluster) {
		this.getClusters().add(cluster);
	}
	
	public boolean containsCluster(String clusterId){
		return this.getClusters().stream().anyMatch(cluster -> cluster.getId().equals(clusterId));
	}
	
	public Cluster findClusterById(String clusterId) {
		return this.getClusters().stream()
				.filter(c->c.getId().equals(clusterId))
				.collect(Collectors.toList())
				.get(0);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb
				.append("Organism - ").append(this.getName()).append(System.lineSeparator())
				.append("--Clusters: ").append(this.getClusters().size()).append(System.lineSeparator())
				.append("--Cells: ").append(this.getCellsCount()).append(System.lineSeparator());
		this.getClusters().forEach(cluster -> sb.append(cluster.toString()));
		
		return sb.toString();
	}
	
	
}
