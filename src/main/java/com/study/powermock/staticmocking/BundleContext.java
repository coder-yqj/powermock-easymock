package com.study.powermock.staticmocking;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public interface BundleContext {
    ServiceRegistration registerService(String name, Object serviceImplementation, String filter);

}
