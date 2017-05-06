package rest.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marr on 2017-05-06.
 */
@Component
public class MusicService {

    public List<String> getKindsOfMusic(){
        List<String> tags = new ArrayList<>();
        tags.add("#pop");
        tags.add("#reagge");
        tags.add("#rap");
        tags.add("#rock");
        tags.add("#blues");
        tags.add("#metal");
        tags.add("#funk");
        tags.add("#disco");
        tags.add("#folk");
        tags.add("#jazz");
        return tags;
    }

}
