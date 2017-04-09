package pl.nowakprojects.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    private final String id;

    private final String name;

    private final String description;

    @ManyToOne
    private Topic topic;

    public Course(String id, String name, String description, String topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId);
    }
}
