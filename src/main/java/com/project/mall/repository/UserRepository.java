package com.project.mall.repository;

import com.project.mall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUserid(Integer id);
    public User findByUsername(String username);

    @Override
   public  <S extends User> S save(S s);
}
