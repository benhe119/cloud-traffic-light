package de.hartmut.jfs.cloud.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(value = "/light", method = RequestMethod.PUT)
    public void lightUpdate(@RequestParam(value="red") String red,
                            @RequestParam(value="yellow") String yellow,
                            @RequestParam(value="green") String green) {

        LOG.info("/light: {} {} {}", red, yellow, green);
    }


}
