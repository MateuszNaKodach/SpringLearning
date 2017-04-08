package pl.nowakprojects.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.nowakprojects.models.Course;
import pl.nowakprojects.models.Topic;
import pl.nowakprojects.services.interfaces.ICourseService;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
@RestController
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @RequestMapping(value = "/topics/{id}/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable String id){
         return courseService.getAllCourses(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String id){
            return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.POST)
    public void addCourse(@PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable String id, @PathVariable String topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId));
        courseService.updateCourse(id, course);
    }

    @RequestMapping(value = "/topics/{topicId}/topics/{id}", method = RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}

