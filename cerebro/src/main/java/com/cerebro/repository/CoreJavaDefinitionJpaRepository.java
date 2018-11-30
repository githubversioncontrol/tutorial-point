package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.CoreJavaDefinition;

@Repository(value = "coreJavaDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/coreJavaDefs")
public interface CoreJavaDefinitionJpaRepository extends JpaRepository<CoreJavaDefinition, Long> {

}
