package factories;

import entities.Cluster;

public class ClusterFactoryImpl implements ClusterFactory {
	
	@Override
	public Cluster createCluster(String id, int rows, int columns) {
		return new Cluster(id,rows,columns);
	}
}
