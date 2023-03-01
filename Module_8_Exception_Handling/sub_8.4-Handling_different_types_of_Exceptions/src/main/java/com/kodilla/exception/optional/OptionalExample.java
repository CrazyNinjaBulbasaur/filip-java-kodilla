package com.kodilla.exception.optional;

import com.kodilla.exception.nullpointer.*;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        User user = new User("user1");

        //Optional   - ofNullable()
        Optional<User> optionalUser = Optional.ofNullable(user);

        //Optional   - orElse()
        String username =
                optionalUser.orElse(new User("")).getName();
        System.out.println(username);

        // Optional   - ifPresent
        optionalUser.ifPresent(u -> System.out.println(u.getName()));

    }
}
