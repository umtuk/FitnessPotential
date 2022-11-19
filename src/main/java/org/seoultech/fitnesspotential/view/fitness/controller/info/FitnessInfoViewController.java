package org.seoultech.fitnesspotential.view.fitness.controller.info;

import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getFitnessInfosView(@PageableDefault() Pageable pageable, ModelMap model){
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
        return new ModelAndView("redirect:/fitness/info/submit/infoCreate/" + fitnessInfo.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putFitnessDiary(@ModelAttribute FitnessInfoPutRequest fitnessInfoPutRequest, @PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.putFitnessInfo(fitnessInfoPutRequest, id);
        return new ModelAndView("redirect:/fitness/info/submit/infoUpdate/" + fitnessInfo.getId(), model);
    }
}
