package com.hongdingltd.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by jcchen on 15-11-25.
 */
@Entity
class User {

    @Id
    @GeneratedValue
    Long id

    String username
    Date createdDate
    Date lastAccessed
    Boolean isActive = Boolean.TRUE
}
