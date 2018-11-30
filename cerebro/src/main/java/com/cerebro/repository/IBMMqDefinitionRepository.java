package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.IBMMqDefinition;

@Repository(value = "ibmMqDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/ibmMqDefs")
public interface IBMMqDefinitionRepository extends JpaRepository<IBMMqDefinition, Long> {

}
