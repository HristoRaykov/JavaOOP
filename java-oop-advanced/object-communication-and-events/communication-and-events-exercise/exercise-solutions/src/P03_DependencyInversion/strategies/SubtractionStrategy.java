package P03_DependencyInversion.strategies;

public class SubtractionStrategy implements CalculationStrategy{
	
	@Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand - secondOperand;
    }
    
}
