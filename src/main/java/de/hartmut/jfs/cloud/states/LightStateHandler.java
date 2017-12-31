package de.hartmut.jfs.cloud.states;

import de.hartmut.jfs.cloud.rest.LightState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import javax.annotation.PostConstruct;

/**
 * hartmut on 10.12.17.
 */
@WithStateMachine
public class LightStateHandler {
    private static final Logger LOG = LoggerFactory.getLogger(LightStateMachine.class);

    private LightState lightState;

    @PostConstruct
    public void init() {
        lightState = new LightState();
        lightState.setRed(true);
        lightState.setYellow(false);
        lightState.setGreen(false);
        lightState.setCount(0);
    }

    public LightState getLightState() {
        return lightState;
    }

    public void setLightState(LightState lightState) {
        this.lightState = lightState;
    }

    @OnTransition(target = "RED")
    public void toStateRed() {
        LOG.info("toStateRed");
        lightState.setRed(true);
        lightState.setYellow(false);
        lightState.setGreen(false);
        incrementCount();
    }

    @OnTransition(target = "READY")
    public void toStateReady() {
        LOG.debug("toStateReady");
        lightState.setRed(true);
        lightState.setYellow(true);
        lightState.setGreen(false);
        incrementCount();
    }

    @OnTransition(target = "GO")
    public void toStateGo() {
        LOG.debug("toStateGo");
        lightState.setRed(false);
        lightState.setYellow(false);
        lightState.setGreen(true);
        incrementCount();
    }

    @OnTransition(target = "CAUTION")
    public void toStateCaution() {
        LOG.debug("toStateCaution");
        lightState.setRed(false);
        lightState.setYellow(true);
        lightState.setGreen(false);
        incrementCount();
    }

    private void incrementCount() {
        lightState.setCount(lightState.getCount()+1);
    }
}
