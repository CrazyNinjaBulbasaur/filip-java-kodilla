package com.kodilla.Exercise_String_Beautifier;

public class PoemBeautifier {

    public void beautify(String text, PoemDecorator poemDecorator){
        System.out.println("Original text: " + text);

        String textAfterDecorating = poemDecorator.decorate(text);

        System.out.println("Text after 'decorating': " + textAfterDecorating);
    }

    public static String addABCAtTheBeginning(String text){


        return "ABC" + text;
    };

    public static String textToUpperCase(String text){

        return text.toUpperCase();
    };

    public static String replaceACharWithECharUpperCaseIncluded(String text){
        return text.replace('a', 'e').replace('A', 'E');
    }

    public static String replaceXCharWithYCharUpperCaseIncluded(String text, Character x, Character y){

        return text.replace(x, y).replace(x.toString().toUpperCase(), y.toString().toUpperCase());
    };

    public static String exterminateWhiteSpaces(String text){

        return text.replaceAll("\\s+", "");
    };
}
