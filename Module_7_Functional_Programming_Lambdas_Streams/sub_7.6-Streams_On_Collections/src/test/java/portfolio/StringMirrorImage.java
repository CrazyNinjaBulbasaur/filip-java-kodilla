package portfolio;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringMirrorImage {

    @Test
    void testReverseStringUsingStreams(){
        //Given
        String initialText = "text";

        //When
        String reversedText = reverseStringUsingStreams(initialText);


        //Then
        assertEquals("txet", reversedText);
    }

    @Test
    void testReverseString(){
        //Given
        String initialText = "text";

        //When
        String reversedText = reverseString(initialText);
//        System.out.println(reversedText);


        //Then
        assertEquals("txet", reversedText);
    }

    @Test
    void testReverseStringWithStringBuilderReverseMethod(){
        //Given
        String initialText = "text";

        //When
        String reversedText = reverseStringWithStringBuilderReverseMethod(initialText);
//        System.out.println(reversedText);


        //Then
        assertEquals("txet", reversedText);
    }



    String reverseStringUsingStreams(String text){

       List<Character> list = text.chars()
                             .mapToObj(character -> (char) character)
                             .collect(Collectors.toList());

        Collections.reverse(list);

//        return list.toString();

        return list.stream()
                .map( n -> String.valueOf(n))
                .collect(Collectors.joining(""));
    }


     String reverseString(String text){
                char[] textAsCharArray = text.toCharArray();

                StringBuilder sb = new StringBuilder();

                for(int i = textAsCharArray.length-1; i>=0; i--){
                    sb.append(textAsCharArray[i]);
        }

        return sb.toString();
    }

    String reverseStringWithStringBuilderReverseMethod(String text){


        return new StringBuilder(text).reverse().toString();
    }


}
