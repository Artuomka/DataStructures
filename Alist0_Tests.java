import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class Alist0_Tests {
		
//*************************************\ TEST MANY /***************************************
	
	
	Alist0 lst = new Alist0();

	@After
	public void cleanArray()
	{
		lst.clear();
	}

	@Test
	public void initialisation_test ()
	{
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int [] expected = {1, 10, 34, 5, 78, 94, 36, 42};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);

	}



	@Test
	public void test_clear() 
	{
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);
		lst.clear();
		int [] expected = new int [0];
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}


	@Test
	public void test_toArray() 
	{
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int [] expected = {1, 10, 34, 5, 78, 94, 36, 42};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_size() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 8;
		int actual = lst.size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_addStart() 
	{
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		lst.addStart(7);
		int [] expected = {7, 1, 10, 34, 5, 78, 94, 36, 42};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_addEnd() 
	{
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		lst.addEnd(7);
		int [] expected = {1, 10, 34, 5, 78, 94, 36, 42, 7};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Addpos() 
	{
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		lst.addPos(2, 7);
		int [] expected =  {1, 10, 7, 34, 5, 78, 94, 36, 42};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_DelStart() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 1;
		int actual = lst.delStart();
		Assert.assertEquals(expected, actual);
	}
// допилить сравнение массивов в тесты меняющие структуру
	@Test
	public void test_DelEnd() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 42;
		int actual = lst.delEnd();
		Assert.assertEquals(expected, actual);
		int [] expected_ar =  {1, 10, 34, 5, 78, 94, 36};
		int [] actual_ar = lst.toArray();
		Assert.assertArrayEquals(expected_ar, actual_ar);
	}

	@Test
	public void test_DelPos() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 34;
		int actual = lst.delPos(2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_min() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 1;
		int actual = lst.min();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_max() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 94;
		int actual = lst.max();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_maxPos() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 5;
		int actual = lst.maxPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_minPos() 
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected = 0;
		int actual = lst.minPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_sort() // {1, 10, 34, 5, 78, 94, 36, 42};
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		lst.sort();
		int [] expected =  {1, 5, 10, 34, 36, 42, 78, 94};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_revers() // {1, 10, 34, 5, 78, 94, 36, 42};
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		lst.revers();
		int [] expected =  {42, 36, 94, 78, 5, 34, 10, 1};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Halfrevers() // {1, 10, 34, 5, 78, 94, 36, 42};
	{	
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		lst.halfRevers();
		int [] expected =  {78, 94, 36, 42, 1, 10, 34, 5};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_get() // 
	{			
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int expected =  94;
		int actual = lst.get(5);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test_set() // 
	{			
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		int [] expected =  {1, 10, 7, 5, 78, 94, 36, 42};
		lst.set(2, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_toString() // 
	{			
		int [] ini = {1, 10, 34, 5, 78, 94, 36, 42};
		lst.init(ini);

		String expected =  "[1, 10, 34, 5, 78, 94, 36, 42]";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}

//*************************************\ TEST TWO /***************************************	


	@Test
	public void initialisation_test_two ()
	{
		int [] ini = {1, 10};
		lst.init(ini);

		int [] expected = {1, 10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);

	}

	@Test
	public void test_clear_two() 
	{
		int [] ini = {1, 10};
		lst.init(ini);
		lst.clear();
		int [] expected = new int [0];
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_toArray_two() 
	{
		int [] ini = {1, 10};
		lst.init(ini);

		int [] expected = {1, 10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_size_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 2;
		int actual = lst.size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_addStart_two() 
	{
		int [] ini = {1, 10};
		lst.init(ini);

		lst.addStart(7);
		int [] expected = {7, 1, 10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_addEnd_two() 
	{
		int [] ini = {1, 10};
		lst.init(ini);

		lst.addEnd(7);
		int [] expected = {1, 10, 7};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Addpos_two() 
	{
		int [] ini = {1, 10};
		lst.init(ini);

		lst.addPos(1, 7);
		int [] expected =  {1, 7, 10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_DelStart_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 1;
		int actual = lst.delStart();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_DelEnd_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 10;
		int actual = lst.delEnd();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_DelPos_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 10;
		int actual = lst.delPos(1);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_min_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 1;
		int actual = lst.min();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_max_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 10;
		int actual = lst.max();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_maxPos_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 1;
		int actual = lst.maxPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_minPos_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		int expected = 0;
		int actual = lst.minPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_sort_two() //
	{	
		int [] ini = {10, 1};
		lst.init(ini);

		lst.sort();
		int [] expected =  {1, 10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_revers_two() 
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		lst.revers();
		int [] expected =  {10, 1};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Halfrevers_two()
	{	
		int [] ini = {1, 10};
		lst.init(ini);

		lst.halfRevers();
		int [] expected =  {10, 1};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_get_two() // 
	{			
		int [] ini = {1, 10};
		lst.init(ini);

		int expected =  1;
		int actual = lst.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_set_two() // 
	{			
		int [] ini = {1, 10};
		lst.init(ini);

		int [] expected =  {1, 7};
		lst.set(1, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_toString_two() // 
	{			
		int [] ini = {1, 10};
		lst.init(ini);

		String expected =  "[1, 10]";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}

//*************************************\ TEST ONE /***************************************

	@Test
	public void initialisation_test_one ()
	{
		int [] ini = {1};
		lst.init(ini);

		int [] expected = {1};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);

	}

	@Test
	public void test_clear_one() 
	{
		int [] ini = {1};
		lst.init(ini);
		lst.clear();
		int [] expected = new int [0];
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_toArray_one() 
	{
		int [] ini = {1, 10};
		lst.init(ini);

		int [] expected = {1, 10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_size_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 1;
		int actual = lst.size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_addStart_one() 
	{
		int [] ini = {1};
		lst.init(ini);

		lst.addStart(7);
		int [] expected = {7, 1};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_addEnd_one() 
	{
		int [] ini = {1};
		lst.init(ini);

		lst.addEnd(7);
		int [] expected = {1, 7};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Addpos_one() 
	{
		int [] ini = {1};
		lst.init(ini);

		lst.addPos(0, 7);
		int [] expected =  {7, 1};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_DelStart_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 1;
		int actual = lst.delStart();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_DelEnd_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 1;
		int actual = lst.delEnd();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_DelPos_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 1;
		int actual = lst.delPos(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_min_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 1;
		int actual = lst.min();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_max_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 1;
		int actual = lst.max();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_maxPos_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 0;
		int actual = lst.maxPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_minPos_one() 
	{	
		int [] ini = {1};
		lst.init(ini);

		int expected = 0;
		int actual = lst.minPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_sort_one() //
	{	
		int [] ini = {10};
		lst.init(ini);

		lst.sort();
		int [] expected =  {10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_revers_one() 
	{	
		int [] ini = {10};
		lst.init(ini);

		lst.revers();
		int [] expected =  {10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Halfrevers_one()
	{	
		int [] ini = {10};
		lst.init(ini);

		lst.halfRevers();
		int [] expected =  {10};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_get_one() // 
	{			
		int [] ini = {1};
		lst.init(ini);

		int expected =  1;
		int actual = lst.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_set_one() // 
	{			
		int [] ini = {10};
		lst.init(ini);

		int [] expected =  {7};
		lst.set(0, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	
	@Test
	public void test_toString_one() // 
	{			
		int [] ini = {1};
		lst.init(ini);

		String expected =  "[1]";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}
	
//*************************************\ TEST ZERO /***************************************
	
	@Test
	public void initialisation_test_zero ()
	{
		int [] ini = {0};
		lst.init(ini);

		int [] expected = {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);

	}

	@Test
	public void test_clear_zero() 
	{
		int [] ini = {0};
		lst.init(ini);
		lst.clear();
		int [] expected = new int [0];
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_toArray_zero() 
	{
		int [] ini = {0};
		lst.init(ini);

		int [] expected = {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_size_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 1;
		int actual = lst.size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_addStart_zero() 
	{
		int [] ini = {0};
		lst.init(ini);

		lst.addStart(7);
		int [] expected = {7, 0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_addEnd_zero() 
	{
		int [] ini = {0};
		lst.init(ini);

		lst.addEnd(7);
		int [] expected = {0, 7};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Addpos_zero() 
	{
		int [] ini = {0};
		lst.init(ini);

		lst.addPos(0, 7);
		int [] expected =  {7, 0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_DelStart_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.delStart();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_DelEnd_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.delEnd();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_DelPos_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.delPos(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_min_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.min();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_max_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.max();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_maxPos_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.maxPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_minPos_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		int expected = 0;
		int actual = lst.minPos();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_sort_zero() //
	{	
		int [] ini = {0};
		lst.init(ini);

		lst.sort();
		int [] expected =  {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_revers_zero() 
	{	
		int [] ini = {0};
		lst.init(ini);

		lst.revers();
		int [] expected =  {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_Halfrevers_zero()
	{	
		int [] ini = {0};
		lst.init(ini);

		lst.halfRevers();
		int [] expected =  {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_get_zero() // 
	{			
		int [] ini = {0};
		lst.init(ini);

		int expected =  0;
		int actual = lst.get(0);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_set_zero() // 
	{			
		int [] ini = {0};
		lst.init(ini);

		int [] expected =  {7};
		lst.set(0, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_toString_zero() // 
	{			
		int [] ini = {0};
		lst.init(ini);

		String expected =  "[0]";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}
	
//*************************************\ TEST NULL /***************************************	
	
	@Test
	public void initialisation_test_null ()
	{
		int [] ini = null;
		lst.init(ini);

		int [] expected = {};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);

	}

	@Test
	public void test_clear_null() 
	{
		int [] ini = null;
		lst.init(ini);
		lst.clear();
		int [] expected = new int [0];
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_toArray_null() 
	{
		int [] ini = null;
		lst.init(ini);

		int [] expected = {};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_size_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void test_addStart_null() 
	{
		int [] ini = null;
		lst.init(ini);

		lst.addStart(7);
		int [] expected = {7};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test_addEnd_null() 
	{
		int [] ini = null;
		lst.init(ini);

		lst.addEnd(7);
		int [] expected = {7};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class) // усовершенствовать метод добавления в позицию
	public void test_Addpos_null() 
	{
		int [] ini = null;
		lst.init(ini);

		lst.addPos(0, 7);
	/*	int [] expected =  {7, 0};                            переделать остальное
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);*/
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_DelStart_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.delStart();
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_DelEnd_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.delEnd();
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_DelPos_null() 
	{			
		int [] ini = null;
		lst.init(ini);
		int expected = 0;
		int actual = lst.delPos(0);
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_min_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.min();
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_max_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.max();
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_maxPos_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.maxPos();
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_minPos_null() 
	{	
		int [] ini = null;
		lst.init(ini);

		int expected = 0;
		int actual = lst.minPos();
		Assert.assertEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_sort_null() //
	{	
		int [] ini = null;
		lst.init(ini);

		lst.sort();
		int [] expected =  {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_revers_null() 
	{	
		int [] ini = null;
		lst.init(ini);
		lst.revers();
		int [] expected =  {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_Halfrevers_null()
	{	
		int [] ini = null;
		lst.init(ini);

		lst.halfRevers();
		int [] expected =  {0};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_get_null() // 
	{			
		int [] ini = null;
		lst.init(ini);

		int expected =  0;
		int actual = lst.get(0);
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_set_null() // 
	{			
		int [] ini = null;
		lst.init(ini);

		int [] expected =  {7};
		lst.set(0, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_toString_null() // 
	{			
		int [] ini = null;
		lst.init(ini);

		String expected =  "[]";
		String actual = lst.toString();
		Assert.assertEquals(expected, actual);
	}

//*************************************\ TEST ON BORDERS /***************************************	

	@Test
	public void test_Addpos_onBorder_start() 
	{
		int [] ini = {1, 10, 27, 45};
		lst.init(ini);

		lst.addPos(0, 7);
		int [] expected =  {7, 1, 10, 27, 45};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_Addpos_onBorder_end() 
	{
		int [] ini = {1, 10, 27, 45};
		lst.init(ini);

		lst.addPos(3, 7);
		int [] expected =  {1, 10, 27, 7, 45};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_DelPos_start() 
	{	
		int [] ini = {10, 27, 45};
		lst.init(ini);

		int expected = 10;
		int actual = lst.delPos(0);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test_DelPos_end() 
	{	
		int [] ini = {10, 27, 45};
		lst.init(ini);

		int expected = 45;
		int actual = lst.delPos(2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test_get_start() // 
	{			
		int [] ini = {42, 1, 10};
		lst.init(ini);

		int expected =  42;
		int actual = lst.get(0);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test_get_end() // 
	{			
		int [] ini = {42, 1, 10};
		lst.init(ini);

		int expected =  10;
		int actual = lst.get(2);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test_set_start() // 
	{			
		int [] ini = {1, 10, 41, 47};
		lst.init(ini);

		int [] expected =  {7, 10, 41, 47};
		lst.set(0, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test_set_end() // 
	{			
		int [] ini = {1, 10, 41, 47};
		lst.init(ini);

		int [] expected =  {1, 10, 41, 7};
		lst.set(3, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}

//*************************************\ TEST OUT OF BORDERS /***************************************	

	@Test (expected = IllegalArgumentException.class)
	public void test_Addpos_outOfBorder_Left() 
	{
		int [] ini = {1, 10, 27, 45};
		lst.init(ini);

		lst.addPos(-1, 7);
		int [] expected =  {7, 1, 10, 27, 45};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Addpos_outOfBorder_Rigth() 
	{
		int [] ini = {1, 10, 27, 45};
		lst.init(ini);

		lst.addPos(5, 7);
		int [] expected =  {7, 1, 10, 27, 45};
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_DelPos_outOfBorder_Right() 
	{	
		int [] ini = {10, 27, 45};
		lst.init(ini);

		int expected = 10;
		int actual = lst.delPos(-1);
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_DelPos_outOfBorder_Left() 
	{	
		int [] ini = {10, 27, 45};
		lst.init(ini);

		int expected = 10;
		int actual = lst.delPos(3);
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_set_outOfBorder_Left() // 
	{			
		int [] ini = {1, 10, 41, 47};
		lst.init(ini);

		int [] expected =  {7, 10, 41, 47};
		lst.set(-1, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_set_outOfBorder_Rigth() // 
	{			
		int [] ini = {1, 10, 41, 47};
		lst.init(ini);

		int [] expected =  {7, 10, 41, 47};
		lst.set(4, 7);
		int [] actual = lst.toArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
