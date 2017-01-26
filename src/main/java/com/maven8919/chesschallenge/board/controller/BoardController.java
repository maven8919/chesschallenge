package com.maven8919.chesschallenge.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    @RequestMapping("/board")
    public String home() {
        return "board";
    }

}