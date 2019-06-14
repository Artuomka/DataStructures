
public class AList2_v2 implements EList
{
	private int [] ar;
	private int start, end;
	
	public AList2_v2()
	{
		ar = new int [30];
		start = end = ar.length/2;
	}
	@Override
	public void clear() {
		start = end = ar.length/2;
		
	}

	@Override
	public void init(int[] ini) {
		if (ini ==null) ar = new int [0];
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
			{addStart(val); return;}
		else if (pos==size) {addEnd(val); return;}
		
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
			ar[start+pos]=val;
		}
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
		
		return ar[start++];
	}

	@Override
	public int delPos(int pos) 
	{	int size = size();
		if (size == 0||pos<0||pos>size) throw new IllegalArgumentException();
		
		
		if (pos==0) 
		{
			return delStart();
		}
		else if (pos==size)
		{
			return delEnd();
		}
		int ret = ar[pos];
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int max() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int maxPos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void halfRevers() 
	{
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
	public int get(int pos) {
		
		return 0;
	}

	@Override
	public void set(int pos, int val) {
		// TODO Auto-generated method stub
		
	}

}
