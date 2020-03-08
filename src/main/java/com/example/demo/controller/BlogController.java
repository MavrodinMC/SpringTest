package com.example.demo.controller;

import com.example.demo.domain.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blog")
    public List<Blog> index() {
        return blogRepository.findAll();
    }

    @GetMapping("/blog/{id}")
    public Blog show(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return blogRepository.findOneById(blogId);
    }

    @PostMapping("/blog/search")
    public List<Blog> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRepository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @PostMapping("/blog")
    public Blog create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String content = body.get("content");
        Blog newBlog = new Blog(title, content);
        return blogRepository.save(newBlog);
    }

    @PutMapping("/blog/{id}")
        public Blog update (@PathVariable String id, @RequestBody Map <String, String> body){
            int blogId = Integer.parseInt(id);
            String title = body.get("title");
            String content = body.get("content");
            Blog newBlog = new Blog(blogId, title, content);
            return blogRepository.save(newBlog);
        }

        @DeleteMapping("blog/{id}")
        public void delete (@PathVariable String id){
            int blogId = Integer.parseInt(id);
            blogRepository.deleteById(blogId);
        }

    }






