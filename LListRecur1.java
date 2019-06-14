

import java.util.Arrays;





public class LListRecur1 implements EList {
	Node root = null;

	class Node
	{
		int val;
		Node next = null;
		Node prev = null;
	//конструктор
		public Node (int val)
		{
			this.val = val;
		}
	}
	
	public void clear() {
	 root = null;
		
	}

	public void init(int[] ini) {                            // actula method init
		initRec(ini, 0);
	}
	public void initRec(int[] ini, int count) {              // working method initRec (init implementation)
if (count < ini.length) {
	initRec(ini, ++count );
	addStart(ini[--count]);
}
		
		
	}
	
	
	
	
	public int[] toArray() {                          // actual method toArray
		int size = size();
		int []array= new int [size];
		return toArrayRec(root, 0, array);	
	}
	public int[] toArrayRec(Node n, int count, int arr[]) {     // working method toArrayRec (toArray implementation)
		if (n !=null) {
			toArrayRec(n.next, ++count, arr);
			arr[--count]=n.val;	
		}
		return arr;
	}
	
	
	
	
	public int size() {                                       // actual method size
		return sizeRec(root);
	}
	public int sizeRec(Node root) {                           // working method sizeRec (size implementation)
		if (root == null)
		return 0;
		else return 1 + sizeRec (root.next);
	}
	
	
	
	
	
	public void addStart(int val) {                     
		Node p = new Node(val);
	
		p.next = root;
		root = p;	
	}
	
	
	
	
	@Override
	public void addEnd(int val) {
		addEndRec (root, val);
		
	}
	
	public Node addEndRec(Node n, int val) {                   // ????????????????????????????????????
		if (n==null) return n = new Node(val);
		else { n.next = addEndRec(n.next, val);
		return n;
		}
	}
	
	
	
	
	public void addPos(Node n, int pos, int diffVal, int count) {  // TODO !!!!!!!!!!
		if (n.next != null) {
			if (count == pos)n.val = diffVal;
			addPos(n.next, pos, diffVal, ++count);
		}	
	}
	
	
	

	
	public int delStart() {
		if (root==null) throw new IllegalArgumentException();
		int ret = 0;
		ret = root.val;
		root = root.next;
		return ret;
	}

	
	public int delEnd() {
		
		Node n = root;
		return delEndRec (n).val;
		
	}
	
	public Node delEndRec(Node n) {  // TODO !!!!!!!!!!
		if (n.next == null) 
		{
			Node nn = new Node(n.val);
			root = null;
			return nn;	
		}
			if (n.next.next==null)
				{
				Node nn = new Node(n.next.val);
				n.next=null;
				return nn;				
				}
			else 
			{
				return delEndRec(n.next);		
			}
		}	

	
	public int delPos(int pos) {
		if (pos > size()-1 || pos <0) throw new IllegalArgumentException();
	
		int count = 0;
		Node n = root;
		return delPosRec ( n, pos, count).val;
		
	}
	
	public Node delPosRec(Node n, int pos, int count) {  // TODO !!!!!!!!!!
		if (pos == 0) 
		{
			Node nn = n;
			root = n.next;
			return nn;
		}
			
		 if (count == pos-1)
				{
				Node nn = new Node(n.next.val);
				n.next = n.next.next;
				return nn;				
				}
			else 
			{
				return delPosRec(n.next, pos, ++count);		
			}
		}	
	
	
	
	

	public int min(int mini) {                             // actual method mini
		return minRec(root, mini);
	}
	
	public int minRec(Node n, int mini) {                 // working method miniRec(mini implementation)
		if (n.val < mini) { mini = n.val;}
		if(n.next == null) {
			return mini;
		} else {
			return minRec(n.next, mini);
		}	
		
	}
	
	

	
	public int max() {                                   // actual method max
		// TODO Auto-generated method stub
		return 0;
	}
	public int maxRec(Node n, int max) {                 // working method miniRec(mini implementation)
		if (n.val < max) { max = n.val;}
		if(n.next == null) {
			return max;
		} else {
			return maxRec(n.next, max);
		}	
		
	}
	
	
	
	
	
	public int minPos() {                                                     //actual method minPos
		return minPosRec(root, root.val, 0,0);
	}
	
	public int minPosRec(Node n, int mini, int posCount, int miniPos ) {      // working method minPosRec (minPos implementation)
		if (n.val < mini) { mini = n.val; miniPos = posCount;}
		
		if(n.next == null) {
			return miniPos;
		} else {
			return minPosRec(n.next, mini, ++posCount, miniPos);
		}	
		
	}
	
	
	

	public int maxPos() {                                                        //actual method maxPos
		return maxPosRec(root, root.val, 0, 0 );
	}
	public int maxPosRec(Node n, int maxi, int posCount, int maxiPos ) {         // working method maxPosRec (maxPos implementation)
if (n.val > maxi) { maxi = n.val; maxiPos = posCount;}
		
		if(n.next == null) {
			return maxiPos;
		} else {
			return maxPosRec(n.next, maxi, ++posCount, maxiPos);
		}	
	}
	
	
//	@Override
//	public void sort() 
//	{
//		Node start = null;
//		sortRec (root, start);
//		root = start;			
//	}
//
//	
//	public Node sortRec (Node n, Node start) 
//
//	{
//		if  (n!=null)
//		{
//
//			Node nn = delPosRec (n, minPos(), 0);
//			nn.next = start;  
//			start = nn;
//			return sortRec (n.next, start);
//		}
//		else return start;
//	}
	
	 public void sort() {
		Node start = null;
		start = sortRec(root, start);
		root=start;
		
	}
	public Node sortRec(Node n, Node start) {
		if (n!=null) {
			Node nn = delPosRec(n, minPos(), 0);
			nn.next = start;
		 start = nn;
		return sortRec(n.next, start);
		}	
		
		else return start;
	}
		

	
	
	public void revers() {                                                       //actual method revers
		reversRec(root);
	}
	
	public void reversRec(Node n) {                                             // working method maxPosRec (maxPos implementation)
    Node e = null;
     if (n == null) {root = e; return; }
     else { reversRec (n.next);
       n.next = e;
       e = n;}
	}

	
	public void halfRevers()
	{	
		
	}
	
	

	
	
	public int get(int pos) {                           //actual method get
		return getRec(root, pos, 0);
	}                                        
	public int getRec(Node n, int pos, int count) {    // working method getRec (maxPos implementation)
		if (count == pos) return n.val;
		else return getRec (n.next, pos, ++count);
	}
	
	
	

	public void set(int pos, int diffVal) {         //if root==null || valid pos > size-1 || pos < 0 throw new...            //actual method set
		setRec(root, pos, diffVal, 0);
	}
	public void setRec(Node n, int pos, int diffVal, int count) { // working method setRec (set implementation)
		if (n != null) {
			if (count == pos)
				{
				n.val = diffVal;
				return;
				}
			setRec(n.next, pos, diffVal, ++count);
		}
	}
	
	
	
	
	
//	public String toString() {                               //actual method print
//		String result = "";
//		return printRec(root, result);
//		
//	}	
//	public String printRec(Node n, String result) {        //working method printRec (print implementation)
//		result +=n.val + " ";
//		if (n==null) {return result;
//		}
//		else {
//			
//			return result += printRec(n.next, result);
//				
//		}
//	
//		
//	}
	
	
	
	
	
		
	public static void main (String [] args) {
		LListRecur1 list = new LListRecur1();
		
		list.addStart(10);
		list.addStart(35);
		list.addStart(48);	
		list.addStart(32);
		list.addStart(12);
		list.addStart(87);
		list.addStart(97);
		list.addStart(11);
		list.addStart(6);
		list.addStart(10);
		
////		
////		//list.print(list.root);
////		//list.revers(list.root);
////		list.addEnd(list.root, 999);
////	//	System.out.println();
////		//list.print(list.root);
////		System.out.println(list.minPos(list.root, list.root.val, 0, 0));
//		
//		
list.sort();

String str = Arrays.toString(list.toArray());
System.out.println(str);
		
	}



	@Override
	public void addPos(int pos, int val) {
	 
		
	}

	@Override
	public int min() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	


}
