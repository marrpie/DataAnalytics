package rest.service.fb;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import org.springframework.stereotype.Component;

/**
 * Created by mpe on 17.02.2017.
 */

@Component
public class AccessFB implements AccessFBInterface{
    private String token = "EAACEdEose0cBALKx0ZBiVRCDohXuLGajVXihTXg4y2HZC06ZCDn713nYXLLnCgd9wG5SMCy3EWj7MXKpqRIobklZCJn2MFxzh1a6RCocaSqFZCbfLZBwB3jWGZCzjbjM1dFiUZBzgRvNNLuK7xXZBrlW93ZBV3nmmNbpZAz7J7l5aN9IgsVKdzWBEQoJiXHi2v0RC52e1G1J5XoVHCZADxfxwG0i7tK3eMQDhk0ZD";
    private FacebookClient facebookClient = new DefaultFacebookClient(token);

    @Override
    public FacebookClient getFacebookClient() {
        return facebookClient;
    }

}
