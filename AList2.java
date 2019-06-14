
public class AList2 implements EList
{
	private int [] ar;
	private int start, end;
	
	public AList2()
	{
		ar = new int [30];
		start = end = ar.length/2;
	}
	@Override
	public void clear() 
		{
		start = end = ar.length/2;
		}

	@Override
	public void init(int[] ini) {
		if (ini == null) ini = new int [0];
		start = ar.length/2 - ini.length/2;
		end = start + ini.length;
		
		for (int i = 0, size = ini.length; i<size; i++)
		{
			ar[start+i] = ini[i];
		}
	}

	@Override
	public int[] toArray() 
	{
	
		int size = size();
		int [] ret = new int [size()];
		for (int i = 0; i<size; i++)
		{
			ret[i] = ar[start+i];
		}
		
		return ret;
	}

	@Override
	public int size() {
		return end-start;
	}

	@Override
	public void addStart(int val) 
	{
		ar [--start] = val;		
	}

	@Override
	public void addEnd(int val) 
	{
		ar [end++] = val;		
	}

	@Override
	public void addPos(int pos, int val) 
	{
		int size = size();
		if (pos<0||pos>size)
		{
			throw new IllegalArgumentException();
		}
		
		if (pos==0) 
			{
			addStart(val); 
			return;
			}
		else if (pos==size) 
		{
			addEnd(val); 
			return;
		}
		
		else if (pos<=size/2)
		{	--start;
			for (int i = 0; i<pos; i++)
			{
				ar[start+i] = ar[start+1+i];
			}
		}
		
		else
		{
			for (int i = 0; i< size-pos ; i++)
			{
				ar[end-i]=ar[end-1-i];
			}
			end++;
			
		}
		ar[start+pos]=val;
	}

	@Override
	public int delStart() 
	{
		if (size() == 0) throw new IllegalArgumentException();
		
		return ar[start++];
	}

	@Override
	public int delEnd() 
	{
		if (size() == 0) throw new IllegalArgumentException();
		
		return ar[--end];
	}

	@Override
	public int delPos(int pos) 
	{	int size = size();
	
		if (size == 0||pos<0||pos>size-1) throw new IllegalArgumentException();
		
		
		if (pos==0) 
		{
			return delStart();
		}
		else if (pos==size)
		{
			return delEnd();
		}
		int ret = ar[start+pos];
		int index = start +pos;
		if (pos<=size/2)
		{	--start;
			for (int i = 0; i<pos; i++)
			{
				 ar[index - i]=ar[index - i - 1];
			}
			start++;
		}
		
		else
		{
			for (int i = 0; i< size-pos-1 ; i++)
			{
				ar[start+pos+i]=ar[start+pos+1+i];
			}
			end--;			
		}

		
		return ret;
	}

	@Override
	public int min() {
		if (size() == 0) throw new IllegalArgumentException();	
		int min = ar[start];
		for (int j=start; j < end; j++)
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
	{
		if (size() == 0) throw new IllegalArgumentException();	
		int max = ar[start];
		for (int j=start; j < end; j++)
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
		if (size()==1) return 0;
		int min = 0;
		int min_index = 0;

		min = ar[start];
		for (int j=start; j < end; j++)
		{
			if (min>ar[j])
			{
				min = ar [j];
				min_index = j;
			}
		}				
		return (min_index);
	}

	@Override
	public int maxPos()
	{	if (size() == 0) throw new IllegalArgumentException();	
		if (size()==1) return 0;
	int max = 0;
	int max_index = 0;

	max = ar[start];
	for (int j=start; j < end; j++)
	{
		if (max<ar[j])
		{
			max = ar [j];
			max_index = j;
		}
	}				
	return (max_index-start);
	}

	@Override
	public void sort() 
	{ 
	if (size() == 0) throw new IllegalArgumentException();	
	int i=0;
	for (i=size()-1; i>0; i--)
	{
		for (int j=0; j<i; j++)
			if( ar[start+j] > ar[start+j+1] )
			{
				int tmp = ar[start+j];
				ar[start+j] = ar[start+j+1];
				ar[start+j+1] = tmp;
			}
	}
	}

	@Override
	public void revers() 
	{
			if (size() == 0) throw new IllegalArgumentException();	
			int arr_back[] = new int[30];
			int k=0;
			for (int i = end-1; i >= start; i--)
			{
				arr_back[start+k] = ar[i];
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
		 tmp = ar[start+i];
		 ar[start+i] = ar[start+h+i];
		 ar[start+h+i] = tmp;
	 	}
	}

	@Override
	public int get(int pos) 
	{ 
	int RealPosition = start+pos; 
	if (RealPosition <start|| RealPosition >end || size() == 0) 
		{
		throw new IllegalArgumentException();
		}
			return ar[RealPosition];
	}

	@Override
	public void set(int pos, int val) 
	{
	int RealPosition = start+pos; 
	if (RealPosition <start || RealPosition >end || size() == 0) 
		{
		throw new IllegalArgumentException();
		}
		ar[start+pos] = val;
	}
	
	@Override
	public String toString() 
	{
		if (size() == 0) throw new IllegalArgumentException();	
		String ret_string = "[";
		for (int i = 0; i<size(); i++)
		{
			if (i!=size()-1)
				ret_string = ret_string + ar[start+i]+", ";
			else
				ret_string = ret_string + ar[start+i]+ "]";	
		}
		return ret_string;

	}


}
