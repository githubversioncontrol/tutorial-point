package com.cerebro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.cerebro.model.ApacheKafkaDefinition;

@Repository(value = "apacheKafkaDefinitionRepository")
@RepositoryRestResource(collectionResourceRel = "definitionsList", path = "/apacheKafkaDefs")
public interface ApacheKafkaDefinitionRepository extends JpaRepository<ApacheKafkaDefinition, Long> {

}
