package com.shubham.elasticsearch.repository;

import com.shubham.elasticsearch.document.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PersonRepository extends ElasticsearchRepository<Person, Integer> {
}
