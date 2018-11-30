package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.JenkinsDefinition;

@Repository("jenkinsDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/jenkinsDefs")
public interface JenkinsDefinitionRepository extends JpaRepository<JenkinsDefinition, Long> {

}
