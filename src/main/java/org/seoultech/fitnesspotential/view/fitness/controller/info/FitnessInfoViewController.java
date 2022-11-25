package org.seoultech.fitnesspotential.view.fitness.controller.info;

import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/fitness/info")
public class FitnessInfoViewController {

    private final FitnessInfoService fitnessInfoService;

    public FitnessInfoViewController(FitnessInfoService fitnessInfoService) {
        this.fitnessInfoService = fitnessInfoService;
    }

    @GetMapping
    public ModelAndView getDefaultFitnessInfoView(ModelMap model){
        return new ModelAndView("forward:/fitness/info/search?page=0&size=10", model);
    }

    @GetMapping("/search")
    public ModelAndView getFitnessInfosView(@RequestParam Set<String> majorCategory, @RequestParam Set<String> detailedCategory, ModelMap model){
        Iterable<FitnessInfo> fitnessInfos = fitnessInfoService.getFitnessInfos(majorCategory, detailedCategory);
        model.addAttribute("fitnessInfos", fitnessInfos);
        return new ModelAndView("fitness/info/submit/searchView", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getFitnessInfoView(@PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        model.addAttribute("fitnessInfo", fitnessInfo);
        return new ModelAndView("fitness/info/submit/indexView", model);
    }
    @PostMapping
    public ModelAndView postFitnessDiary(@ModelAttribute FitnessInfoPostRequest fitnessInfoPostRequest, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.postFitnessInfo(fitnessInfoPostRequest, 0L);
        return new ModelAndView("redirect:/fitness/info/" + fitnessInfo.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putFitnessDiary(@ModelAttribute FitnessInfoPutRequest fitnessInfoPutRequest, @PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.putFitnessInfo(fitnessInfoPutRequest, id);
        return new ModelAndView("redirect:/fitness/info/" + fitnessInfo.getId(), model);
    }

    @GetMapping("/create")
    public ModelAndView getFitnessInfoCreateView(@SessionAttribute User user, ModelMap model){
        return new ModelAndView("/fitness/info/submit/infoCreate", model);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getFitnessInfoUpdateView(@SessionAttribute User user, @PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        model.addAttribute("fitnessInfo", fitnessInfo);
        return new ModelAndView("/fitness/info/submit/infoUpdate", model);
    }
}
