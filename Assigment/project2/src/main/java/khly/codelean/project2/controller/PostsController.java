package khly.codelean.project2.controller;


import khly.codelean.project2.dao.PostsRepository;
import khly.codelean.project2.entity.Posts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostsController {

    private final PostsRepository postsRepository;

    public PostsController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @GetMapping("/list")
    public String listPosts(Model model) {
        model.addAttribute("posts", postsRepository.findAll());
        return "admin/posts/list";
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Posts());
        return "admin/posts/form";
    }

    @PostMapping
    public String savePost(@ModelAttribute Posts post) {
        postsRepository.save(post);
        return "redirect:/posts/list";
    }

    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Post Id:" + id)));
        return "admin/posts/form";
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        postsRepository.deleteById(id);
        return "redirect:/posts";
    }
}