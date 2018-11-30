package com.cerebro.service;

import java.util.List;

import com.cerebro.model.Definition;

public interface CerebroService {

    public abstract void saveDefinitions(List<Definition> definitions, String definitionType);

}
