package pl.nowakprojects.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nowakprojects.model.Topic;

/**
 * Created by Mateusz on 08.04.2017.
 */
public interface TopicRepository extends CrudRepository<Topic,String> {
}
