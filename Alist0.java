import java.util.Iterator;

class Alist0 implements EList
{
private	int ar [];

	@Override
	public void clear() 
	{
		ar = new int [0];
	}

	@Override
	public void init(int[] ini) 
	{
	if (ini==null) ini = new int [0];
	
		ar = new int [ini.length];
		for (int i=0; i<ar.length; i++)
		{
			ar[i] = ini [i];
		}
	}

	@Override
	public int[] toArray()
	{
		
		int[] ret = new int [ar.length];
		for (int i=0; i<ar.length; i++)
			ret[i]=ar[i];
		return ret;
	}

	@Override
	public int size() 
	{
		return ar.length;
	}

	@Override
	public void addStart(int val) 
	{
		
		int [] tmp = new int [ar.length+1];
		tmp [0] = val;
		
			for (int i =1; i < tmp.length; i++)
			{
				tmp[i]=ar[i-1];
			}
			ar = tmp;		
	}

	@Override
	public void addEnd(int val)
	{
		
		int [] tmp = new int [ar.length+1];
			for (int i =0; i < ar.length; i++)
			{
				tmp[i]=ar[i];
			}
			tmp [tmp.length-1] = val;
			ar = tmp;		
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if (size() == 0||pos<0||pos>size()) throw new IllegalArgumentException();
		
		int [] tmp = new int [ar.length+1];
			for (int i = 0; i < pos; i++)
			{				
				tmp[i]=ar[i];
			}
			tmp [pos] = val;
			
			for (int i=pos+1; i<=ar.length; i++)
			{
				tmp [i] = ar[i-1];
			}
			
			ar = tmp;		
	}

	@Override
	public int delStart() 
	{
		if (ar.length==0) throw new IllegalArgumentException();
		if (ar.length==1) 
			{
			int ret = ar[0];
			ar = new int [0];
			return ret;
			}
		int ret = ar[0];
		int [] tmp = new int [ar.length-1];
		
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
		if (ar.length==0) throw new IllegalArgumentException();
		int ret = ar[ar.length-1];
		int [] tmp = new int [ar.length-1];
		
			for (int i = 0; i < tmp.length; i++)
			{
				tmp[i]=ar[i];
			}
			ar = tmp;		
		
	return ret;
	}

	@Override
	public int delPos(int pos)
	{
		if (size() == 0||pos<0||pos>size()-1) throw new IllegalArgumentException();
		 int ret = ar[pos];
		 for (int i = pos; i <ar.length-1; i++)
		 {
			 ar[i] = ar[i+1];
		 }
		 return ret;
	}

	@Override
	public int min()
	{
		if (size() == 0) throw new IllegalArgumentException();
		int min = ar[0];
		for (int j=0; j < ar.length; j++)
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
		int max = ar[0];
		for (int j=0; j < ar.length; j++)
		{
			if (max<ar[j])
			{
				max = ar [j];
			}
		}	   	
		return max;
	}

	@Override
	public int maxPos() 
	{		
		if (size() == 0) throw new IllegalArgumentException();
		int max = 0;
		int max_index = 0;

		max = ar[0];
		for (int j=0; j < ar.length; j++)
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
	public int minPos() 
	{		
		if (size() == 0) throw new IllegalArgumentException();		
		int min = 0;
		int min_index = 0;

		min = ar[0];
		for (int j=0; j < ar.length; j++)
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
	public void sort() 
	{
		if (size() == 0) throw new IllegalArgumentException();	
		int i=0;
		for (i=ar.length-1; i>0; i--)
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
		int arr_back[] = new int[ar.length];
		int k=0;
		for (int i = ar.length-1; i >= 0; i--)
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
		if (size() == 0||pos<0||pos>size()-1) throw new IllegalArgumentException();
		return ar[pos];
	}

	@Override
	public void set(int pos, int val) 
	{
		if (size() == 0||pos<0||pos>size()-1) throw new IllegalArgumentException();
		ar[pos] = val;
	}

	@Override
	public String toString()
	
	{
		if (size() == 0) throw new IllegalArgumentException();
		String ret_string = "[";
		for (int i = 0; i<ar.length; i++)
		{
			if (i!=ar.length-1)
			ret_string = ret_string + ar[i]+", ";
			else
			ret_string = ret_string + ar[i]+ "]";	
		}
		return ret_string;
		
	}
	
	
	public Iterator<Integer> iterator(){
		return new MyIter(ar);
		
	}
	class MyIter implements Iterator<Integer>{

		int i=0;
		int size;
		int [] ar = null;
		
		MyIter(int[]ar){
			this.ar = ar;
			size = ar.length;
		}
		@Override
		public boolean hasNext() {
			
			return false;
		}

		@Override
		public Integer next() {
		
			return null;
		}
		
	}
}
