package io.satori.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.satori.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
