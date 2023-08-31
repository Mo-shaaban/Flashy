package com.shaaban.Flashy.controller;
import com.shaaban.Flashy.UserWords;
import com.shaaban.Flashy.service.UserWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("userWords")
public class UserWordsController {
    @Autowired
    UserWordsService userWordsService;
    @PostMapping("learned/{userId}/{wordId}")
    public String add(@PathVariable int userId, @PathVariable int wordId) {
        userWordsService.add(userId, wordId);
        return "success";
    }


}
