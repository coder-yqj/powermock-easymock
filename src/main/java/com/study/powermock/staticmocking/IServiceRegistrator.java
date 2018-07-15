package com.study.powermock.staticmocking;

/**
 * Created by Administrator on 2018/7/15/015.
 */
public interface IServiceRegistrator {
    /**
     * Registers a service to the service framework.
     *
     * @param name
     *            The name of the service the register.
     * @param serviceImplementation
     *            The implementation of the service.
     * @return An id of the service that got registered. Should be used when
     *         unregistering the service.
     */
    long registerService(String name, Object serviceImplementation);

    /**
     * Unregisters a service from the service framework.
     *
     * @param id
     *            The id of the service that should be removed. The id was
     *            generated by {@link #registerService(String, Object)}.
     *
     * @throws IllegalStateException
     *             If this <code>ServiceRegistration</code> object has already
     *             been unregistered.
     */
    void unregisterService(long id);
}
