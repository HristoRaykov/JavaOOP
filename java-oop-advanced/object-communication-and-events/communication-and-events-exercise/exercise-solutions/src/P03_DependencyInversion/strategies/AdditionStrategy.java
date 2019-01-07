package P03_DependencyInversion.strategies;

public class AdditionStrategy implements CalculationStrategy{
	
	@Override
    public int calculate(int firstOperand, int secondOperand){
        return firstOperand + secondOperand;
    }
    
}
