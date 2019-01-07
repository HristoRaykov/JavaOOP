package P07_1984.models;

import P07_1984.models.entities.Entity;
import P07_1984.models.institutions.Institution;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class MediatorImpl implements Mediator {
	
	private List<Institution> institutions;
	
	private Map<String, Entity> entities;
	
	
	public MediatorImpl() {
		this.entities = new LinkedHashMap<>();
		this.institutions = new ArrayList<>();
		
	}
	
	@Override
	public Entity getEntityById(String id) {
		return this.entities.get(id);
	}
	
	@Override
	public void addEntity(Entity entity) {
		this.entities.putIfAbsent(entity.getId(), entity);
	}
	
	@Override
	public void addInstitution(Institution institution) {
		List<String> fieldNamesToMonitor = institution.getFieldNamesToMonitor();
		List<Entity> entities = new ArrayList<>();
		fieldNamesToMonitor.
				forEach(fieldName -> entities.addAll(this.getEntitiesByFieldName(fieldName)));
		
		institution.setEntities(entities);
		this.institutions.add(institution);
	}
	
	@Override
	public void registerChange(Entity entity, String fieldName, String fieldValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		List<Institution> institutions = this.findInstitutionsByFieldName(fieldName);
		String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
		Class<? extends Entity> entityClass = entity.getClass();
		Method method = entityClass.getMethod(methodName);
		Object oldValue = method.invoke(entity);
		if (oldValue instanceof Integer) {
			institutions.
					forEach(institution -> {
						int value = Integer.parseInt(fieldValue);
						institution.addEntityChangeLog(String.format("--%s(ID:%s) changed %s(%s) from %s to %s",
								entity.getClass().getSimpleName(), entity.getId(),
								fieldName, "int", oldValue, value));
					});
		}else {
			institutions.
					forEach(institution ->
						institution.addEntityChangeLog(String.format("--%s(ID:%s) changed %s(%s) from %s to %s",
								entity.getClass().getSimpleName(), entity.getId(),
								fieldName, "String", oldValue, fieldValue))
					);
		}
		
	}
	
	
	private List<Institution> findInstitutionsByFieldName(String fieldName) {
		return institutions.stream()
				.filter(institution -> institution.getFieldNamesToMonitor().contains(fieldName))
				.collect(Collectors.toList());
	}
	
	private List<Entity> getEntitiesByFieldName(String fieldName) {
		return this.entities.values().stream()
				.filter(entity -> {
					List<Field> fields = this.getAllFieldsInheretedOrNot(entity);
					return fields.stream()
							.map(Field::getName)
							.collect(Collectors.toList())
							.contains(fieldName);
				})
				.collect(Collectors.toList());
	}
	
	private List<Field> getAllFieldsInheretedOrNot(Entity entity) {
		List<Field> result = new ArrayList<>();
		Field[] superFields = entity.getClass().getSuperclass().getDeclaredFields();
		Field[] fields = entity.getClass().getDeclaredFields();
		
		Collections.addAll(result, superFields);
		Collections.addAll(result, fields);
		
		return result;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		for (Institution institution : institutions) {
			result.append(institution.toString()).append(System.lineSeparator());
		}
		
		return result.toString();
	}
}
