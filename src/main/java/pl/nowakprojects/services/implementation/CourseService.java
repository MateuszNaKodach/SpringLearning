package pl.nowakprojects.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.nowakprojects.models.Course;
import pl.nowakprojects.repositories.CourseRepository;
import pl.nowakprojects.services.interfaces.ICourseService;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(String topicId) {
        return (List<Course>) courseRepository.findByTopicId(topicId);
    }

    @Override
    public Course getCourse(String id) {
        return courseRepository.findOne(id);
    }

    @Override
    public void addCourse(Course course) {

        courseRepository.save(course);
    }

    @Override
    public void updateCourse(String id, Course course) {
        addCourse(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }
}
