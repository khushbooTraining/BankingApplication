package com.khushboo.rest.webservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDetailRepository extends JpaRepository<Subject,Integer>{

}
