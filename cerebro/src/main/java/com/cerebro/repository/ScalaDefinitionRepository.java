package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.ScalaDefinition;

@Repository("scalaDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/scalaDefs")
public interface ScalaDefinitionRepository extends JpaRepository<ScalaDefinition, Long> {

}
