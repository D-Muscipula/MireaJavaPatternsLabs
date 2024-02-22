package org.example.Labs.task3;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockList<E> implements List<E> {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final List<E> list;

    public LockList(List<E> list) {
        this.list = list;
    }

    @Override
    public int size() {
        readWriteLock.readLock().lock();
        try {
            return list.size();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        readWriteLock.readLock().lock();
        try {
            return list.isEmpty();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public boolean contains(Object o) {
        readWriteLock.readLock().lock();
        try {
            return list.contains(o);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public Iterator<E> iterator() {

        readWriteLock.readLock().lock();
        try {
            return list.iterator();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public Object[] toArray() {

        readWriteLock.readLock().lock();
        try {
            return list.toArray();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public <T> T[] toArray(T[] a) {

        readWriteLock.readLock().lock();
        try {
            return list.toArray(a);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public boolean add(E e) {
        readWriteLock.writeLock().lock();
        try {
            return list.add(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public boolean remove(Object o) {
        readWriteLock.writeLock().lock();
        try {
            return list.remove(o);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        readWriteLock.readLock().lock();
        try {
            return list.containsAll(c);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        readWriteLock.writeLock().lock();
        try {
            return list.addAll(c);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        readWriteLock.writeLock().lock();
        try {
            return list.addAll(index, c);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public boolean removeAll(Collection<?> c) {

        readWriteLock.writeLock().lock();
        try {
            return list.removeAll(c);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public boolean retainAll(Collection<?> c) {

        readWriteLock.writeLock().lock();
        try {
            return list.retainAll(c);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public void clear() {

        readWriteLock.writeLock().lock();
        try {
            list.clear();
        } finally {
            readWriteLock.writeLock().unlock();
        }
        list.clear();
    }

    @Override
    public E get(int index) {

        readWriteLock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public E set(int index, E element) {

        readWriteLock.writeLock().lock();
        try {
            return list.set(index, element);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public void add(int index, E element) {

        readWriteLock.writeLock().lock();
        try {
            list.add(index, element);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public E remove(int index) {

        readWriteLock.writeLock().lock();
        try {
            return list.remove(index);
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }

    @Override
    public int indexOf(Object o) {

        readWriteLock.readLock().lock();
        try {
            return list.indexOf(o);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public int lastIndexOf(Object o) {

        readWriteLock.readLock().lock();
        try {
            return list.lastIndexOf(o);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public ListIterator<E> listIterator() {

        readWriteLock.readLock().lock();
        try {
            return list.listIterator();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public ListIterator<E> listIterator(int index) {

        readWriteLock.readLock().lock();
        try {
            return list.listIterator(index);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {

        readWriteLock.readLock().lock();
        try {
            return list.subList(fromIndex, toIndex);
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
