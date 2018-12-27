package factories;

import entities.Cluster;

public interface ClusterFactory {
	
	Cluster createCluster(String id,int rows,int columns);
}
