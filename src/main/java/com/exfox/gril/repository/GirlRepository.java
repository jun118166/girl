package com.exfox.gril.repository;

import com.exfox.gril.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {

     List<Girl> findByAge(Integer age);
}
