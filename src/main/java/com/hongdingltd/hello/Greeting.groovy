package com.hongdingltd.hello

import java.util.concurrent.atomic.AtomicLong

/**
 * Created by jcchen on 15-11-24.
 */
class Greeting {
    final long id
    final String content

    Greeting(long id, String content) {
        this.id = id
        this.content = content
    }
}
