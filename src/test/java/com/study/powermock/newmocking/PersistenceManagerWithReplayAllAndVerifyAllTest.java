package com.study.powermock.newmocking;


import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;


import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.easymock.PowerMock.*;

/**
 * Created by Administrator on 2018/7/15/015.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PersistenceManager.class)
public class PersistenceManagerWithReplayAllAndVerifyAllTest {

    @Test
    public void testCreateDirectoryStructure_ok() throws Exception {
        final String path = "directoryPath";
        File fileMock = createMock(File.class);

        PersistenceManager tested = new PersistenceManager();

        expectNew(File.class, path).andReturn(fileMock);

        expect(fileMock.exists()).andReturn(false);
        expect(fileMock.mkdirs()).andReturn(true);

        replayAll();

        assertTrue(tested.createDirectoryStructure(path));

        verifyAll();
    }

    @Test
    public void testCreateDirectoryStructure_ok_usingEasyMockToCreateTheFileMock() throws Exception {
        final String path = "directoryPath";
        File fileMock = EasyMock.createMock(File.class);

        PersistenceManager tested = new PersistenceManager();

        expectNew(File.class, path).andReturn(fileMock);

        expect(fileMock.exists()).andReturn(false);
        expect(fileMock.mkdirs()).andReturn(true);

        replayAll(fileMock);

        assertTrue(tested.createDirectoryStructure(path));

        verifyAll();
    }


    @Test
    public void testCreateDirectoryStructure_usingCreateMockAndExpectNew() throws Exception {
        final String path = "directoryPath";
        File fileMock = createMockAndExpectNew(File.class, path);

        PersistenceManager tested = new PersistenceManager();

        expect(fileMock.exists()).andReturn(false);
        expect(fileMock.mkdirs()).andReturn(true);

        replayAll();

        assertTrue(tested.createDirectoryStructure(path));

        verifyAll();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateDirectoryStructure_fails() throws Exception {
        final String path = "directoryPath";
        File fileMock = createMock(File.class);

        PersistenceManager tested = new PersistenceManager();

        expectNew(File.class, path).andReturn(fileMock);

        expect(fileMock.exists()).andReturn(true);

        replayAll();

        tested.createDirectoryStructure(path);

        verifyAll();
    }
}
