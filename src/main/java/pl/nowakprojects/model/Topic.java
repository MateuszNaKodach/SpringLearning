package pl.nowakprojects.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    private String id;

    private String name;

    private String description;
}
