package com.study.powermock.finalmocking;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public final class StateHolder {
    /**
     * Dummy method that is used to demonstrate how PowerMock can deal with
     * final methods.
     *
     * @return The current state.
     */
    public final String getState() {
        // Imagine that we query a database for state
        return null;
    }

    /**
     * Dummy method that is used to demonstrate how PowerMock can deal with
     * final methods.
     */
    public final void setState(String state) {
        // Imagine that we store the state in a database.
    }
}
