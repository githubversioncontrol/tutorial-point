package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.ConcurrencyDefinition;

@Repository("concurrencyDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/concurrencyDefs")
public interface ConcurrencyDefinitionRepository extends JpaRepository<ConcurrencyDefinition, Long> {

}
