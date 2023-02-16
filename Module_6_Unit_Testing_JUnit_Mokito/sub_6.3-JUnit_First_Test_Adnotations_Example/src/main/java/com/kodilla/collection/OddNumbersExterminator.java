package com.kodilla.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> even = new ArrayList<>();

        for(Integer e : numbers){
            if(e % 2 ==0){
                even.add(e);
            }
        }

        return even;
    }
}
