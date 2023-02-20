package com.kodilla.Exercise_String_Beautifier;

import static com.kodilla.Exercise_String_Beautifier.PoemBeautifier.*;
public class Exercise_Main {

    public static void main(String[] args) {

//        System.out.println(addABCAtTheBeginning("Text"));
//        System.out.println(textToUpperCase("bazinga"));
//        System.out.println(replaceXCharWithYCharUpperCaseIncluded("Ala", 'a', 'e'));
//        System.out.println(exterminateWhiteSpaces(" Text with some white spaces. b"));
//        System.out.println();

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("Using Lambdas");
        poemBeautifier.beautify("Text", text -> "ABC" + text);
        poemBeautifier.beautify("bazinga", text -> text.toUpperCase());
        poemBeautifier.beautify("Ala", text -> text.replace('a', 'e').replace('A', 'E'));
        poemBeautifier.beautify(" Text with some white spaces. b", text -> text.replaceAll("\\s+", ""));
        System.out.println();

        System.out.println("Using method reference");
        poemBeautifier.beautify("Text", PoemBeautifier::addABCAtTheBeginning);
        poemBeautifier.beautify("bazinga", PoemBeautifier::textToUpperCase);
        poemBeautifier.beautify("Ala",  PoemBeautifier::replaceACharWithECharUpperCaseIncluded);
        poemBeautifier.beautify(" Text with some white spaces. b", PoemBeautifier::exterminateWhiteSpaces);

//        poemBeautifier.beautify("Ala", PoemBeautifier::replaceXCharWithYCharUpperCaseIncluded);



    }
}
