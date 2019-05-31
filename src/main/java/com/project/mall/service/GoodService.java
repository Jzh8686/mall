package com.project.mall.service;

import com.project.mall.entity.Good;
import com.project.mall.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    @Autowired
    GoodRepository goodRepository;
    public Good getGoodById(int id){
        return goodRepository.findDistinctByGoodid(id);
    }
    public Good insertGood(Good good){
        return goodRepository.save(good);
    }
    public List<Good> fingAll(){
        return goodRepository.findAll();
    }
    public List<Good> findByUserId(int userid){return goodRepository.queryGood(userid);}
}
