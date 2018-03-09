package movies.spring.data.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@SpringBootApplication
@EntityScan("movies.spring.data.neo4j.domain")
public class SampleMovieApplication {

	public static void main(String[] args) {
           // ApplicationContext ctx = new AnnotationConfigApplicationContext(SampleMovieConfig.class);
          //  SampleMovieApplication sampleMovieApp = ctx.getBean(SampleMovieApplication.class);
          //  SpringApplication.run(sampleMovieApp, args);
		SpringApplication.run(SampleMovieApplication.class, args);
	}
}
