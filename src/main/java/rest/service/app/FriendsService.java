package rest.service.app;

import com.restfb.types.FriendList;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rest.service.fb.AccessFB;
import rest.service.fb.AccessFBInterface;

import javax.annotation.Resource;

/**
 * Created by mpe on 17.02.2017.
 */

@Controller
public class FriendsService {

    @Resource
    AccessFB fb;

    @RequestMapping(value = "/rest/friends/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getFriendsList(){
        FriendList friendList = fb.getFacebookClient().fetchObject("/me/friends", FriendList.class);

        return friendList.toString();
    }
}
