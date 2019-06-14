
public interface EList 
{
	void  clear();
	void  init(int[] ini);
	int[] toArray();
	int   size();

	void  addStart(int val);
	void  addEnd(int val);
	void  addPos(int pos, int val);
	int   delStart();
	int   delEnd();
	int   delPos(int pos);

	int   min();
	int   max();
	int   minPos();
	int   maxPos();

	void  sort();
	void  revers();
	void  halfRevers();

	int   get(int pos);
	void  set(int pos, int val);

	String toString();
}
