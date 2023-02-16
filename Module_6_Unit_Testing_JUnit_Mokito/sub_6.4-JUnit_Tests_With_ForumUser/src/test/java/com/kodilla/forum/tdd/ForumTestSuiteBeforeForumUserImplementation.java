package com.kodilla.forum.tdd;

import com.kodilla.forum.ForumComment;
import com.kodilla.forum.ForumPost;
import com.kodilla.forum.ForumUserFrame;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite \uD83D\uDE31")
public class ForumTestSuiteBeforeForumUserImplementation {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testAddPost() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");

        //When
        forumUserFrame.addPost("mrsmith",
                "Hello everyone, this is my first contribution here!");

        //Then
        Assertions.assertEquals(1, forumUserFrame.getPostsQuantity());
    }

    @Test
    void testAddComment() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        //When
        forumUserFrame.addComment(thePost, "mrsmith", "Thank you for all good words!");

        //Then
        Assertions.assertEquals(1, forumUserFrame.getCommentsQuantity());
    }

    @Test
    void testGetPost() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        forumUserFrame.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        ForumPost retrievedPost;
        retrievedPost = forumUserFrame.getPost(0);

        //Then
        Assertions.assertEquals(thePost, retrievedPost);
    }

    @Test
    void testGetComment() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");
        forumUserFrame.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        ForumComment retrievedComment = forumUserFrame.getComment(0);

        //Then
        Assertions.assertEquals(theComment, retrievedComment);
    }

    @Test
    void testRemovePostNotExisting() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");

        //When
        boolean result = forumUserFrame.removePost(thePost);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    void testRemoveCommentNotExisting() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");

        //When
        boolean result = forumUserFrame.removeComment(theComment);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    void testRemovePost() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        forumUserFrame.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        boolean result = forumUserFrame.removePost(thePost);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, forumUserFrame.getPostsQuantity());
    }

    @Test
    void testRemoveComment() {
        //Given
        ForumUserFrame forumUserFrame = new ForumUserFrame("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("Hello everyone, " +
                "this is my first contribution here!", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "mrsmith",
                "Thank you for all good words!");
        forumUserFrame.addComment(thePost, theComment.getAuthor(),
                theComment.getCommentBody());

        //When
        boolean result = forumUserFrame.removeComment(theComment);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, forumUserFrame.getCommentsQuantity());
    }
}
