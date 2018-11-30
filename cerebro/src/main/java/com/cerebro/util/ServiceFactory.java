package com.cerebro.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cerebro.model.ApacheKafkaDefinition;
import com.cerebro.model.CoreJavaDefinition;
import com.cerebro.model.Definition;
import com.cerebro.model.GroovyDefinition;
import com.cerebro.model.JenkinsDefinition;
import com.cerebro.model.MavenDefinition;
import com.cerebro.repository.ApacheKafkaDefinitionRepository;
import com.cerebro.repository.CoreJavaDefinitionJpaRepository;
import com.cerebro.repository.GroovyDefinitionRepository;
import com.cerebro.repository.JenkinsDefinitionRepository;
import com.cerebro.repository.MavenDefinitionRepository;

/**
 * Factory class to get service based definition type
 * @author Avinash Babu Donthu - 19 Feb 2017
 *
 */
@Component(value = "serviceFactory")
public class ServiceFactory {

    @Autowired
    @Qualifier("coreJavaDefinitionRepository")
    private CoreJavaDefinitionJpaRepository coreJavaDefinitionJpaRepository;

    @Autowired
    @Qualifier("apacheKafkaDefinitionRepository")
    private ApacheKafkaDefinitionRepository apacheKafkaDefinitionRepository;

    @Autowired
    @Qualifier("groovyDefinitionRepository")
    private GroovyDefinitionRepository groovyDefinitionRepository;

    @Autowired
    @Qualifier("mavenDefinitionRepository")
    private MavenDefinitionRepository mavenDefinitionRepository;

    @Autowired
    @Qualifier("jenkinsDefinitionRepository")
    private JenkinsDefinitionRepository jenkinsDefinitionRepository;

    private Map<String, Object> entityRepositoryMap = new HashMap<>();

    public Map<String, Object> getDomainAndRepository(String definitionType, Definition definition) {
	switch (definitionType) {
	case Constants.CORE_JAVA:
	    entityRepositoryMap.put(Constants.REPOSITORY, coreJavaDefinitionJpaRepository);
	    if (null != definition) {
		CoreJavaDefinition coreJavaDefinition = new CoreJavaDefinition();
		BeanUtils.copyProperties(definition, coreJavaDefinition);
		coreJavaDefinition.setDetails(coreJavaDefinition.getDetails().replaceAll(Constants.NEW_LINE_CHAR, Constants.BR_TAG));
		entityRepositoryMap.put(Constants.ENTITY, coreJavaDefinition);
	    }
	    break;
	case Constants.APACHE_KAFKA:
	    entityRepositoryMap.put(Constants.REPOSITORY, apacheKafkaDefinitionRepository);
	    if (null != definition) {
		ApacheKafkaDefinition apacheKafkaDefinition = new ApacheKafkaDefinition();
		BeanUtils.copyProperties(definition, apacheKafkaDefinition);
		apacheKafkaDefinition.setDetails(apacheKafkaDefinition.getDetails().replaceAll(Constants.NEW_LINE_CHAR, Constants.BR_TAG));
		entityRepositoryMap.put(Constants.ENTITY, apacheKafkaDefinition);
	    }
	    break;
	case Constants.GROOVY:
	    entityRepositoryMap.put(Constants.REPOSITORY, groovyDefinitionRepository);
	    if (null != definition) {
		GroovyDefinition groovyDefinition = new GroovyDefinition();
		BeanUtils.copyProperties(definition, groovyDefinition);
		groovyDefinition.setDetails(groovyDefinition.getDetails().replaceAll(Constants.NEW_LINE_CHAR, Constants.BR_TAG));
		entityRepositoryMap.put(Constants.ENTITY, groovyDefinition);
	    }
	    break;
	case Constants.MAVEN:
	    entityRepositoryMap.put(Constants.REPOSITORY, mavenDefinitionRepository);
	    if (null != definition) {
		MavenDefinition mavenDefinition = new MavenDefinition();
		BeanUtils.copyProperties(definition, mavenDefinition);
		mavenDefinition.setDetails(mavenDefinition.getDetails().replaceAll(Constants.NEW_LINE_CHAR, Constants.BR_TAG));
		entityRepositoryMap.put(Constants.ENTITY, mavenDefinition);
	    }
	    break;
	case Constants.JENKINS:
	    entityRepositoryMap.put(Constants.REPOSITORY, jenkinsDefinitionRepository);
	    if (null != definition) {
		JenkinsDefinition jenkinsDefinition = new JenkinsDefinition();
		BeanUtils.copyProperties(definition, jenkinsDefinition);
		jenkinsDefinition.setDetails(jenkinsDefinition.getDetails().replaceAll(Constants.NEW_LINE_CHAR, Constants.BR_TAG));
		entityRepositoryMap.put(Constants.ENTITY, jenkinsDefinition);
	    }
	    break;
	}
	return entityRepositoryMap;
    }

    public List<Definition> getDefinitions(List<Object> definitions) {
	List<Definition> defs = definitions.stream().map(def -> {
	    Definition definition = new Definition();
	    BeanUtils.copyProperties(def, definition);
	    return definition;
	}).collect(Collectors.toList());

	return defs;
    }
}