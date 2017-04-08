package pl.nowakprojects.service;

import org.springframework.stereotype.Service;
import pl.nowakprojects.model.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service
public class TopicService implements ITopicService{

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("pogoda","Prognoza Pogody", "KRAJ\n" +
                    "\n" +
                    "Wiadomości Kraj MSZ 5 godzin temu\n" +
                    "REDAKCJA POLECA\n" +
                    "Polskie MSZ zaniepokojone rosyjskimi tablicami na cmentarzu w Katyniu\n" +
                    "MSZ RP wyraziło zaniepokojenie i rozczarowanie z powodu umieszczenia przez stronę rosyjską na terenie polskiego cmentarza wojennego w Katyniu tablic z nieprawdziwymi informacjami o jeńcach bolszewickich z wojny 1919-21 zmarłych w niewoli w Polsce.\n" +
                    "Wiadomości Kraj 6 godzin temu\n" +
                    "\n" +
                    "Jaka pogoda czeka nas w sobotę 8 kwietnia 2017 roku?"),

            new Topic("premier-spotkanie","Spotkanie premier z szefami MSZ",
                    "Spotkanie premier Beaty Szydło z ministrem obrony Antonim " +
                            "Macierewiczem oraz szefem MSZ zakończyło się - poinformował dziennikarzy dzisiaj po godz." +
                            " 18 minister spraw zagranicznych Witold Waszczykowski."),

            new Topic("parlament-fatima","Parlament uchwalił rocznicę objawień fatimskich","\n" +
                    "0\n" +
                    "‹ wróć\n" +
                    "Przygotowaną przez posłów PiS uchwałę poparło w głosowaniu 245 posłów, 27 było przeciwko, " +
                    "a 11 wstrzymało się od głosu. Wcześniej Sejm odrzucił wniosek Klubu Nowoczesna o " +
                    "odrzucenie uchwały.")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    @Override
    public void updateTopic(String id, Topic topic) {
        Topic topicToUpdate = getTopic(id);
        int topicToUpdateIndex = topics.indexOf(topicToUpdate);

        topics.set(topicToUpdateIndex,topic);
    }

    @Override
    public void deleteTopic(String id) {
        topics.removeIf( t -> t.getId().equals(id));
    }
}
