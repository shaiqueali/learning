package com.test.q;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment {

    private TranslateWord translateWord;

    private List<String> storeList = new ArrayList<>();

    private Map<String, Integer> stringIntegerMap = new HashMap<>();

    public Assignment(TranslateWord translateWord) {
        this.translateWord = translateWord;
    }

    public void store(final String word) {
        if (word != null && word.length() != 0) storeList.add(word.toLowerCase());
    }

    public void store2(String word) {

        //  if key exists = increase the value + 1
        // if ket not exists = add key and value 1
        if (word != null && word.length() != 0) {
            word = translateWord.translate(word);
            word = word.toLowerCase();
            if (!stringIntegerMap.containsKey(word)) {
                stringIntegerMap.put(word, 1);
            } else {
                stringIntegerMap.put(word, stringIntegerMap.get(word) + 1);
            }
        }
    }

    public long print(final String word) {
        return storeList.stream().filter(s -> s.equals(word)).count();
    }

    public long print2(final String word) {
        return stringIntegerMap.get(word);
    }


}
