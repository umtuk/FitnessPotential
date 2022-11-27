package org.seoultech.fitnesspotential.view.fitness.controller.info;

import lombok.extern.slf4j.Slf4j;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.info.FitnessInfoPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfo;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessInfoSummary;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoService;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessInfoSummaryService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/fitness/info")
public class FitnessInfoViewController {

    private final FitnessInfoService fitnessInfoService;
    private final FitnessInfoSummaryService fitnessInfoSummaryService;

    @Autowired
    public FitnessInfoViewController(FitnessInfoService fitnessInfoService, FitnessInfoSummaryService fitnessInfoSummaryService) {
        this.fitnessInfoService = fitnessInfoService;
        this.fitnessInfoSummaryService = fitnessInfoSummaryService;
    }

    @GetMapping
    public ModelAndView getDefaultFitnessInfoView(ModelMap model) {
        return new ModelAndView("forward:/fitness/info/search?page=0&size=10&detailedCategory=전체&majorCategory=전체", model);
    }

    @GetMapping("/selection")
    public ModelAndView getDefaultFitnessInfoSelectionView(@RequestParam Long fitnessRoutineId, ModelMap model) {
        return new ModelAndView("forward:/fitness/info/search?page=0&size=10&detailedCategory=전체&majorCategory=전체&fitnessUnitId=" + fitnessRoutineId, model);
    }

    @GetMapping("/search")
    public ModelAndView getFitnessInfosView(@RequestParam String majorCategory, @RequestParam String detailedCategory, @RequestParam(required = false) Long fitnessRoutineId, @PageableDefault Pageable pageable, ModelMap model){
        Page<FitnessInfoSummary> fitnessInfos = fitnessInfoSummaryService.getFitnessInfoSummaries(majorCategory, detailedCategory, pageable);
        model.addAttribute("fitnessInfos", fitnessInfos);
        model.addAttribute("majorCategory", majorCategory);
        model.addAttribute("detailedCategory", detailedCategory);
        model.addAttribute("fitnessRoutineId", fitnessRoutineId);
        return new ModelAndView("fitness/info/searchView", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getFitnessInfoView(@PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        model.addAttribute("fitnessInfo", fitnessInfo);
        return new ModelAndView("fitness/info/indexView", model);
    }
    @PostMapping
    public ModelAndView postFitnessDiary(@ModelAttribute FitnessInfoPostRequest fitnessInfoPostRequest, @SessionAttribute User user, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.postFitnessInfo(fitnessInfoPostRequest, user.getId());
        return new ModelAndView("redirect:/fitness/info/" + fitnessInfo.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putFitnessDiary(@ModelAttribute FitnessInfoPutRequest fitnessInfoPutRequest, @PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.putFitnessInfo(fitnessInfoPutRequest, id);
        return new ModelAndView("redirect:/fitness/info/" + fitnessInfo.getId(), model);
    }

    @GetMapping("/create")
    public ModelAndView getFitnessInfoCreateView(@SessionAttribute User user, ModelMap model){
        return new ModelAndView("/fitness/info/submit/infoCreateView", model);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getFitnessInfoUpdateView(@SessionAttribute User user, @PathVariable Long id, ModelMap model){
        FitnessInfo fitnessInfo = fitnessInfoService.getFitnessInfo(id);
        model.addAttribute("fitnessInfo", fitnessInfo);
        return new ModelAndView("/fitness/info/submit/infoUpdateView", model);
    }
}
