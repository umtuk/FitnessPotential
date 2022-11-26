package org.seoultech.fitnesspotential.view.user.controller;

import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UesrViewController {

    @GetMapping("/my")
    public ModelAndView getUserInfo(@SessionAttribute User user, ModelMap model) {
        model.addAttribute("user", user);
        return new ModelAndView("user/userView", model);
    }
}
