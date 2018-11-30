package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.DockerDefinition;

@Repository("dockerDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/dockerDefs")
public interface DockerDefinitionRepository extends JpaRepository<DockerDefinition, Long> {

}
