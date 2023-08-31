package com.shaaban.Flashy.dao;
import com.shaaban.Flashy.UserWords;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
@Repository
public interface UserWordsDao extends JpaRepository<UserWords, Integer> {

}