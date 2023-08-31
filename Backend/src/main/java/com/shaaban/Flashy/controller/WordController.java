package com.shaaban.Flashy.controller;
import com.shaaban.Flashy.Word;
import com.shaaban.Flashy.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("word")
public class WordController {
    @Autowired
    WordService wordService;
    @GetMapping("allWords")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }
    @GetMapping("getWords")
    public List<Word> findTop50Words() {
        return wordService.findTop50Words();
    }
    @GetMapping("learnedWords/{userId}")
    public List<Word> findLearnedWords(@PathVariable int userId) {
        return wordService.findLearnedWordsByUser(userId);
    }


    @GetMapping("newWords/{userId}")
    public List<Word> findWordsToLearnByUser(@PathVariable int userId) {
        return wordService.findWordsToLearnByUser(userId);
    }

}
