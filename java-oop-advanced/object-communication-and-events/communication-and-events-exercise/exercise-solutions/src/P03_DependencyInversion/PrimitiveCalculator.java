package P03_DependencyInversion;


import P03_DependencyInversion.strategies.CalculationStrategy;

public class PrimitiveCalculator implements Calculator{

    private CalculationStrategy calculationStrategy;
	
	
	public PrimitiveCalculator(CalculationStrategy calculationStrategy) {
		this.calculationStrategy = calculationStrategy;
	}
	
	@Override
	public void setCalculationStrategy(CalculationStrategy calculationStrategy) {
		this.calculationStrategy = calculationStrategy;
	}
	
	@Override
	public int executeStrategy(int firstOperand, int secondOperand) {
		return this.calculationStrategy.calculate(firstOperand,secondOperand);
	}
}
