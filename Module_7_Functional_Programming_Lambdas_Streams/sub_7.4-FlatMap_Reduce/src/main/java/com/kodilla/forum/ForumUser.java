package com.kodilla.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {

    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(String username, String realName, String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    /**
     * Metoda getLocationsOfFriends() tworzy strumień na kolekcji friends (jest to Set zawierający obiekty typu ForumUser)
     * i następnie dokonuje operacji transformującej z wykorzystaniem wyrażenia lambda (linia [1]):
     *
     *  friend -> friend.getLocation(),
     *
     * czyli dokonuje zmiany obiektów w strumieniu z ForumUser na obiekty typu String.
     *
     * W ostatnim kroku działania tworzona jest kolekcja wynikowa typu Set
     * przy użyciu kolektora strumienia – Collectors.toSet().
     */
    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(ForumUser::getLocation)                    // [1]
                .collect(Collectors.toSet());
    }

    /**

     */
    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()                               // [1]
                .flatMap(user -> user.getFriends().stream())       // [2]
                .filter(user -> user != this)                      // [3]
                .map(ForumUser::getLocation)                       // [4]
                .collect(Collectors.toSet());                      // [5]
    }
    /**
     * W linii [1] tworzony jest i uruchamiany strumień na kolekcji friends.
     *
     * W linii [2] dokonujemy spłaszczenia strumienia – dla każdego przyjaciela (user) pobieramy jego
     * listę przyjaciół (user.getFriends()) i przekazujemy ją do dalszego przetwarzania w postaci nowego strumienia Stream.
     * Od tego momentu pracujemy nie na liście przyjaciół, lecz na liście "przyjaciół przyjaciół".
     *
     * W linii [3] wykluczamy ze zbioru wynikowego odwołania do "samego siebie" – wiadomo,
     * że my też jesteśmy przyjacielem naszych przyjaciół, jednak interesują nas ich lokalizacje, a nie nasza własna.
     *
     * W linii [4] transformujemy strumień tak, że zamiast obiektów ForumUser,
     * dalej będą już przez niego przepływały jedynie obiekty String będące lokalizacjami użytkowników
     * (pobieramy je przy pomocy metody ForumUser::getLocation).
     *
     * W linii [5] dokonujemy złożenia strumienia wynikowego w kolekcję typu Set
     * zawierającą listę lokalizacji "przyjaciół przyjaciół".
     */


    /**
     * Getters
     * toString()
     * hashCode()
     */

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        return username.equals(forumUser.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
