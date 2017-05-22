package rest.service;

import org.springframework.social.twitter.api.GeoCode;
import org.springframework.stereotype.Component;

/**
 * Created by Marr on 2017-05-06.
 */
@Component
public class GeoService {

    public GeoCode getGeoCodeByCountry(String country){
        switch(country){
            case "gb":
                return getGeoCodeForWlkb();
            case "usa":
                return getGeoCodeForUSA();
            case "sa":
                return getGeoCodeForRPA();
            case "canada":
                return getGeoCodeForCanada();
            case "australia":
                return getGeoCodeForAustralia();
            case "nz":
                return getGeoCodeForNewZeland();
            default:
                return null;
        }
    }

    private GeoCode getGeoCodeForWlkb(){
        return new GeoCode(54.292, -4.599, 500, GeoCode.Unit.KILOMETER);
    }

    private GeoCode getGeoCodeForUSA(){
        return new GeoCode(32.785, -101.885, 2550, GeoCode.Unit.KILOMETER);
    }

    private GeoCode getGeoCodeForAustralia(){
        return new GeoCode(-27.299, 133.276, 1800, GeoCode.Unit.KILOMETER);
    }

    private GeoCode getGeoCodeForNewZeland(){
        return new GeoCode(-41.984, 172.984, 751, GeoCode.Unit.KILOMETER);
    }

    private GeoCode getGeoCodeForCanada(){
        return new GeoCode(60.856, -94.153, 2200, GeoCode.Unit.KILOMETER);
    }

    private GeoCode getGeoCodeForRPA(){
        return new GeoCode(-29.975, 25.891, 500, GeoCode.Unit.KILOMETER);
    }

}
