package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.MockitoDefinition;

@Repository("mockitoDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/mockitoDefs")
public interface MockitoDefinitionRepository extends JpaRepository<MockitoDefinition, Long> {

}
