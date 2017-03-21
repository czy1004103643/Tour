package me.luajk.tactic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TacticController {

    @RequestMapping("tactic/list")
    public ModelAndView list() {
        return new ModelAndView("tactic/list");
    }

}
