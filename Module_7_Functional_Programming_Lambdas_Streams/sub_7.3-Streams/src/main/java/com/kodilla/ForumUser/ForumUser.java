package com.kodilla.ForumUser;

import java.time.LocalDate;

/**Klasa ForumUser powinna mieć następujące pola (użyj odpowiednich nazw angielskich):
 unikalny identyfikator użytkownika (typu int),
 nazwa użytkownika (typu String),
 płeć (typu char), z wartościami ‘M’/’F’,
 data urodzenia (typu LocalDate),
 ilość opublikowanych postów (typu int).
 */
public final class ForumUser {

    private final int userID;

    private final String username;

    private final char sex;

    private final LocalDate dateOfBirth;

    private final int numberOfPosts;

    public ForumUser(final int userID, final String username, final char sex, final LocalDate dateOfBirth, final int numberOfPosts) {
        this.userID = userID;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if (userID != forumUser.userID) return false;
        if (sex != forumUser.sex) return false;
        if (numberOfPosts != forumUser.numberOfPosts) return false;
        if (!username.equals(forumUser.username)) return false;
        return dateOfBirth.equals(forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + username.hashCode();
        result = 31 * result + (int) sex;
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + numberOfPosts;
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberOfPosts=" + numberOfPosts +
                '}';
    }
}
