package P03_DependencyInversion;

import P03_DependencyInversion.strategies.CalculationStrategy;

public interface Calculator {
	
	void setCalculationStrategy(CalculationStrategy calculationStrategy);
	
	int executeStrategy(int firstOperand, int secondOperand);
	
}
