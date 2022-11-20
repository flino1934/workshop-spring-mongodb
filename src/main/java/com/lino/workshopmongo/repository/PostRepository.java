package com.lino.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lino.workshopmongo.entity.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
