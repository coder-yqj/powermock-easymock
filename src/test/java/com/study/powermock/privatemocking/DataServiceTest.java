package com.study.powermock.privatemocking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.easymock.PowerMock.*;

/**
 * Created by Administrator on 2018/7/15/015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(DataService.class)
public class DataServiceTest {
    @Test
    public void testReplaceData() throws Exception {
        final String modifyDataMethodName = "modifyData";
        final byte[] expectedBinaryData = new byte[] { 42 };
        final String expectedDataId = "id";

        // Mock only the modifyData method
        DataService tested = createPartialMock(DataService.class, modifyDataMethodName);

		/*
		 * This is the simplest way to expect a non-void method call to a
		 * private method using PowerMock. You simply supply the instance under
		 * test as the first parameter followed by the method name of the method
		 * to expect. The last two parameters are simply the method arguments
		 * that should be expected when invoking the method.
		 */
        expectPrivate(tested, modifyDataMethodName, expectedDataId,
                expectedBinaryData).andReturn(true);

        replay(tested);

        assertTrue(tested.replaceData(expectedDataId, expectedBinaryData));

        verify(tested);
    }

    @Test
    public void testDeleteData() throws Exception {
        final String modifyDataMethodName = "modifyData";
        final byte[] expectedBinaryData = null;
        final String expectedDataId = "id";

        // Mock only the modifyData method
        DataService tested = createPartialMock(DataService.class, modifyDataMethodName);

		/*
		 * This is the simplest way to expect a non-void method call to a
		 * private method using PowerMock. You simply supply the instance under
		 * test as the first parameter followed by the method name of the method
		 * to expect. The last two parameters are simply the method arguments
		 * that should be expected when invoking the method.
		 */
        expectPrivate(tested, modifyDataMethodName, expectedDataId,
                expectedBinaryData).andReturn(true);

        replay(tested);

        assertTrue(tested.deleteData(expectedDataId));

        verify(tested);
    }
}