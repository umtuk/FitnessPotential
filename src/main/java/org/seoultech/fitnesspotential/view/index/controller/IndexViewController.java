package org.seoultech.fitnesspotential.view.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexViewController {

    @GetMapping
    public String getIndexView() {
        return "index";
    }
}
