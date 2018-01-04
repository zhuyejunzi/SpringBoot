package com.example.first.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.first.entity.People;

public interface JPADalInterface extends JpaRepository<People, Integer> {

    // 原生SQL实现更新方法接口
    @Query(value = "update People set name=?1, weight=?2 where id=?3 ", nativeQuery = true)
    @Modifying
    @Transactional
    public int updateOne(String name, Integer weight, Integer id);

    public List<People> findPeopleByNameAndHeight(String name, Integer Height);
}
