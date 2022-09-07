package com.oopsdev.ex.generic;

public class StorageImpl<T> implements Storage<T> {
    private T[] array;

    // 생성자에서 T타입 배열을 만들 때
    // Object 배열로 먼저 만들고 T타입 배열로 타입 변환.
    public StorageImpl(int capacity) {
        array = (T[])(new Object[capacity]);
    }

    @Override
    public void add(T item, int index) {
        array[index] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }
}
