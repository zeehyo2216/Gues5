package com.example.gues5.controller;


import com.example.gues5.dto.Result;
import com.example.gues5.service.CheckWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CheckWordController {
    public final CheckWordService checkWordService;
    @GetMapping("/checkword")
    public Result checkWord(@RequestParam(value = "count") int count, //used at history data
                           @RequestParam(value = "guess") String guess){
        guess = guess.toLowerCase();
        int[] checkArray = checkWordService.checkWord(guess);

        Result result = new Result();
        result.setResults(checkArray);

        return result;
    }
}
