package com.portal.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.exam.Category;
import com.portal.app.entity.exam.Quiz;

public interface IQuizRepository extends JpaRepository<Quiz, Long> {
  public List<Quiz> findBycategory(Category category);
  public List<Quiz> findByActive(Boolean active);
  public List<Quiz> findByCategoryAndActive(Category c,Boolean active);
}

