package com.shaaban.Flashy.service;

import com.shaaban.Flashy.Word;
import com.shaaban.Flashy.dao.WordDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService {
    @Autowired
    WordDao wordDao;
    public List<Word> getAllWords() {
        return wordDao.findAll();
    }

    public List<Word> findTop50Words() {
        return wordDao.findTop50Words();
    }


    public List<Word> findLearnedWordsByUser(int userId) {
        return wordDao.findLearnedWordsByUser(userId);
    }

    public List<Word> findWordsToLearnByUser(int userId) {
        return wordDao.findWordsToLearnByUser(userId);
    }



}
