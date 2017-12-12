package de.hartmut.jfs.cloud.states;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

/**
 * hartmut on 10.12.17.
 */
@Configuration
@EnableStateMachine
public class LightStateMachine extends EnumStateMachineConfigurerAdapter<LightStateMachine.States, LightStateMachine.Events> {
    private static final Logger LOG = LoggerFactory.getLogger(LightStateMachine.class);

    public enum States {
        RED, READY, GO, CAUTION
    }

    public enum Events {
        NEXT
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }


    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates()
                .initial(States.RED)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                    .source(States.RED).target(States.READY).event(Events.NEXT)
                    .and()
                .withExternal()
                    .source(States.READY).target(States.GO).event(Events.NEXT)
                    .and()
                .withExternal()
                    .source(States.GO).target(States.CAUTION).event(Events.NEXT)
                    .and()
                .withExternal()
                    .source(States.CAUTION).target(States.RED).event(Events.NEXT);
    }

    @Bean
    public StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>() {
            @Override
            public void stateChanged(State<States, Events> from, State<States, Events> to) {
                LOG.debug("State change to " + to.getId());
            }
        };
    }

}
