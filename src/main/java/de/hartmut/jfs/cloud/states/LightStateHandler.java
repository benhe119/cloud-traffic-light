package de.hartmut.jfs.cloud.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * hartmut on 10.12.17.
 */
@WithStateMachine
public class LightStateHandler {
    private static final Logger LOG = LoggerFactory.getLogger(LightStateMachine.class);
    @OnTransition(target = "RED")
    void toStateRed() {
        LOG.info("toStateRed");
    }
    @OnTransition(target = "READY")
    void toStateReady() {
        LOG.debug("toStateReady");
    }
    @OnTransition(target = "GO")
    void toStateGo() {
        LOG.debug("toStateGo");
    }
    @OnTransition(target = "CAUTION")
    void toStateCaution() {
        LOG.debug("toStateCaution");
    }
}
