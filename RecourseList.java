

public class RecourseList 
{
	Node root = null;
	Node end = null;
	
	class Node
	{
		int val;
		Node next = null;
		Node prev = null;
	//�����������
		public Node (int val)
		{
			this.val = val;
		}
	}
	public static void main(String[] args) 
	{
		
		
		
	}
	
	public static void SetPos(Node n, int pos, int diffval, int count) 
	{
		if (n!=null)
		{
			if (count == pos) n.val = diffval;
			SetPos (n.next, pos, diffval, ++count);
		}
		
	}
	
	
	
	public static void init(int [] ini, int count) 
	{
		if (count < ini.length)
		{
			init(ini, ++count);
	//		addStart(ini [--count]);
		}
		
	}
	
	public static int	RecurseMin (Node n, int mini)
	{
	if (n.val <mini) {mini=n.val;}
	if (n.next==null) return mini;
	else {
		return RecurseMin (n.next, mini);
	}		
	}
	
	public static int	RecurseMax (Node n, int max)
	{
	if (n.val < max) {max=n.val;}
	if (n.next==null) return max;
	else {
		return RecurseMin (n.next, max);
	}		
	}
	
	public static int	RecurseMinPos (Node n, int mini, int miniPos, int posCount)
	{
	
	if (n.val < mini) {mini=n.val; miniPos = posCount;}
	if (n.next==null) return miniPos;
	else {
		return RecurseMinPos (n.next, mini, miniPos, ++posCount);
	}		
	}
	
	public static int	RecurseMaxPos (Node n, int max, int maxPos, int posCount)
	{
	
	if (n.val > max) {max=n.val; maxPos = posCount;}
	if (n.next==null) return maxPos;
	else {
		return RecurseMinPos (n.next, max, maxPos, ++posCount);
	}		
	}

	public static int [] toArray (Node n, int count, int arr[])
	{		
		if (n!=null) 
		{
			toArray (n.next, ++count, arr);
			arr [--count] = n.val;
		}
		return arr;		
		}		
	}
	
	

