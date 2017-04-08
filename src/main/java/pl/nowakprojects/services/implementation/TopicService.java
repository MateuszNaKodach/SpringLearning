package pl.nowakprojects.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nowakprojects.models.Topic;
import pl.nowakprojects.repositories.TopicRepository;
import pl.nowakprojects.services.interfaces.ITopicService;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service
public class TopicService implements ITopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public List<Topic> getAllTopics() {
        return (List<Topic>) topicRepository.findAll();
    }

    @Override
    public Topic getTopic(String id) {
        return topicRepository.findOne(id);
    }

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void updateTopic(String id, Topic topic) {
        addTopic(topic);
    }

    @Override
    public void deleteTopic(String id) {
        topicRepository.delete(id);
    }
}
