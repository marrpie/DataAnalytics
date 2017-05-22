package rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rest.model.HashGraph;
import rest.service.*;

import java.io.IOException;
import java.util.*;

/**
 * Created by Marr on 2017-03-27.
 */

@RestController
@RequestMapping("/data")
public class TwitterController {

    @Autowired
    private FileService fileService;
    @Autowired
    private HashGraphService hashGraphService;
    @Autowired
    private MusicService musicService;
    @Autowired
    private GeoService geoService;
    @Autowired
    private DateService dateService;

    @RequestMapping (value = "/search/tweet/music/{country}", produces = "application/json", method = RequestMethod.GET)
    public String getTweetsByHash(@PathVariable String country){
        List<String> tags = musicService.getKindsOfMusic();

        GeoCode geoCode = geoService.getGeoCodeByCountry(country);
        if(geoCode == null){
            return "Wrong country! Try one of this:\n- australia, \n- canada, \n- gb (Great Britain and Ireland), \n- nz (New Zealand), \n- sa (South Africa), \n- usa (United States of America)";
        }

        HashGraph graph = hashGraphService.createHashGraph(tags, geoCode);

        String path = System.getProperty("user.dir");
        String str_date = dateService.getDate_dd_MM_yyyy();

        String edgeFile = path.replace("\\", "/") + "/music_edges_" + country + "_" + str_date + ".csv";
        try{
            fileService.generateHashEdgeCSVFile(edgeFile, graph);

            return "Genereted new file: \n" + edgeFile;
        } catch(IOException e){
            System.out.println("Exception during generation CSV files");
            return "Exception during generation CSV files";
        }
    }

}

