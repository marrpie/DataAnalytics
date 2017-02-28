package rest.service.fb;

import com.restfb.FacebookClient;
import org.springframework.stereotype.Component;

/**
 * Created by mpe on 28.02.2017.
 */

@Component
public interface AccessFBInterface {
    FacebookClient getFacebookClient();
}
