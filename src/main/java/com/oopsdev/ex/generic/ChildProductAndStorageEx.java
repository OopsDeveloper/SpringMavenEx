package com.oopsdev.ex.generic;

public class ChildProductAndStorageEx {
    public static void main(String[] args) {
        ChildProduct<Tv, String, String> product = new ChildProduct<Tv, String, String>();
        product.setKind(new Tv());
        product.setModel("Smart TV");
        product.setCompany("Samsung");

        Storage<Tv> storage = new StorageImpl<Tv>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);
    }
}
