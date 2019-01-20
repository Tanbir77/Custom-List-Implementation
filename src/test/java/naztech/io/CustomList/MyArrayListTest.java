package naztech.io.CustomList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyArrayListTest {

	public static MyList<String> sList;
	public static MyList<Number> nList;
	public static MyList<Integer> iList;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sList = new MyArrayList<>();
		nList = new MyArrayList<>();
		iList = new MyArrayList<>();

		sList.add("One");
		sList.add("Two");
		sList.add("Three");

		nList.add(10);
		nList.add(6.6);
		nList.add(0.56536);
		nList.add(1.5);

		iList.add(1);
		iList.add(2);
		iList.add(3);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sList.clear();
		nList.clear();
		iList.clear();
	}

	@Test
	public void addTest() {
		assertTrue(sList.add("four"));
		assertTrue(nList.add(0.12));
		assertTrue(nList.add(4, 0.12));
		assertTrue(iList.add(00));

	}

	@Test
	public void addAllTest() {
		assertTrue(nList.addAll(iList));
	}

	@Test
	public void containsTest() {
		assertFalse(sList.contains("Five"));
		assertTrue(sList.contains("Three"));
		assertTrue(nList.contains(6.6));
		assertFalse(nList.contains(6.56));
	}

	@Test
	public void getTest() {
		assertEquals("Three", sList.get(2));
		assertEquals(10, nList.get(0));
	}

	@Test
	public void removeTest() {
		assertEquals(10, nList.remove(0));
		assertTrue(nList.remove(1.5));

	}

	@Test
	public void removeAllTest() {
		nList.addAll(iList);
		assertTrue(nList.removeAll(iList));
	}

	@Test
	public void setTest() {
		MyArrayList<Number> list=new MyArrayList<>();
		list.add(1);
		list.add(2);
		assertEquals(2, list.set(1, 3));
		assertEquals("Three", sList.set(2, "Three"));

	}

	@Test
	public void sizeTest() {
		MyArrayList<Integer> list=new MyArrayList<>();
		list.add(1);
		list.add(2);
		Integer i = 2;
		assertTrue(i.equals(list.size()));
	}

	@Test
	public void isEmptyTest() {
		assertFalse(iList.isEmpty());
		iList.clear();
		assertTrue(iList.isEmpty());
	}

	@Test
	public void indexOfTest() {
		Integer index = 0;
		assertTrue(index.equals(sList.indexOf("One")));
	}
	

	@Test
	public void clearTest() {
		MyArrayList<Integer> list=new MyArrayList<>();
		list.add(1);
		list.add(2);
		assertTrue(list.clear());
	}
	
}
