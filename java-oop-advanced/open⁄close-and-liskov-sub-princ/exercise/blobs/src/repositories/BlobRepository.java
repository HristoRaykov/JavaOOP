package repositories;

import interfaces.Repository;
import models.Blob;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository implements Repository<Blob> {
	
	private Map<String,Blob> blobs;
	
	public BlobRepository() {
		this.blobs = new LinkedHashMap<>();
	}
	
	@Override
	public void add(Blob entity) {
		this.blobs.putIfAbsent(entity.getName(),entity);
	}
	
	@Override
	public Blob findByName(String name) {
		return blobs.get(name);
	}
	
	@Override
	public Collection<Blob> findAll() {
		return blobs.values();
	}
}
