package basics;

import java.awt.*;

import static java.awt.Color.*;

public class Weather {

    public void updateWeather(int degrees) {
        String description;
        Color color;
        if(degrees < 5) {
            description = "cold";
            color = BLUE;
        } else if (degrees < 23) {
            description = "mild";
            color = ORANGE;
        } else {
            description = "hot";
            color = RED;
        }
        // ...
    }
}