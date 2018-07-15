package com.study.powermock.newmocking;

import java.io.File;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public class PersistenceManager {
    public boolean createDirectoryStructure(String directoryPath) {
        File directory = new File(directoryPath);

        if (directory.exists()) {
            throw new IllegalArgumentException("\"" + directoryPath + "\" already exists.");
        }

        return directory.mkdirs();
    }
}
