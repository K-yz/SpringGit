package org.example.entryapi.controller;

import org.example.entryapi.entity.Entry;
import org.example.entryapi.service.EntryService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
@RequestMapping("/entry")
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/list")
    public String listEntry(Model model) {
        List<Entry> entryList = entryService.findAll();
        model.addAttribute("menus", entryList);
        return "entry/list-entry";
    }

    @GetMapping("/showaddmenu")
    public String showEntry(Model model) {
        Entry theEntry = new Entry();
        model.addAttribute("entry", theEntry);
        return "entry/show-add-entry";
    }

    @DeleteMapping("/delete")
    public String deleteEntry(@RequestParam("id") int theEntryId) {
        entryService.deleteById(theEntryId);
        return "redirect:list";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("entryId") int theId, Model model) {
        Entry theEntry = entryService.findById(theId);
        model.addAttribute("entry", theEntry);
        return "entry/show-add-entry";
    }

    @PostMapping("/save")
    public String saveEntry(@ModelAttribute("entry") Entry theEntry) {
        entryService.save(theEntry);
        return "redirect:list";
    }
}
