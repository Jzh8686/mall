package com.project.mall.repository;

import com.project.mall.entity.Good;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface GoodRepository extends JpaRepository<Good, Integer> {
    public Good findDistinctByGoodid(int id);

    List<Good> findAll();

    @Override
    <S extends Good> S save(S s);

    @Query(value = "select * FROM good where good.goodid IN (SELECT cart.goodid FROM  cart where cart.userid=?1)" ,nativeQuery = true)
    List<Good> queryGood( int userid);

}
