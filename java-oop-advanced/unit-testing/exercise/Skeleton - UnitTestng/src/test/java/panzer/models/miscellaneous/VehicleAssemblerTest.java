package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {
	
	private Assembler vehicleAssembler;
	
	private AttackModifyingPart arsenalPart;

	private DefenseModifyingPart shellPart;

	private HitPointsModifyingPart endurancePart;
	
	@Before
	public void setUp() throws Exception {
		this.vehicleAssembler = new VehicleAssembler();
		this.arsenalPart = Mockito.mock(AttackModifyingPart.class);
		this.shellPart = Mockito.mock(DefenseModifyingPart.class);
		this.endurancePart = Mockito.mock(HitPointsModifyingPart.class);
		this.vehicleAssembler.addArsenalPart(this.arsenalPart);
		this.vehicleAssembler.addShellPart(this.shellPart);
		this.vehicleAssembler.addEndurancePart(this.endurancePart);
	}
	
	@Test
	public void getTotalWeight() {
		//Arrange
		Mockito.when(this.arsenalPart.getWeight()).thenReturn(10.5);
		Mockito.when(this.shellPart.getWeight()).thenReturn(14.5);
		Mockito.when(this.endurancePart.getWeight()).thenReturn(10.0);
		
		//Act
		double expectedResult = 35.0;
		double actualResult = this.vehicleAssembler.getTotalWeight();
		
		//Assert
		Assert.assertEquals(expectedResult,actualResult,0.1);
		
	}
	
	@Test
	public void getTotalPrice() {
		//Arrange
		Mockito.when(this.arsenalPart.getPrice()).thenReturn(BigDecimal.valueOf(10.5));
		Mockito.when(this.shellPart.getPrice()).thenReturn(BigDecimal.valueOf(14.5));
		Mockito.when(this.endurancePart.getPrice()).thenReturn(BigDecimal.valueOf(10.0));
		
		//Act
		BigDecimal expectedResult = BigDecimal.valueOf(35.0);
		BigDecimal actualResult = this.vehicleAssembler.getTotalPrice();
		
		//Assert
		Assert.assertEquals(expectedResult,actualResult);
		
		
	}
	
	@Test
	public void getTotalAttackModification() {
		//Arrange
		AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
		Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(10);
		this.vehicleAssembler.addArsenalPart(attackModifyingPart);
		Mockito.when(this.arsenalPart.getAttackModifier()).thenReturn(20);
		
		//Act
		long expectedTotalAttackModification = 30;
		long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
		
		
		//Assert
		Assert.assertEquals(expectedTotalAttackModification,actualTotalAttackModification);
	
	
	}
	
	@Test
	public void getTotalDefenseModification() {
		//Arrange
		DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
		Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(10);
		this.vehicleAssembler.addShellPart(defenseModifyingPart);
		Mockito.when(this.shellPart.getDefenseModifier()).thenReturn(20);
		//Act
		long expectedTotalDefenceModification = 30;
		long actualTotalDefenceModification = this.vehicleAssembler.getTotalDefenseModification();
		//Assert
		Assert.assertEquals(expectedTotalDefenceModification,actualTotalDefenceModification);
		
	}
	
	@Test
	public void getTotalHitPointModification() {
		//Arrange
		HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
		Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(10);
		this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);
		Mockito.when(this.endurancePart.getHitPointsModifier()).thenReturn(20);
		
		//Act
		long expectedTotalHitPointsModification = 30;
		long actualTotalHitPointsModification = this.vehicleAssembler.getTotalHitPointModification();
		//Assert
		Assert.assertEquals(expectedTotalHitPointsModification,actualTotalHitPointsModification);
		
	}
	
	@Test
	public void addArsenalPart() {
		//Arrange
		AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
		Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
		this.vehicleAssembler.addArsenalPart(attackModifyingPart);
		Mockito.when(this.arsenalPart.getAttackModifier()).thenReturn(Integer.MAX_VALUE);
		
		//Act
		long expectedTotalAttackModification = (long) Integer.MAX_VALUE + Integer.MAX_VALUE;
		long actualTotalAttackModification = this.vehicleAssembler.getTotalAttackModification();
		
		//Assert
		Assert.assertEquals(expectedTotalAttackModification,actualTotalAttackModification);
	
	}
	
	@Test
	public void addShellPart() {
		//Arrange
		DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
		Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
		this.vehicleAssembler.addShellPart(defenseModifyingPart);
		Mockito.when(this.shellPart.getDefenseModifier()).thenReturn(Integer.MAX_VALUE);
		//Act
		long expectedTotalDefenceModification = (long)Integer.MAX_VALUE+Integer.MAX_VALUE;
		long actualTotalDefenceModification = this.vehicleAssembler.getTotalDefenseModification();
		//Assert
		Assert.assertEquals(expectedTotalDefenceModification,actualTotalDefenceModification);
	}
	
	@Test
	public void addEndurancePart() {
		//Arrange
		HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
		Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
		this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);
		Mockito.when(this.endurancePart.getHitPointsModifier()).thenReturn(Integer.MAX_VALUE);
		
		//Act
		long expectedTotalHitPointsModification = (long)Integer.MAX_VALUE+Integer.MAX_VALUE;
		long actualTotalHitPointsModification = this.vehicleAssembler.getTotalHitPointModification();
		//Assert
		Assert.assertEquals(expectedTotalHitPointsModification,actualTotalHitPointsModification);
	}
}