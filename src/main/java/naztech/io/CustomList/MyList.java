package naztech.io.CustomList;

public interface MyList <E>{
	boolean add(E e);
	boolean add(int index, E element);
	boolean addAll(MyList<? extends E> list);
	boolean clear();
	boolean contains(E e);
	E get(int index);
	E remove(int index);
	boolean remove(E e);
	boolean	removeAll(MyList<? extends E> eList);
	E set(int index, E element);
	int size();
	boolean	isEmpty();
	int	indexOf(Object o);
	
	
}
