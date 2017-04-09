package pl.nowakprojects.services;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.nowakprojects.matchers.NumberMatcher;
import pl.nowakprojects.services.impl.WordCounter;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz on 09.04.2017.
 */
@RunWith(DataProviderRunner.class)
public class WordCounterTest {

    private WordCounter wordCounter;

    @Before
    public void setup(){
        wordCounter = new WordCounter();
    }

    @Test
    @DataProvider({
            "2, Mateusz Nowak",
            "1, Siemka!",
            "3, Ala ma Kota",
            "4, PGSSoftware prowadzi kurs Springa",
            "0, "
    })
    public void testWordCounting(int words, String sentence){
        assertEquals(words, wordCounter.countWords(sentence));
    }


    @Test
    @DataProvider(value = {
            "3/ Mateusz Nowak, student",
            "2/ Siemka, Józek!",
            "6/ Ala ma Kota, który lubi podróże.",
            "4/ PGSSoftware prowadzi kurs Springa",
            "0/ "
    },
            splitBy = "/"
    )
    public void testWordCountingWithComas(int words, String sentence){
        assertEquals(words, wordCounter.countWords(sentence));
    }

    @Test
    public void testLettersCounting(){
        List<Integer> result = wordCounter.countWordsLetters("Counting letters in that two words");

        assertThat(result,hasSize(6));
        assertThat(result, Matchers.contains(8,7,2,4,3,5));
        assertThat(result, Matchers.hasItem(4));
        assertThat(result.get(0), Matchers.equalTo(8));
        assertThat(result.get(5), Matchers.equalTo(5));
        assertThat(result.get(2), NumberMatcher.<Integer>isIntegralEven());
    }


}
