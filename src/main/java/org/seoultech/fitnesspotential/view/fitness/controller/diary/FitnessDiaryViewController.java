package org.seoultech.fitnesspotential.view.fitness.controller.diary;


import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.diary.FitnessDiaryResponse;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessDiary;
import org.seoultech.fitnesspotential.domain.fitness.service.*;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fitness/diary")
public class FitnessDiaryViewController {

    private final FitnessDiaryService fitnessDiaryService;

    public FitnessDiaryViewController(FitnessDiaryService fitnessDiaryService) {
        this.fitnessDiaryService = fitnessDiaryService;
    }

    @GetMapping
    public ModelAndView getDefaultFitnessDiaryView(@SessionAttribute User user, ModelMap model){
        return new ModelAndView("forward:/fitness/diary/search?page=0&size=10", model);
    }

    @GetMapping("/search")
    public ModelAndView getFitnessDiariesView(@PageableDefault() Pageable pageable, @SessionAttribute User user, ModelMap model){
        return new ModelAndView("fitness/diary/submit/searchView", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getFitnessDiaryView(@PathVariable Long id, @SessionAttribute User user, ModelMap model){
        FitnessDiaryResponse fitnessDiary = fitnessDiaryService.getFitnessDiary(id);
        model.addAttribute("fitnessDiary", fitnessDiary);
        return new ModelAndView("fitness/diary/submit/indexView", model);
    }

    @PostMapping
    public ModelAndView postFitnessDiary(@ModelAttribute FitnessDiaryPostRequest fitnessDiaryPostRequest, @SessionAttribute User user, ModelMap model){
        FitnessDiaryResponse fitnessDiary = fitnessDiaryService.postFitnessDiary(fitnessDiaryPostRequest, user.getId());
        return new ModelAndView("redirect:/fitness/diary/" + fitnessDiary.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putFitnessDiary(@ModelAttribute FitnessDiaryPutRequest fitnessDiaryPutRequest, @PathVariable Long id, @SessionAttribute User user, ModelMap model){
        FitnessDiaryResponse fitnessDiary = fitnessDiaryService.putFitnessDiary(fitnessDiaryPutRequest, id);
        return new ModelAndView("redirect:/fitness/diary/" + fitnessDiary.getId(), model);
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteFitnessDiary(@PathVariable Long id, @SessionAttribute User user, ModelMap model){
        fitnessDiaryService.deleteFitnessDiary(id);
        return new ModelAndView("redirect:/fitness/diary", model);
    }

    @GetMapping("/create")
    public ModelAndView getFitnessDiaryCreateView(@SessionAttribute User user, ModelMap model){
        return new ModelAndView("/fitness/diary/submit/diaryCreate", model);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getFitnessDiaryUpdateView(@SessionAttribute User user, @PathVariable Long id, ModelMap model){
        FitnessDiaryResponse fitnessDiary = fitnessDiaryService.getFitnessDiary(id);
        model.addAttribute("fitnessDiary", fitnessDiary);
        return new ModelAndView("/fitness/diary/submit/diaryUpdate", model);
    }
}
