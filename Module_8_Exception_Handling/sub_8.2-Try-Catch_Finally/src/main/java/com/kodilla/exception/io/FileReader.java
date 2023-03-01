package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("names.txt").getFile());

    public void readFile() {
        System.out.println("readFile()");

        Path path = Paths.get(file.getPath());

        try {
            Stream<String> fileLines = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        }
        System.out.println(file.getPath() + "\n");
    }

    public void readFileWithWrongPath(){
        System.out.println("readFileWithWrongPath()");
        Path path = Paths.get("tego-pliku-nie-ma.txt");

        try {
            Stream<String> fileLines = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        }

        System.out.println(path.toString() + "\n");
    }

    public void readFileAndPrintNames() {
        System.out.println("readFileAndPrintNames()");

        Path path = Paths.get(file.getPath());

        try {
            Stream<String> fileLines = Files.lines(path);
            System.out.println("Printing names: ");
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");
        }
        System.out.println();
    }

    public void printException(){
        System.out.println("printException()");
        Path path = Paths.get("tego-pliku-nie-ma.txt");

        try {
            Stream<String> fileLines = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error:" + "\n" + e + "\n");
        }
    }

    public void simplifiedTryCatch(){

        System.out.println("simplifiedTryCatch()");

        Path path = Paths.get(file.getPath());

        try (Stream<String> fileLines = Files.lines(path)) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }
    }

    public void simplifiedTryCatch2(){

        System.out.println("simplifiedTryCatch2()");

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        }

    }

    public void finallyBlockNoError(){

        System.out.println("finallyBlockNoError()");

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        } finally {
            System.out.println("I am gonna be here... always!");
        }
        System.out.println();
    }

    public void finallyBlockWithError(){

        System.out.println("finallyBlockWithError()");

        try (Stream<String> fileLines = Files.lines(Paths.get("tego-pliku-nie-ma.txt"))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error:" + e);
        } finally {
            System.out.println("I am gonna be here... always!");
        }

    }
}
