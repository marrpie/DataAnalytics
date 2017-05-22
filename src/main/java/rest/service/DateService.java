package rest.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mpe on 22.05.2017.
 */
@Component
public class DateService {
    private Date today;

    @PostConstruct
    public void init() {
        this.today = new Date();
    }

    public String getDate_dd_MM_yyyy(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy");
        String str_date = formatter.format(today);
        return str_date;
    }
}
