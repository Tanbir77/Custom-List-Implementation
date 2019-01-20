package naztech.io.CustomList;

public interface MyList <E>{
	boolean add(E e);
	void add(int index, E element);
	boolean addAll(MyList<? extends E> list);
	void clear();
	boolean contains(E e);
	E get(int index);
	E remove(int index);
	boolean remove(E e);
	boolean	removeAll(MyArrayList<?> eList);
	E set(int index, E element);
	int size();
	boolean	isEmpty();
	boolean	equals(Object o);
	int	indexOf(Object o);
	
	
}
