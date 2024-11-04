package api_framework.resources;

import org.reziq.pojo.AddPlace;
import org.reziq.pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload() {

        AddPlace addPlace = new AddPlace();
        Location location = new Location();

        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setLanguage("French");
        addPlace.setName("FrontLine house");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setWebsite("http://google.com");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        addPlace.setTypes(myList);
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);

        return addPlace;
    }
}
