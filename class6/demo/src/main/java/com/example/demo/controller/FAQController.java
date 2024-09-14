package com.example.demo.controller;

import com.example.demo.entity.FAQ;
import com.example.demo.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faqs")
public class FAQController {

    @Autowired
    private FAQRepository faqRepository;

    @GetMapping
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    @PostMapping
    public FAQ createFAQ(@RequestBody FAQ faq) {
        return faqRepository.save(faq);
    }

    @GetMapping("/{id}")
    public FAQ getFAQById(@PathVariable Long id) {
        return faqRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public FAQ updateFAQ(@PathVariable Long id, @RequestBody FAQ faqDetails) {
        FAQ faq = faqRepository.findById(id).orElse(null);
        if (faq != null) {
            faq.setName(faqDetails.getName());
            faq.setDescription(faqDetails.getDescription());  // Sửa lỗi ở đây
            return faqRepository.save(faq);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteFAQ(@PathVariable Long id) {
        faqRepository.deleteById(id);
    }
}
