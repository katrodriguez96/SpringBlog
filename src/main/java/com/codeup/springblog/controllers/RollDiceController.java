package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }
    @GetMapping("/roll-dice/{n}")
    public String rollDiceGuess(@PathVariable int n, Model model){
        model.addAttribute("guess", n);
        int random = (int) (Math.random() * (6 - 1 + 1)) + 1;
        model.addAttribute("random", random);
        boolean correctGuess = n == random;
        if (correctGuess){
            model.addAttribute("correctGuess", correctGuess);
        } else {
            boolean incorrect = true;
            model.addAttribute("incorrect", incorrect);
        }
        return "roll-dice";
    }
}
