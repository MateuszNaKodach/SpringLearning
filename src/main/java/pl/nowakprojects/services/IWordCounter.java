package pl.nowakprojects.services;

import java.util.List;

/**
 * Created by Mateusz on 09.04.2017.
 */
public interface IWordCounter {
    int countWords(String sentence);
    List<Integer> countWordsLetters(String sentence);
}
