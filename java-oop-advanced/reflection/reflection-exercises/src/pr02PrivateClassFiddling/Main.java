package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, ClassNotFoundException, NoSuchFieldException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		Class<BlackBoxInt> clazz = BlackBoxInt.class;
		Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		BlackBoxInt blackBox = constructor.newInstance();
		Field innerValue = clazz.getDeclaredField("innerValue");
		innerValue.setAccessible(true);
		String line;
		while (!"END".equals(line=reader.readLine())){
			String[] params = line.split("_");
			switch (params[0]){
				case "add":
					Method methodAdd =  clazz.getDeclaredMethod(params[0], int.class);
					methodAdd.setAccessible(true);
					methodAdd.invoke(blackBox,Integer.parseInt(params[1]));
					Object result = innerValue.get(blackBox);
					System.out.println(result);
					break;
				case "subtract":
					Method methodSubtract =  clazz.getDeclaredMethod(params[0], int.class);
					methodSubtract.setAccessible(true);
					methodSubtract.invoke(blackBox,Integer.parseInt(params[1]));
					System.out.println(innerValue.get(blackBox));
					break;
				case "divide":
					Method methodDivide =  clazz.getDeclaredMethod(params[0], int.class);
					methodDivide.setAccessible(true);
					methodDivide.invoke(blackBox,Integer.parseInt(params[1]));
					System.out.println(innerValue.get(blackBox));
					break;
				case "multiply":
					Method methodMultiply =  clazz.getDeclaredMethod(params[0], int.class);
					methodMultiply.setAccessible(true);
					methodMultiply.invoke(blackBox,Integer.parseInt(params[1]));
					System.out.println(innerValue.get(blackBox));
					break;
				case "rightShift":
					Method methodRightShift =  clazz.getDeclaredMethod(params[0], int.class);
					methodRightShift.setAccessible(true);
					methodRightShift.invoke(blackBox,Integer.parseInt(params[1]));
					System.out.println(innerValue.get(blackBox));
					break;
				case "leftShift":
					Method methodLeftShift =  clazz.getDeclaredMethod(params[0], int.class);
					methodLeftShift.setAccessible(true);
					methodLeftShift.invoke(blackBox,Integer.parseInt(params[1]));
					System.out.println(innerValue.get(blackBox));
					break;
			}
			
			
		}
		
		
	}
}
