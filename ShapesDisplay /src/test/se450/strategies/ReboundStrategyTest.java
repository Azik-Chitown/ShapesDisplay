package test.se450.strategies;

import static org.junit.Assert.*;

import org.junit.Test;
import java.awt.Dimension;

import main.se450.collections.Septuplet;
import main.se450.strategies.ReboundStrategy;

public class ReboundStrategyTest {
	private Dimension dimension = new Dimension(600,700);
	ReboundStrategy frameSize= new ReboundStrategy(dimension);
	private Septuplet <Float, Float, Float, Float, Float, Float, Integer> result;
	@Test
	public void executeTest () {
		result=(Septuplet<Float, Float, Float, Float, Float, Float, Integer>) frameSize.execute(-10.0f, 25.0f, 100.0f, 100.0f, -3.0f, 5.0f, -65536);
		
		assertTrue(result.getT1()==0.0);
		assertTrue(result.getT2()==25.0);
		assertTrue(result.getT3()==110.0);
		assertTrue(result.getT4()==100.0);
		assertTrue(result.getT5()==3.0);
		assertTrue(result.getT6()==5.0);
		assertTrue(result.getT7()==-65536);
	}

}
