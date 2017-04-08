package pl.nowakprojects.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mateusz on 08.04.2017.
 */
@Entity
@Table(name = "Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "BookId")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "PublishedDate")
    private Date published;

}
