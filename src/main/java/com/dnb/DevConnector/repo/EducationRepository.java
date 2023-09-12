package com.dnb.DevConnector.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dnb.DevConnector.dto.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, String> {

}
