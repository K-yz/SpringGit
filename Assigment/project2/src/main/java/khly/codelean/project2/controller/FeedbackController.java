package khly.codelean.project2.controller;


import khly.codelean.project2.dao.FeedbackRepository;
import khly.codelean.project2.entity.Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @GetMapping
    public String listFeedback(Model model) {
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        return "feedback/list";
    }

    @GetMapping("/new")
    public String newFeedback(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback/form";
    }

    @GetMapping("/edit/{id}")
    public String editFeedback(@PathVariable("id") Long id, Model model) {
        model.addAttribute("feedback", feedbackRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid feedback Id:" + id)));
        return "feedback/form";
    }

    @PostMapping
    public String saveFeedback(@ModelAttribute Feedback feedback) {
        feedbackRepository.save(feedback);
        return "redirect:/feedback";
    }

    @GetMapping("/delete/{id}")
    public String deleteFeedback(@PathVariable("id") Long id) {
        feedbackRepository.deleteById(id);
        return "redirect:/feedback";
    }
}
