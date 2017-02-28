import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import rest.service.fb.AccessFB;

/**
 * Created by mpe on 17.02.2017.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"rest.service"})
public class Main {

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }

}
