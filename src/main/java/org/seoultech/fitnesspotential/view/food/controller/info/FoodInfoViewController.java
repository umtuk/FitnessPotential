package org.seoultech.fitnesspotential.view.food.controller.info;

import org.seoultech.fitnesspotential.domain.food.dto.FoodInfoCategoryResponse;
import org.seoultech.fitnesspotential.domain.food.entity.FoodInfo;
import org.seoultech.fitnesspotential.domain.food.entity.FoodInfoCategory;
import org.seoultech.fitnesspotential.domain.food.service.FoodInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Controller
@RequestMapping("/food/info")
public class FoodInfoViewController {

    private final FoodInfoService foodInfoService;


    public FoodInfoViewController(FoodInfoService foodInfoService) {
        this.foodInfoService = foodInfoService;
    }

    @GetMapping
    public ModelAndView getDefaultFoodInfoView(ModelMap model){
        return new ModelAndView("forward:/food/info/search?page=0&size=10", model);
    }

//    @GetMapping("/search")
//    public ModelAndView getFoodInfosView(@PageableDefault() Pageable pageable, ModelMap model){
//        Page<FoodInfo> foodInfos = foodInfoService.getFoodInfos(pageable);
//        model.addAttribute("foodInfos", foodInfos);
//        return new ModelAndView("food/info/searchView", model);
//    }

    @GetMapping("/{id}")
    public ModelAndView getFoodInfoView(@PathVariable Long id, ModelMap model){
        FoodInfo foodInfo = foodInfoService.getFoodInfo(id);
        model.addAttribute("foodInfo", foodInfo);
        return new ModelAndView("food/info/indexView", model);
    }
    @GetMapping("/search")
    public ModelAndView getFoodInfoByMajorCategoryAndDetailedCategoryView(@RequestParam String majorCategory, @RequestParam String detailedCategory, @PageableDefault() Pageable pageable, ModelMap model){
        Page<FoodInfo> foodInfos = foodInfoService.getFoodInfos(majorCategory, detailedCategory, pageable);
        FoodInfoCategoryResponse foodInfoCategory = foodInfoService.getFoodInfoCategories();
        model.addAttribute("foodInfos", foodInfos);
        model.addAttribute("majorCategory", majorCategory);
        model.addAttribute("detailedCategory", detailedCategory);
        model.addAttribute("foodInfoCategory", foodInfoCategory);
        return new ModelAndView("food/info/searchView", model);
    }
}
