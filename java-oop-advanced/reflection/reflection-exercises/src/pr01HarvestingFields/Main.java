package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Field[] richSoilFields = RichSoilLand.class.getDeclaredFields();
		
		List<Field> privateFields = new ArrayList<>();
		List<Field> protectedFields = new ArrayList<>();
		List<Field> publicFields = new ArrayList<>();
		
		for (Field field : richSoilFields) {
			if ( Modifier.isPrivate(field.getModifiers())){
				privateFields.add(field);
			}
			if ( Modifier.isProtected(field.getModifiers())){
				protectedFields.add(field);
			}
			if ( Modifier.isPublic(field.getModifiers())){
				publicFields.add(field);
			}
			
		}
		
		String line;
		
		while (!"HARVEST".equals(line=reader.readLine())){
			
			switch (line){
				case "private":
					privateFields
							.forEach(f-> System.out.println(String.format("private %s %s",
									f.getType().getSimpleName(),
									f.getName())));
					break;
				case "protected":
					protectedFields
							.forEach(f-> System.out.println(String.format("protected %s %s",
									f.getType().getSimpleName(),
									f.getName())));
					break;
				case "public":
					publicFields
							.forEach(f-> System.out.println(String.format("public %s %s",
									f.getType().getSimpleName(),
									f.getName())));
					break;
				case "all":
					Arrays.stream(richSoilFields)
							.forEach(f->{
								if ( Modifier.isPrivate(f.getModifiers())){
									System.out.println(String.format("private %s %s",
											f.getType().getSimpleName(),
											f.getName()));
								}else if ( Modifier.isProtected(f.getModifiers())){
									System.out.println(String.format("protected %s %s",
											f.getType().getSimpleName(),
											f.getName()));
								}else if ( Modifier.isPublic(f.getModifiers())){
									System.out.println(String.format("public %s %s",
											f.getType().getSimpleName(),
											f.getName()));
								}
							});
					break;
			}
			
			
		}
		
		
	
	}
}
