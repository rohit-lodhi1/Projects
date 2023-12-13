package com.portal.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.app.entity.exam.Category;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

}
