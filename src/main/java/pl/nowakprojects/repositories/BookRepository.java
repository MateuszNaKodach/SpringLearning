package pl.nowakprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nowakprojects.entities.Book;

import java.util.List;

/**
 * Created by Mateusz on 08.04.2017.
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByNameIgnoreCaseContaining(String name);
}
