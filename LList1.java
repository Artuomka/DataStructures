
public class LList1 implements EList
{

	Node root = null;
	class Node
	{
		int val;
		Node next = null;	
		public Node (int val)
		{
			this.val = val;
		}
	}	
	public void addStart (int val)
	{
		Node p = new Node (val);
		p.next = root;
		root = p;
	}
	
	public void init(int[] ini)
	{
		if (ini==null) ini = new int [0];
		clear();
		for (int i = 0; i<ini.length; i++)
		{
		addStart (ini[ini.length-1-i]);	
		}
		
	}
	
	public void clear()
	{
		root = null;
	}
	
	public int size()
	{
		int count = 0;
		Node tmp = root;
		while (tmp!=null)
		{
			tmp = tmp.next;
			count++;
		}
		return count;
	}

	@Override
	public int[] toArray()
	{
		int [] ar = new int [size()];
		int count = 0;
		Node tmp = root;
		while (tmp != null)
		{
			ar[count] =  tmp.val;
			count++;
			tmp = tmp.next;
		}

		return ar;
	}

	@Override
	public void addEnd(int val) 
	{		
		if (root==null) addStart(val);
		else
		{
			Node tmp = root;
			while (tmp.next!=null)
			{
				tmp = tmp.next;	
			}
			tmp.next = new Node (val);
		}
	}

	@Override
	public void addPos(int pos, int val) 
	{	
		int size = size();
		if (pos<0||pos>size) throw new IllegalArgumentException();
		if (root==null || size==1 || pos==0) addStart(val);
		else
		{
			Node tmp = root;
			for (int i = 0; i<pos-1; i++)
			{
				tmp = tmp.next;			
			}
			Node p = new Node (val);
			p.next = tmp.next;
			tmp.next = p; //����� ����� ����
		}
	}

	@Override
	public int delStart() 
	{		
		if (root==null) throw new IllegalArgumentException();
		int ret = 0;
		ret = root.val;
		root = root.next;
		return ret;
	}

	@Override
	public int delEnd() 
	{
		if (root==null) throw new IllegalArgumentException();
		Node tmp = root;
		int size = size();
		for (int i = 0; i<size-2; i++)
		{
			tmp = tmp.next;	
		}
		Node p = new Node (tmp.val);
		
		int ret = tmp.next.val;
		tmp.next = null;
		tmp = p;		
		return ret;
	}

	@Override
	public int delPos(int pos)
	{
		int size = size();
		if (pos<0||pos>size||root==null) throw new IllegalArgumentException();
		Node tmp = root;
		for (int i = 0; i<pos-1; i++)
		{
			tmp = tmp.next;			
		}
		
	Node p = new Node (tmp.val);
		
		int ret = tmp.next.val;
		tmp.next = tmp.next.next;
		tmp = p;
		return ret;
	}

	@Override
	public int min() 
	{	
		if (root==null) throw new IllegalArgumentException();
		Node tmp = root;
		int ret=tmp.val;
		while (tmp.next != null)
		{	
			if (ret>tmp.next.val) ret = tmp.next.val;
			tmp = tmp.next;			
		}	
	
		return ret;		
	}

	@Override
	public int max() 
	{	
		if (root==null) throw new IllegalArgumentException();
		Node tmp = root;
		int ret=tmp.val;
		while (tmp.next != null)
		{	
			if (ret<tmp.next.val) ret = tmp.next.val;
			tmp = tmp.next;			
		}	
	
		return ret;		
	}

	@Override
	public int minPos() 
	{
		if (root==null) throw new IllegalArgumentException();
		Node tmp = root;
		int ret=tmp.val;
		int min_index = 0;
		int count = 0;
		while (tmp.next != null)
		{	
			if (ret>tmp.next.val) min_index = count;
			tmp = tmp.next;	
			count++;
		}	
	
		return min_index-1;
	}

	@Override
	public int maxPos() 
	{
		if (root==null) throw new IllegalArgumentException();
		Node tmp = root;
		int ret=tmp.val;
		int max_index = 0;
		int count = 0;
		while (tmp.next != null)
		{	
			if (ret<tmp.next.val) max_index = count;
			tmp = tmp.next;	
			count++;
		}	
	
		return max_index-1;
	}

/*	@Override
	public void sort() 
	{
		Node tmpRoot = null;
		Node tmp, max;
		Node prev;
		
		while (root!=null)
		{
			tmp = root;
			prev = root;
			max = root;
			while (tmp.next!=null)
			{
				if (tmp.next.val > max.val)
				{
					prev = tmp;
					max = tmp.next;
				}
			tmp=tmp.next;
			}
			if (max == root)
			{
				root = root.next;
			}
			else
			{
				prev.next = max.next;
			}
			max.next = tmpRoot;
			tmpRoot = max;
		}
		root = tmpRoot;
	} 													
		*/
	
	@Override
	public void sort ()
	{
		Node max, prev;
		Node tmpRoot = null;
		Node tmp = null;
		
		while (root!=null)
		{
			
			max = root;
			prev = root;
			while (tmp!=null)
			{
				if(tmp.next.val>max.val)
				{
					max = tmp.next;
					prev = tmp;
				}
				tmp = tmp.next;
			}
			
			if (root==max)
			{
				root = max.next;
			}
			else
			{
				prev.next = max.next;
			}
			max.next = tmpRoot;
			tmpRoot = max;
		}
		root = tmpRoot;
	}
	
	
	
	@Override
	public void revers() 
	{
		Node tmp = root;
		LList1 lst = new LList1();
		while (tmp!= null)
		{
			lst.addStart(tmp.val);
			tmp = tmp.next;
		}
		root = lst.root;
	}

	@Override
	public void halfRevers() 
	{
		if (root==null || root.next==null) return;
		
		int size = size();
		int k = size/2-1;
		
		Node end = root;
		Node half = root;
	
		while (end.next != null)
		{
			if (k == 0) 
			{
				half = end;
				k--;
				end = end.next;
				
			}

			end.next = half.next;
			root = half.next;
			half = null;
			
		}
	}

	@Override
	public int get(int pos) 
	{		
		int size = size();
		if (pos<0||pos>size||root==null) throw new IllegalArgumentException();
		Node tmp = root;
		for (int i = 0; i<pos-1; i++)
		{
			tmp = tmp.next;			
		}	
		int ret = tmp.next.val;
		return ret;		
	}

	@Override
	public void set(int pos, int val) 
	{
		int size = size();
		if (pos<0||pos>size||root==null) throw new IllegalArgumentException();
		Node tmp = root;
		for (int i = 0; i<pos-1; i++)
		{
			tmp = tmp.next;			
		}	
		tmp.next.val = val;				
	}
	
	@Override
	public String toString() 
	{
		int size = size();
		if (size == 0) throw new IllegalArgumentException();	
		String ret_string = "[";
		Node tmp = root;
		int i=0;
		while (tmp != null)
		{			
			if (i!=size-1)
				ret_string = ret_string + tmp.val+", ";
			else
				ret_string = ret_string + tmp.val+ "]";	
		tmp = tmp.next;
		i++;
		}
		return ret_string;

	}
}
