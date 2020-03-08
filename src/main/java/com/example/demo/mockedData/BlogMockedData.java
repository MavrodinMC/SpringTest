package com.example.demo.mockedData;

import com.example.demo.domain.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogMockedData {

    private List<Blog> blogs;

    private static BlogMockedData instance = null;

    public static BlogMockedData getInstance() {
        if (instance == null) {
            instance = new BlogMockedData();
        }
        return instance;
    }

    public BlogMockedData() {

        blogs = new ArrayList<>();

        blogs.add(new Blog(1, "Primul titlu", "Continut"));

        blogs.add(new Blog(2, "Al doilea titlu", "Al doilea continut"));

        blogs.add(new Blog(3, "Al treilea titlu", "Al treilea continut"));

        blogs.add(new Blog(4, "Al patrulea titlu", "Al patrulea continut"));

        blogs.add(new Blog(5, "Al cincilea titlu", "Al saselea continut"));

    }

    // return all blogs;
    public List<Blog> fetchBlogs() {
        return blogs;
    }

    // return blog by id;
    public Blog getBlogById(int id) {
        for (Blog b : blogs) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;

    }

    //search blog by text
    public List<Blog> searchBlogs(String searchTerm) {
        List<Blog> searchedBlogs = new ArrayList<>();
        for (Blog b : blogs) {
            if (b.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    b.getContent().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedBlogs.add(b);
            }
        }
        return searchedBlogs;
    }


    // create blog
    public Blog createBlog(int id, String title, String content) {
        Blog newBlog = new Blog(id, title, content);
        blogs.add(newBlog);
        return newBlog;
    }

    // update blog;
    public Blog updateBlog(int id, String title, String content) {
        for (Blog b : blogs) {
            if (b.getId() == id) {
                int blogIndex = blogs.indexOf(b);
                b.setTitle(title);
                b.setContent(content);
                blogs.set(blogIndex, b);
                return b;

            }
        }
        return null;
    }

        // delete blog by id;
        public boolean deleteBlog ( int id){
            int blogIndex = -1;
            for (Blog b : blogs) {
                if (b.getId() == id) {
                    blogIndex = blogs.indexOf(b);
                    continue;
                }
            }
            if (blogIndex > -1) {
                blogs.remove(blogIndex);
            }
            return true;
        }
    }

