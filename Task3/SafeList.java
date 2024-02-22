package Task3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Semaphore;

public class SafeList<T> implements List<T> {
    private final List<T> list;
    private final Semaphore semaphore;

    public SafeList() {
        this.list = new ArrayList<>();
        this.semaphore = new Semaphore(1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return list.listIterator();
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public T remove(int index) {
        try {
            semaphore.acquire();
            return list.remove(index);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void add(int index, T object) {
        try {
            semaphore.acquire();
            list.add(index, object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public int lastIndexOf(Object object) {
        return list.lastIndexOf(object);
    }

    @Override
    public boolean remove(Object object) {
        try {
            semaphore.acquire();
            return list.remove(object);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            return list.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return new Object[0];
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.containsAll(c);

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public List<T> subList(int from, int to) {
        try {
            semaphore.acquire();
            return list.subList(from, to);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            semaphore.acquire();
            return list.addAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        try {
            semaphore.acquire();
            return list.addAll(index, c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    @SuppressWarnings("hiding")
    public<T> T[] toArray(T[] a) {
        try {
            semaphore.acquire();
            return list.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean add(T t) {
        try {
            semaphore.acquire();
            boolean added = list.add(t);
            return added;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public T set(int index, T element) {
        try {
            semaphore.acquire();
            return list.set(index, element);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.removeAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            semaphore.release();
        }
    }
}
