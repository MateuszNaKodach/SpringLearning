package pl.nowakprojects.model.knights;

import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by Mateusz on 26.03.2017.
 */
public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest(){
        Quest mockQuest = mock(Quest.class);

        BraveKnight braveKnight = new BraveKnight(mockQuest);
        braveKnight.embarkOnQuest();
        braveKnight.embarkOnQuest();

        Quest mockQuest2 = mock(Quest.class);

        braveKnight = new BraveKnight(mockQuest2);
        braveKnight.embarkOnQuest();

        verify(mockQuest, times(2)).embark();
        verify(mockQuest2, times(1)).embark();
    }
}
