package pl.nowakprojects.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.nowakprojects.models.Course;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
public interface CourseRepository extends CrudRepository<Course,String> {
    List<Course> findByTopicId(String topicId);

    List<Course> findByName(String name); //all courses by name
    List<Course> findByDescription(String desc);
}
