package de.hartmut.jfs.cloud.rest;

import com.sun.org.apache.xpath.internal.operations.Bool;
import de.hartmut.jfs.cloud.states.LightStateMachine;
import de.hartmut.jfs.cloud.states.LightStateMachine.Events;
import de.hartmut.jfs.cloud.states.LightStateMachine.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.BackgroundPreinitializer;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.*;

import static de.hartmut.jfs.cloud.states.LightStateMachine.Events.NEXT;

/**
 * Created by hartmut on 19.02.16.
 */
@RestController
public class LightRest {
    private static final Logger LOG = LoggerFactory.getLogger(LightRest.class);

    private Boolean redState = true;
    private Boolean yellowState = false;
    private Boolean greenState = false;

    private final StateMachine<States, Events> stateMachine;


    @Autowired
    public LightRest(StateMachine<States, Events> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @PutMapping("/light")
    public void lightUpdate(@RequestParam(value="red") String red,
                            @RequestParam(value="yellow") String yellow,
                            @RequestParam(value="green") String green) {

        LOG.info("PUT /light: {} {} {}", red, yellow, green);
        redState = "on".equalsIgnoreCase(red);
        yellowState = "on".equalsIgnoreCase(yellow);
        greenState = "on".equalsIgnoreCase(green);
    }

    @GetMapping("/light")
    public ResponseEntity<LightState> getLightState() {

        LOG.debug("GET /light");

        LightState lightState = new LightState();
        lightState.setRed(redState);
        lightState.setYellow(yellowState);
        lightState.setGreen(greenState);

        return ResponseEntity.ok(lightState);
    }

    @PutMapping("/light/next")
    public void setNext() {
        LOG.info("PUT /light");
        stateMachine.sendEvent(NEXT);
    }

}
