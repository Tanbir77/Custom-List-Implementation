package naztech.io.CustomList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
	}

	private void ensureSize() {
		if (size == elements.length) {
			ensureCapacity(elements.length * 2);
		}
	}

	@Override
	public boolean add(E e) {
		ensureSize();
		elements[size++] = e;
		return true;
	}

	@Override
	public boolean add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if (index < size) {
			Object o = elements[index];
			elements[index] = element;
			ensureSize();
			elements[size++] = o;
		} else {
			elements[index] = element;
		}
		return true;

	}

	@Override
	public boolean addAll(MyList<? extends E> list) {
		if (list == null)
			throw new NullPointerException();
		MyArrayList<? extends E> eList = (MyArrayList<? extends E>) list;
		if ((this.size + eList.size()) > elements.length) {
			ensureCapacity(size + eList.size());
		}

		for (int i = 0; i < eList.size(); i++) {

			this.elements[size++] = eList.elements[i];
		}

		return true;
	}

	@Override
	public boolean clear() {
		this.size = 0;
		elements = new Object[DEFAULT_CAPACITY];
		return true;
	}

	@Override
	public boolean contains(E e) {

		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e))
				return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		return (E) elements[index];
	}

	@Override
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Object ob = elements[index];
		elements[index] = elements[--size];

		return (E) ob;
	}

	@Override
	public boolean remove(E e) {
		int index;
		try {
			index = indexOf(e);
		} catch (IllegalArgumentException ie) {
			throw ie;
		}
		elements[index] = elements[--size];
		return true;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean removeAll(MyList<? extends E> list) {
		if(list==null) throw new NullPointerException();
		MyArrayList <? extends E>eList=(MyArrayList<? extends E>) list;
		for (int i = 0; i < eList.size(); i++) {
			this.remove((E) eList.elements[i]);
		}
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E set(int index, E element) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		E previousElement = (E) elements[index];
		elements[index] = element;
		return previousElement;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public int indexOf(Object o) {
		int index;
		for (index = 0; index < size; index++) {
			if (elements[index].equals(o))
				return index;
		}
		throw new IllegalArgumentException();
	}

	void ensureCapacity(int minCapacity) {
		elements = Arrays.copyOf(elements, minCapacity);
	}

}
