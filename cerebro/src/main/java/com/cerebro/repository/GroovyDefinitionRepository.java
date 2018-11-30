package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.GroovyDefinition;

@Repository("groovyDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/groovyDefs")
public interface GroovyDefinitionRepository extends JpaRepository<GroovyDefinition, Long> {

}
