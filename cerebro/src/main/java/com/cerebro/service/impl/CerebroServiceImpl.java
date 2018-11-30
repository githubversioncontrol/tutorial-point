package com.cerebro.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cerebro.model.Definition;
import com.cerebro.service.CerebroService;
import com.cerebro.util.Constants;
import com.cerebro.util.ServiceFactory;

@SuppressWarnings({ "unchecked" })
@Service("cerebroServiceImpl")
public class CerebroServiceImpl implements CerebroService {

    @Autowired
    @Qualifier("serviceFactory")
    private ServiceFactory serviceFactory;

    @Override
    public void saveDefinitions(List<Definition> definitions, String definitionType) {
	for (Definition definition : definitions) {
	    Map<String, Object> map = serviceFactory.getDomainAndRepository(definitionType, definition);
	    JpaRepository<Object, Long> repository = (JpaRepository<Object, Long>) map.get(Constants.REPOSITORY);
	    Object object = map.get(Constants.ENTITY);
	    repository.save(object);
	}
    }
}