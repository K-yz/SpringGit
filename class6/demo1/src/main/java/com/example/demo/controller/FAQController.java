package com.example.demo.controller;

import com.example.demo.entity.FAQ;
import com.example.demo.repository.FAQRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faq")
public class FAQController {

    private final FAQRepository faqRepository;

    public FAQController(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    @GetMapping
    public String listFAQ(Model model) {
        model.addAttribute("faqs", faqRepository.findAll());
        return "faq/list";
    }

    @GetMapping("/new")
    public String newFAQ(Model model) {
        model.addAttribute("faq", new FAQ());
        return "faq/form";
    }

    @GetMapping("/edit/{id}")
    public String editFAQ(@PathVariable("id") Long id, Model model) {
        model.addAttribute("faq", faqRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid FAQ Id:" + id)));
        return "faq/form";
    }

    @PostMapping
    public String saveFAQ(@ModelAttribute FAQ faq) {
        faqRepository.save(faq);
        return "redirect:/faq";
    }

    @GetMapping("/delete/{id}")
    public String deleteFAQ(@PathVariable("id") Long id) {
        faqRepository.deleteById(id);
        return "redirect:/faq";
    }
}
