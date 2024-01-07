package demoday03.demo.controller;

import demoday03.demo.database.PersonDB;
import demoday03.demo.model.Person;
import demoday03.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller

public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public String getHome (){
        return "index";
    }
    @GetMapping("/person/getAll")
    public String getAll (Model model){
        model.addAttribute("people" ,personService.getAllPerson());
        return "getAll";
    }
    @GetMapping("/sortPeopleByFullName")
    public String sortPeopleByFullName (Model model){
        model.addAttribute("namePerson" , personService.sortPeopleByFullName());
        return "sortPeopleByFullName";
    }
    @GetMapping("/getSortedJobs")
    public String getSortedJobs (Model model){
        model.addAttribute("Job" , personService.getSortedJobsAZ());
        return "getSortedJobs";
    }
    @GetMapping("/getSortedCities")
    public String getSortedCities (Model model){
        model.addAttribute("citis" , personService.getSortedCities());
        return "getSortedCities";
    }

    @GetMapping("/groupPeopleByCity")
    public String groupPeopleByCity (Model model){
        model.addAttribute("groupByCity",personService.groupPeopleByCity());
        return "groupPeopleByCity";
    }
    @GetMapping("/groupJobByCount")
    public String groupJobByCount (Model model){
        model.addAttribute("groupJobByCount",personService.groupJobByCount());
        return "groupJobByCount";
    }
    @GetMapping("/aboveAverageSalary")
    public String aboveAverageSalary (Model model){
        model.addAttribute("aboveAverageSalary",personService.aboveAverageSalary());
        return "aboveAverageSalary";
    }
    @GetMapping("/longestName")
    public String longestName (Model model){
        model.addAttribute("longestName",personService.getLongestName());
        return "longestName";
    }



}
