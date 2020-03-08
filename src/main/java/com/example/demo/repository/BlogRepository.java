package com.example.demo.repository;

import com.example.demo.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Blog findOneById(int blogId);

    List<Blog> findByTitleContainingOrContentContaining(String term, String searchTerm);
}
