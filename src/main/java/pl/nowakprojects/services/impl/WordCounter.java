package pl.nowakprojects.services.impl;

import org.springframework.stereotype.Service;
import pl.nowakprojects.services.IWordCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mateusz on 09.04.2017.
 */
@Service
public class WordCounter implements IWordCounter {

    @Override
    public int countWords(String sentence) {
        return (sentence == null || sentence.isEmpty()) ? 0 : sentence.split(" ").length;
    }

    @Override
    public List<Integer> countWordsLetters(String sentence) {
        List<Integer> result = new ArrayList<>();
        if(sentence!=null)
            Arrays.asList(sentence.split(" "))
                    .forEach(word -> result.add(word.length()));

        return result;
    }
}
