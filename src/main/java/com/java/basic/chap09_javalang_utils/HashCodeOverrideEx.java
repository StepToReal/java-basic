package com.java.basic.chap09_javalang_utils;

public class HashCodeOverrideEx {
}

//classic way
class User1 {
    private String name;
    private int age;
    private String passport;

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User1)) {
            return false;
        }

        User1 user1 = (User1)o;

        return user1.name.equals(name) &&
                user1.age == age &&
                user1.passport.equals(passport);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + passport.hashCode();
        return result;
    }
}
