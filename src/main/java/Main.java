import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import rest.api.TwitterController;
import rest.model.database.TweetDB;
import rest.repository.TweetDBRepository;

/**
 * Created by mpe on 17.02.2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"rest"})
@EnableJpaRepositories(basePackages = {"rest"})
@EntityScan(basePackages = {"rest"})
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

}
