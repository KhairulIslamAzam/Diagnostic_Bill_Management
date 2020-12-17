package com.project.dcbms.controllers;

import com.project.dcbms.models.Test;
import com.project.dcbms.models.TestTypeSetup;
import com.project.dcbms.services.TestService;
import com.project.dcbms.services.TestTypeSetupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/testsetup")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private TestTypeSetupService testTypeSetupService;
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @GetMapping("/list")
    public String getListOfTest(Model model){
        logger.info("page refreshed and load all the data");
        List<Test> testList = testService.findAll();
        model.addAttribute("testList", testList);

        List<TestTypeSetup> testTypeSetupList = testTypeSetupService.findAll();
        model.addAttribute("testTypeList", testTypeSetupList);

        return "index";
    }

    @GetMapping("/showFormForAdd")
    public String testType(Model model){
        logger.info("--test form initialized--");
        Test test= new Test();
        model.addAttribute("test", test);

        return "test_form_setup";
    }

    @PostMapping("/save")
    public String saveTestType(@ModelAttribute("test") TestTypeSetup testTypeSetup){
        testTypeSetupService.save(testTypeSetup);
        logger.info("test type save successfully");
        return "redirect:/testsetup/list";
    }

    @GetMapping("/update")
    public String updateTestType(@RequestParam("testId") int id, Model model){
        Test test= testService.findById(id).get();
        model.addAttribute("test", test);
        logger.info("test type update successfully");
        return "redirect:/testsetup/showFormForAdd";
    }

    @GetMapping("/delete")
    public String deleteTestType(@RequestParam("testId") int id){
        testService.deleteById(id);
        logger.info("test type delete successfully");
        return "redirect:/testsetup/list";
    }
}
