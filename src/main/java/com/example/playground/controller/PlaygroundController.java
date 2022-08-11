package com.example.playground.controller;

import com.example.playground.pojo.playgroundpojo.Playground;
import com.example.playground.pojo.playgroundpojo.SoccerField;
import com.example.playground.pojo.playgroundpojo.SoccerFieldDto;
import com.example.playground.service.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlaygroundController {
    private PlaygroundService playgroundService;

    @Autowired
    public PlaygroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }


    @GetMapping("/playground/soccerRegister")
    public String registerSoccerFieldForm(Model model) {
        model.addAttribute("playground", SoccerFieldDto.builder().build());
        return "playground/soccerRegister";
    }

    @PostMapping("/playground/soccerRegister")
    public String registerSoccerField(SoccerFieldDto soccerFieldDto) {
        playgroundService.register(soccerFieldDto.toEntity());
        return "redirect:/";
    }

    @GetMapping("/playground/select")
    public String selectField(SoccerFieldDto soccerFieldDto) {
        return "playground/select";
    }


}
