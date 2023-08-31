package com.shaaban.Flashy.service;
import com.shaaban.Flashy.UserWords;
import com.shaaban.Flashy.dao.UserWordsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWordsService {
    @Autowired
    UserWordsDao userWordsDao;
    public void add(int userId, int wordId) {
        UserWords userWord = new UserWords();
        userWord.setWordId(wordId);
        userWord.setUserId(userId);
        userWordsDao.save(userWord);
    }
}
