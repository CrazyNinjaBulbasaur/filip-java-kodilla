package com.kodilla.testing;

public class AdditionalTask {
    public static void main(String[] args) {
        storeVovelsFromString("Adam");
    }

    /**
     * Napisz program, który z podanego ciągu znaków znajdzie same samogłoski.
     * Na przykład dla napisu “Adam" zwróci tylko “Aa".
     * Kluczowy algorytm zamknij w osobnej funkcji/metodzie, która będzie przyjmowała 1 argument wejściowy.
     * ta nie powinna wypisać niczego na ekran.

     * Jeśli nie wiesz, jak podejść do tego zadania, uświadom sobie,
     * że samogłosek w języku polskim jest stosunkowo niewiele.
     * Zacznij od wypisania ich ciągu “aeyiou". Teraz możesz napisać program,
     * który będzie kolejno sprawdzał znaki w ciągu i po kolei porównywał je z elementami z ciągu samogłosek.
     */
    static void storeVovelsFromString(String text) {
        char[] textToCharArray = text.toCharArray();
        StringBuilder vovels = new StringBuilder();

//        for (int i = 0; i < textToCharArray.length; i++) {
//            if (textToCharArray[i] == 'a' || textToCharArray[i] == 'e' || textToCharArray[i] == 'i' || textToCharArray[i] == 'o' ||
//                 textToCharArray[i] == 'u' ) {
//
//                vovels.append(textToCharArray[i]);
//            }
//        }

        /**
         * It's better to use enhanced for iteration
         */
//        for (int i = 0; i < textToCharArray.length; i++) {
//            if (textToCharArray[i] == 'a' || textToCharArray[i] == 'A' || textToCharArray[i] == 'e' || textToCharArray[i] == 'E' ||
//                    textToCharArray[i] == 'i' || textToCharArray[i] == 'I' || textToCharArray[i] == 'o' || textToCharArray[i] == 'O' ||
//                    textToCharArray[i] == 'u' || textToCharArray[i] == 'U') {
//
//                vovels.append(textToCharArray[i]);
//            }
//        }

        for (char c : textToCharArray) {
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
                    c == 'i' || c == 'I' || c == 'o' || c == 'O' ||
                    c == 'u' || c == 'U') {

                vovels.append(c);
            }
        }
        System.out.println(vovels);
    }
}
