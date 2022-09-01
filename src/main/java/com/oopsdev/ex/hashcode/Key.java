package com.oopsdev.ex.hashcode;

public class Key {
    public int number;

    public Key(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Key) {
            Key compareKey = (Key) obj;
            if (this.number == compareKey.number) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        //만약 2개를 비교하고 싶다면 Objects.hash 사용 -ex) Objects.hash(sno,name);
        return number;
    }
}
