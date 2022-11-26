package org.seoultech.fitnesspotential.view.fitness.controller.routine;

import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.routine.FitnessRoutinePutRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPostRequest;
import org.seoultech.fitnesspotential.domain.fitness.dto.unit.FitnessUnitPutRequest;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessRoutine;
import org.seoultech.fitnesspotential.domain.fitness.entity.FitnessUnit;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessRoutineService;
import org.seoultech.fitnesspotential.domain.fitness.service.FitnessUnitService;
import org.seoultech.fitnesspotential.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fitness/routine")
public class FitnessRoutineViewController {

    private final FitnessRoutineService fitnessRoutineService;

    private final FitnessUnitService fitnessUnitService;

    @Autowired
    public FitnessRoutineViewController(FitnessRoutineService fitnessRoutineService, FitnessUnitService fitnessUnitService) {
        this.fitnessRoutineService = fitnessRoutineService;
        this.fitnessUnitService = fitnessUnitService;
    }


    @GetMapping
    public ModelAndView getDefaultFitnessRoutineView(ModelMap model){
        return new ModelAndView("forward:/fitness/routine/search", model);
    }

    @GetMapping("/search")
    public ModelAndView getFitnessRoutinesView(@SessionAttribute User user, ModelMap model){
        Iterable<FitnessRoutine> fitnessRoutines = fitnessRoutineService.getFitnessRoutines(user.getId());
        model.addAttribute("fitnessRoutines", fitnessRoutines);
        return new ModelAndView("fitness/routine/searchView", model);
    }

    @GetMapping("/{id}")
    public ModelAndView getFitnessRoutineView(@PathVariable Long id, ModelMap model){
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(id);
        model.addAttribute("fitnessRoutine", fitnessRoutine);
        return new ModelAndView("fitness/routine/indexView", model);
    }

    @PostMapping
    public ModelAndView postFitnessRoutine(@ModelAttribute FitnessRoutinePostRequest fitnessRoutinePostRequest, ModelMap model){
        FitnessRoutine fitnessRoutine = fitnessRoutineService.postFitnessRoutine(fitnessRoutinePostRequest, 0L);
        return new ModelAndView("redirect:/fitness/routine/"+fitnessRoutine.getId(), model);
    }

    @PutMapping("/{id}")
    public ModelAndView putFitnessRoutine(@ModelAttribute FitnessRoutinePutRequest fitnessRoutinePutRequest, @PathVariable Long id, ModelMap model){
        FitnessRoutine fitnessRoutine = fitnessRoutineService.putFitnessRoutine(fitnessRoutinePutRequest, id);
        return new ModelAndView("redirect:/fitness/routine/" + fitnessRoutine.getId(), model);
    }

    @DeleteMapping("/{id}")
    public ModelAndView deleteFitnessRoutine(@PathVariable Long id, ModelMap model){
        fitnessRoutineService.deleteFitnessRoutine(id);
        return new ModelAndView("redirect:/fitness/routine", model);
    }

    @PostMapping("/unit")
    public ModelAndView postUnit(@ModelAttribute FitnessUnitPostRequest fitnessUnitPostRequest, ModelMap model){
        FitnessUnit fitnessUnit = fitnessUnitService.postFitnessUnit(fitnessUnitPostRequest);
        return new ModelAndView("redirect:/fitness/routine/" + fitnessUnit.getId(), model);
    }

    @PutMapping("/unit/update/{id}")
    public ModelAndView putUnit(@ModelAttribute FitnessUnitPutRequest fitnessUnitPutRequest, @PathVariable Long id, ModelMap model){
        FitnessUnit fitnessUnit = fitnessUnitService.putFitnessUnit(fitnessUnitPutRequest, id);
        return new ModelAndView("redirect:/fitness/routine/"+ fitnessUnit.getId(), model);
    }

    @DeleteMapping("/unit/{id}")
    public ModelAndView deleteUnit(@PathVariable Long id, ModelMap model){
        Long fitnessRoutineId = fitnessUnitService.getFitnessRoutineId(id);
        fitnessUnitService.deleteFitnessUnit(id);
        return new ModelAndView("redirect:/fitness/routine/" + fitnessRoutineId, model);
    }

    @GetMapping("/create")
    public ModelAndView getFitnessRoutineCreateView(ModelMap model){
        return new ModelAndView("/fitness/routine/submit/routineCreate", model);
    }

    @GetMapping("/update/{id}")
    public ModelAndView getFitnessRoutineUpdateView(@PathVariable Long id, ModelMap model){
        FitnessRoutine fitnessRoutine = fitnessRoutineService.getFitnessRoutine(id);
        model.addAttribute("fitnessRoutine", fitnessRoutine);
        return new ModelAndView("/fitness/routine/submit/routineUpdate", model);
    }
}
