package com.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.app.entity.Album;


public interface IAlbumRepository extends JpaRepository<Album, Long>   {

}
