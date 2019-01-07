package P03_DependencyInversion;

import P03_DependencyInversion.strategies.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CalculationStrategy strategy = new AdditionStrategy();
		Calculator calculator = new PrimitiveCalculator(strategy);
		
		String line;
		String[] params;
		while (!"End".equals(line=reader.readLine())){
			params = line.split("\\s+");
			
			if ("mode".equals(params[0])){
				switch (params[1].trim()){
					case "+":
						strategy = new AdditionStrategy();
						break;
					case "-":
						strategy = new SubtractionStrategy();
						break;
					case "*":
						strategy = new MultiplicationStrategy();
						break;
					case "/":
						strategy = new DivisionStrategy();
						break;
				}
				calculator.setCalculationStrategy(strategy);
			}else {
				int firstOperand = Integer.valueOf(params[0]);
				int secondOperand = Integer.valueOf(params[1]);
				int result = calculator.executeStrategy(firstOperand,secondOperand);
				System.out.println(result);
			}
			
		}
		
		
	}
}
