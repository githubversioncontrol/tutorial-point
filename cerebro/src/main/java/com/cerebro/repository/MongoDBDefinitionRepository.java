package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.MongoDBDefinition;

@Repository("mongoDBDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/mongodbDefs")
public interface MongoDBDefinitionRepository extends JpaRepository<MongoDBDefinition, Long> {

}
