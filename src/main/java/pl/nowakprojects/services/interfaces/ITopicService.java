package pl.nowakprojects.services.interfaces;

import pl.nowakprojects.models.Topic;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */


public interface ITopicService {
    List<Topic> getAllTopics();
    Topic getTopic(String id);
    void addTopic(Topic topic);
    void updateTopic(String id, Topic topic);
    void deleteTopic(String id);
}
