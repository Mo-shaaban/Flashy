package com.shaaban.Flashy.dao;

import com.shaaban.Flashy.Word;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface WordDao extends JpaRepository<Word, Integer> {
    @Query(value = "SELECT * FROM word LIMIT 50", nativeQuery = true)
    List<Word> findTop50Words();
    @Query(value = "SELECT w.* FROM word w INNER JOIN user_words uw ON w.id = uw.word_id WHERE uw.user_id = :userId", nativeQuery = true)
    List<Word> findLearnedWordsByUser(@Param("userId") int userId);
    @Query(value = "SELECT w.* " +
            "FROM word w " +
            "LEFT JOIN user_words uw ON w.id = uw.word_id AND uw.user_id = :userId " +
            "WHERE uw.id IS NULL " +
            "LIMIT 50", nativeQuery = true)
    List<Word> findWordsToLearnByUser(@Param("userId") int userId);
}

