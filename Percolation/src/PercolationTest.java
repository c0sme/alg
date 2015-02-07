

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PercolationTest {

	Percolation per;
	
	@Before
	public void setUp(){
		 per = new Percolation(10);
	}
	
	@Test
	public void testGetIndexInArray(){
		assertTrue(per.getIndexInArray(0, 0) == 0);
		assertTrue(per.getIndexInArray(1,0) == 10);
		assertTrue(per.getIndexInArray(1, 2) == 12);
		assertTrue(String.format("result: %d",per.getIndexInArray(2,5)),per.getIndexInArray(2,5) == 25);
		assertTrue(String.format("result: %d",per.getIndexInArray(9,9)),per.getIndexInArray(9,9) == 99);
		
	}
	
	@Test(expected=AssertionError.class)
	public void testIndexOutOfBoundsOnGrid(){
		assertTrue(String.format("result: %d",per.getIndexInArray(12,15)),per.getIndexInArray(12,15) == 14);
	}
	
	@Test
	public void testIsOpen(){
		per.open(1, 1);
		assertTrue(per.isOpen(1, 1));
		assertFalse(per.isOpen(9, 9));
	}
	
	@Test
	public void nodeOpenedInFirstRow_hasToBeFull(){
		per.open(0, 1);
		assertTrue("node on first row should be full", per.isFull(0, 1));
	}
	
	@Test
	public void nodeNotOpenedInFirstRow_NoFull(){
		assertFalse("node on first row should be full", per.isFull(0, 1));
	}
	
	@Test
	public void whenTopElementIsFull_OpenedElementHasToBeFull(){
		per.open(0, 0);
		per.open(1, 0);
		assertTrue("node must have one neighbourgh before", per.isFull(1, 0));
	}

	
	@Test
	public void test_openNodeInSecondLineHasToBeFull(){
		per.open(0, 0);
		per.open(1, 0);
		assertTrue("node has to be full",per.isFull(1, 0));
	}
	
	@Test
	public void test_openNodeInSecondLineHasToBeNotFull(){
		per.open(0, 0);
		assertFalse("node has to be full",per.isFull(1, 0));
	}
	
	@Test
	public void test_systemPercolates(){
		per.open(0, 0);
		per.open(1, 0);
		per.open(2, 0);
		per.open(3, 0);
		per.open(4, 0);
		per.open(5, 0);
		
		per.open(6, 0);
		per.open(7, 0);
		per.open(8, 0);
		per.open(9, 0);
		
		assertTrue("system shoul percolate", per.percolates());
		
	}
	
	
	
	
	
	
	
	
	
	

}
