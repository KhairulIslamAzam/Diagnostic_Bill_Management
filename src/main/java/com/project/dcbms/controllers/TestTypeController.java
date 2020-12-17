package com.project.dcbms.controllers;

import com.project.dcbms.models.TestTypeSetup;
import com.project.dcbms.services.TestTypeSetupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/testtypesetup")
public class TestTypeController {

    private TestTypeSetupService testTypeSetupService;
    private static Logger logger = LoggerFactory.getLogger(TestTypeSetup.class);

    @Autowired
    public TestTypeController(TestTypeSetupService testTypeSetupService) {
        this.testTypeSetupService = testTypeSetupService;
    }

    @GetMapping("/list")
    public String listOfTestType(Model model){
        logger.info("page refreshed");
        List<TestTypeSetup> testTypeList = testTypeSetupService.findAll();
        model.addAttribute("testTypeList", testTypeList);
        return "test_type_setup";
    }

    @GetMapping("/showFormForAdd")
    public String testType(Model model){
        logger.info("--test form initialized--");
        TestTypeSetup testType= new TestTypeSetup();
        model.addAttribute("testtype", testType);

        return "test_type_form";
    }

    @PostMapping("/save")
    public String saveTestType(@ModelAttribute("testtype") TestTypeSetup testTypeSetup){
        testTypeSetupService.save(testTypeSetup);
        logger.info("test type save successfully");
        return "redirect:/testtypesetup/list";
    }

    @GetMapping("/update")
    public String updateTestType(@RequestParam("testTypeId") int id, Model model){
        TestTypeSetup testTypeSetup = testTypeSetupService.findById(id);
        model.addAttribute("testtype", testTypeSetup);
        logger.info("test type update successfully");
        return "redirect:/testtypesetup/showFormForAdd";
    }

    @GetMapping("/delete")
    public String deleteTestType(@RequestParam("testTypeId") int id){
        testTypeSetupService.deleteById(id);
        logger.info("test type delete successfully");
        return "redirect:/testtypesetup/list";
    }
}
