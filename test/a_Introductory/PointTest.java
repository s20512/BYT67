package a_Introductory;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
	Point p1, p2, p3;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Point(7, 9);
		p2 = new Point(-3, -30);
		p3 = new Point(-10, 3);
	}

    @Test
	public void testAdd() {
        int expected1 = 4;
        int expected2 = -21;
        int expected3 = -3;
        int expected4 = 12;

		Point res1 = p1.add(p2);
		Point res2 = p1.add(p3);

        int actual1 = res1.x;
        int actual2 = res1.y;
        int actual3 = res2.x;
        int actual4 = res2.y;
		
		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
	}

    @Test
	public void testSub() {
		int expected1 = 10;
		int expected2 = 39;
		int expected3 = 17;
		int expected4 = 6;

		Point res1 = p1.sub(p2);
		Point res2 = p1.sub(p3);

		int actual1 = res1.x;
		int actual2 = res1.y;
		int actual3 = res2.x;
		int actual4 = res2.y;

		assertEquals(expected1, actual1);
		assertEquals(expected2, actual2);
		assertEquals(expected3, actual3);
		assertEquals(expected4, actual4);
	}
}
