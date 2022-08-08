package com.example.playground.controller;

import com.example.playground.pojo.PlayGround;
import com.example.playground.service.MemberService;
import com.example.playground.service.PlayGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlayGroundController {
    private PlayGroundService playGroundService;

    @Autowired
    public PlayGroundController(PlayGroundService playGroundService) {
        this.playGroundService = playGroundService;
    }

    @GetMapping("/playground")
    public String playgroundHome(Model model) {
        List<PlayGround> playGroundList = playGroundService.getPlaygroundList("哈尔滨工业大学");
        model.addAttribute("playgroundList", playGroundList);
        return "/playground/playground";
    }


}
