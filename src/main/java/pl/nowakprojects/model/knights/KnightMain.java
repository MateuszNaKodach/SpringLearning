package pl.nowakprojects.model.knights;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.nowakprojects.configurations.KnightConfig;

/**
 * Created by Mateusz on 28.03.2017.
 */
@SpringBootApplication
public class KnightMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);

        Minstrel minstrel = context.getBean(Minstrel.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }


}
