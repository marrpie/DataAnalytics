import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mpe on 17.02.2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"rest"})
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

}
