package de.hartmut.jfs.cloud.rest;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.BackgroundPreinitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hartmut on 19.02.16.
 */
@RestController
public class LightRest {
    private static final Logger LOG = LoggerFactory.getLogger(LightRest.class);

    private Boolean redState = true;
    private Boolean yellowState = false;
    private Boolean greenState = false;

    @RequestMapping(value = "/light", method = RequestMethod.PUT)
    public void lightUpdate(@RequestParam(value="red") String red,
                            @RequestParam(value="yellow") String yellow,
                            @RequestParam(value="green") String green) {

        LOG.info("PUT /light: {} {} {}", red, yellow, green);
        redState = "on".equalsIgnoreCase(red);
        yellowState = "on".equalsIgnoreCase(yellow);
        greenState = "on".equalsIgnoreCase(green);
    }

    @RequestMapping(value = "/light", method = RequestMethod.GET)
    public ResponseEntity<LightState> getLightState() {

        LOG.debug("GET /light");

        LightState lightState = new LightState();
        lightState.setRed(redState);
        lightState.setYellow(yellowState);
        lightState.setGreen(greenState);

        return ResponseEntity.ok(lightState);
    }



}
