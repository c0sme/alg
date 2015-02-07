

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
//	
//	@Test
//	public void test_hasNeighbourgsAfter(){
//		per.open(4, 6);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh before", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_hasNeighbourgsAbove(){
//		per.open(3, 5);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh above", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_hasNeighbourgsBelow(){
//		per.open(5, 5);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh below", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_hasNeighbourgsOnTopLeft(){
//		per.open(3, 4);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh on top left", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_hasNeighbourgsOnTopRight(){
//		per.open(3, 6);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh on top right", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_hasNeighbourgsOnBottomLeft(){
//		per.open(5, 4);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh on bottom left", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_hasNeighbourgsOnBottomRight(){
//		per.open(5, 6);
//		per.open(4, 5);
//		assertTrue("node must have one neighbourgh on bottom right", per.hasNeighbourghs(4, 5));
//	}
//	
//	@Test
//	public void test_neighbourhgOutOfBoundsWithNoNeighbourgs(){
//		per.open(0, 0);
//		assertFalse("node must not have neighbourghs ", per.hasNeighbourghs(0, 0));
//	}
//	
//	@Test
//	public void test_neighbourhgOutOfBoundsWithOneNeighbourg(){
//		per.open(0, 1);
//		assertTrue("node must have one neighbourgh ", per.hasNeighbourghs(0, 0));
//	}
	
	@Test
	public void test_openNodeInSecondLineHasToBeFull(){
		per.open(0, 0);
		per.open(1, 1);
		assertTrue("node has to be full",per.isFull(1, 1));
	}
	
	@Test
	public void test_openNodeInSecondLineHasToBeNotFull(){
		per.open(1, 0);
		assertFalse("node has to be full",per.isFull(1, 0));
	}
	
	
	
	
	
	
	
	
	
	

}
