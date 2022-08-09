package com.example.playground.controller;

import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaygroundController {
    private PlaygroundService playgroundService;

    @Autowired
    public PlaygroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @GetMapping("/playground")
    public String playgroundHome(Model model) {
        //List<PlayGround> playGroundList = playGroundService.getPlaygroundList("哈尔滨工业大学");
        //model.addAttribute("playgroundList", playGroundList);
        return "/playground/playground";
    }


}
