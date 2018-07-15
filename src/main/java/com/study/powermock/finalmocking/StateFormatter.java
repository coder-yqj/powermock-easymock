package com.study.powermock.finalmocking;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public class StateFormatter {
    private final StateHolder stateHolder;

    public StateFormatter(StateHolder stateHolder) {
        this.stateHolder = stateHolder;
    }

    public String getFormattedState() {
        String safeState = "State information is missing";
        final String actualState = stateHolder.getState();
        if (actualState != null) {
            safeState = actualState;
        }
        return safeState;
    }
}
