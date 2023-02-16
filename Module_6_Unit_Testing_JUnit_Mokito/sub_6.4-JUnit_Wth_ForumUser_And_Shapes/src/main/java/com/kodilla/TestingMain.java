package com.kodilla;


import com.kodilla.forum.ForumPost;
public class TestingMain {

    public static void main(String[] args) {
        ForumPost fp = new ForumPost("Bulbasaur is the best", "Bulbi the Mighty");
        System.out.println(fp.getClass());
        System.out.println(ForumPost.class);

    }


}
