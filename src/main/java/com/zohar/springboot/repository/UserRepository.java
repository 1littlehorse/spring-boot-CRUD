package com.zohar.springboot.repository;

import com.zohar.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 2、实现数据持久层

public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    User findById(long id);

    @Query(value = "select * from user where name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<User> findByName(@Param("name")String name);







}
