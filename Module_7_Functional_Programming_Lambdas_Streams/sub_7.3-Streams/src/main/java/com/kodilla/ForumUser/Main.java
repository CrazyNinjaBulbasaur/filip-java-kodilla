package com.kodilla.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> theResultMapOfForumUsers = forum.getTheForumUserList()
                .stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().until(LocalDate.now(), ChronoUnit.YEARS) > 20)
                .filter(forumUser -> forumUser.getNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID , forumUser -> forumUser));

        theResultMapOfForumUsers.entrySet().stream()
                .map(entry -> "Used ID: " + entry.getKey() + " " + entry.getValue())
                .forEach(System.out::println);
    }
}
