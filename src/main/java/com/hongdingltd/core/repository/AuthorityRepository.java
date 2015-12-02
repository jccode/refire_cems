package com.hongdingltd.core.repository;

import com.hongdingltd.core.domain.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jcchen on 15-12-2.
 */
@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

}
