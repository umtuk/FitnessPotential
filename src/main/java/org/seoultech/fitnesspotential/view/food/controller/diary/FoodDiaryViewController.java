package org.seoultech.fitnesspotential.view.food.controller.diary;

import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPostRequest;
import org.seoultech.fitnesspotential.domain.food.dto.FoodDiaryPutRequest;
import org.seoultech.fitnesspotential.domain.food.entity.FoodDiary;
import org.seoultech.fitnesspotential.domain.food.service.FoodDiaryService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/food/diary")
public class FoodDiaryViewController {

    private final FoodDiaryService foodDiaryService;

    public FoodDiaryViewController(FoodDiaryService foodDiaryService) {
        this.foodDiaryService = foodDiaryService;
    }

    @GetMapping
    public ModelAndView getDefaultFoodDiaryView(@SessionAttribute User user, ModelMap model){
        return new ModelAndView("forward:/food/diary/search?page=0&size=10", model);
    }

    @GetMapping("/search")
    public ModelAndView getFoodDiariesView(@PageableDefault()Pageable pageable, @SessionAttribute User user, ModelMap model){
        Page<FoodDiary> foodDiaries = foodDiaryService.getFoodDiaries(pageable);
        model.addAttribute("foodDiaries", foodDiaries);
        return new ModelAndView("food/diary/searchView", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getFoodDiaryView(@PathVariable Long id, @SessionAttribute User user, ModelMap model){
        FoodDiary foodDiary = foodDiaryService.getFoodDiary(id);
        model.addAttribute("foodDiary", foodDiary);
        return new ModelAndView("food/diary/indexView", model);
    }

    @PostMapping
    public ModelAndView postFoodDiary(@ModelAttribute FoodDiaryPostRequest foodDiaryPostRequest, @SessionAttribute User user, ModelMap model){
        FoodDiary foodDiary = foodDiaryService.postFoodDiary(foodDiaryPostRequest, user.getId());
        return new ModelAndView("redirect:/food/diary/" + foodDiary.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putFoodDiary(@ModelAttribute FoodDiaryPutRequest foodDiaryPutRequest, @PathVariable Long id, @SessionAttribute User user, ModelMap model){
        FoodDiary foodDiary = foodDiaryService.putFoodDiary(foodDiaryPutRequest, id);
        return new ModelAndView("redirect:/food/diary/" + foodDiary.getId(), model);
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteFoodDiary(@PathVariable Long id, @SessionAttribute User user, ModelMap model){
        foodDiaryService.deleteFoodDiary(id);
        return new ModelAndView("redirect:/food/diary", model);
    }

    @GetMapping("/create")
    public ModelAndView getFoodDiaryCreateView(@SessionAttribute User user, ModelMap model){
        return new ModelAndView("/food/diary/submit/diaryCreate", model);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getFoodDiaryUpdateView(@SessionAttribute User user, @PathVariable Long id, ModelMap model){
        FoodDiary foodDiary = foodDiaryService.getFoodDiary(id);
        model.addAttribute("foodDiary", foodDiary);
        return new ModelAndView("/food/diary/submit/diaryUpdate", model);
    }
}
