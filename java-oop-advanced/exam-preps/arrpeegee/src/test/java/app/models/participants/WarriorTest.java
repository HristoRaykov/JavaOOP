package app.models.participants;

import app.contracts.Targetable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class WarriorTest {
	
	private Targetable warrior;
	
	@Before
	public void setUp() throws Exception {
		this.warrior = new Warrior();
		this.warrior.setName("Warrior");
	}
	
	@Test
	public void receiveReward() {
		//Arrange
		double reward = 50;
		
		
		//Act
		double expectedResult = 50.0;
		this.warrior.receiveReward(reward);
		double actualResult = warrior.getGold();
		
		//Assert
		Assert.assertEquals(expectedResult,actualResult,0.01);
	
	}
	
	@Test
	public void levelUp() {
	
	
	}
	
	@Test
	public void takeDamage() {
	
	
	}
	
	@Test
	public void giveReward() {
	
	
	}
	
	@Test
	public void isAlive() {
	
	
	}
}