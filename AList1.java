
class AList1 implements EList
{

	private int size = 15;
	private int ar [] = new int [size];
	int index = 0;

	@Override
	public void clear() 
	{
		index = 0;		
	}

	@Override
	public void init(int[] ini) 
	{
		if (ini==null) ini = new int [0];
		index = ini.length;
		for (int i=0; i<index; i++)
		{
			ar[i] = ini [i];
		}
	}

	@Override
	public int[] toArray() 
	{
		int[] ret = new int [index];
		for (int i=0; i<index; i++)
			ret[i]=ar[i];
		return ret;
	}

	@Override
	public int size() 
	{		
		return index;
	}

	@Override
	public void addStart(int val) 
	{

		int [] tmp = new int [index+1];
		tmp [0] = val;			
		for (int i =1; i < tmp.length; i++)
		{
			tmp[i]=ar[i-1];
		}
		index++;
		ar = tmp;		
	}

	@Override
	public void addEnd(int val) 
	{
		ar[index++] = val;
	}

	@Override
	public void addPos(int pos, int val)
	{
		if (pos <0 || pos >index-1) throw new IllegalArgumentException();
		int [] tmp = new int [index+1];
		for (int i = 0; i < pos; i++)
		{				
			tmp[i]=ar[i];
		}
		tmp [pos] = val;
		index++;
		for (int i=pos+1; i<index; i++)
		{
			tmp [i] = ar[i-1];
		}

		ar = tmp;

	}

	@Override
	public int delStart() 
	{
		if (index==0) throw new IllegalArgumentException();
		int ret = ar[0];
		int [] tmp = new int [index];

		for (int i = tmp.length; i == 0; i--)
		{
			tmp[i]=ar[i+1];
		}
		ar = tmp;		

		return ret;
	}

	@Override
	public int delEnd() 
	{
		if (index==0) throw new IllegalArgumentException();
		int ret = ar[index-1];
		ar[index--] = 0;
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (index==0 || pos <0 || pos >index-1) throw new IllegalArgumentException();
		int ret = ar[pos];
		for (int i = pos; i <index-1; i++)
		{
			ar[i] = ar[i+1];
		}
		return ret;
	}


	@Override
	public int min() 
	{   if (size() == 0) throw new IllegalArgumentException();	
		int min = ar[0];
		for (int j=0; j < index; j++)
		{
			if (min>ar[j])
			{
				min = ar [j];
			}
		}				   	
		return min;
	}

	@Override
	public int max() 
	{   if (size() == 0) throw new IllegalArgumentException();	
	int max = ar[0];
	for (int j=0; j < index; j++)
	{
		if (max<ar[j])
		{
			max = ar [j];
		}
	}	   	
	return max;
	}

	@Override
	public int minPos() 
	{	
		if (size() == 0) throw new IllegalArgumentException();		
		int min = 0;
		int min_index = 0;

		min = ar[0];
		for (int j=0; j < index; j++)
		{
			if (min>ar[j])
			{
				min = ar [j];
				min_index = j;
			}
		}				
		return min_index;
	}

	@Override
	public int maxPos() 
	{	if (size() == 0) throw new IllegalArgumentException();	
	int max = 0;
	int max_index = 0;

	max = ar[0];
	for (int j=0; j < index; j++)
	{
		if (max<ar[j])
		{
			max = ar [j];
			max_index = j;
		}
	}				
	return max_index;
	}

	@Override
	public void sort() 
	{  if (size() == 0) throw new IllegalArgumentException();	
	int i=0;
	for (i=index-1; i>0; i--)
	{
		for (int j=0; j<i; j++)
			if( ar[j] > ar[j+1] )
			{
				int tmp = ar[j];
				ar[j] = ar[j+1];
				ar[j+1] = tmp;
			}
	}
	}

	@Override
	public void revers() 
	{ 
		if (size() == 0) throw new IllegalArgumentException();	
		int arr_back[] = new int[index];
		int k=0;
		for (int i = index-1; i >= 0; i--)
		{
			arr_back[k] = ar[i];
			k++;
		}					
		ar = arr_back;
	}

	@Override
	public void halfRevers() 
	{
		if (size() == 0) throw new IllegalArgumentException();	
		int tmp;

		int size = size();
		int h = size - size/2;
		if (size == 0 || size==1) return;

		for (int i = 0; i < size-h ; i++)
		{
			tmp = ar[i];
			ar[i] = ar[h+i];
			ar[h+i] = tmp;
		}

	}

	@Override
	public int get(int pos)
	{
		if (pos <0 || pos >index-1) throw new IllegalArgumentException();
		return ar[pos];
	}

	@Override
	public void set(int pos, int val) 
	{
		if (pos <0 || pos >index-1) throw new IllegalArgumentException();
		ar[pos] = val;
	}

	@Override
	public String toString() 
	{
		if (size() == 0) throw new IllegalArgumentException();	
		String ret_string = "[";
		for (int i = 0; i<index; i++)
		{
			if (i!=index-1)
				ret_string = ret_string + ar[i]+", ";
			else
				ret_string = ret_string + ar[i]+ "]";	
		}
		return ret_string;

	}

}
