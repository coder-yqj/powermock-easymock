package com.study.powermock.staticmocking;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/7/15/015.
 */
@Target( { ElementType.FIELD, ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inject {
}
