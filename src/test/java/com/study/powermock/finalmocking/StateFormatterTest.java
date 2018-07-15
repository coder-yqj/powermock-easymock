package com.study.powermock.finalmocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.easymock.PowerMock.*;

/**
 * Created by Administrator on 2018/7/15/015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(StateHolder.class)
public class StateFormatterTest {
    @Test
    public void testGetFormattedState_actualStateExists() throws Exception {
        final String expectedState = "state";

        StateHolder stateHolderMock = createMock(StateHolder.class);
        StateFormatter tested = new StateFormatter(stateHolderMock);

        expect(stateHolderMock.getState()).andReturn(expectedState);

        replay(stateHolderMock);

        final String actualState = tested.getFormattedState();

        verify(stateHolderMock);

        assertEquals(expectedState, actualState);
    }

    @Test
    public void testGetFormattedState_noStateExists() throws Exception {
        final String expectedState = "State information is missing";

        StateHolder stateHolderMock = createMock(StateHolder.class);
        StateFormatter tested = new StateFormatter(stateHolderMock);

        expect(stateHolderMock.getState()).andReturn(null);

        replay(stateHolderMock);

        final String actualState = tested.getFormattedState();

        verify(stateHolderMock);

        assertEquals(expectedState, actualState);
    }
}