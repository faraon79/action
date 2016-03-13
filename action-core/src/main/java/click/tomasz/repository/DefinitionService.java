package click.tomasz.repository;

import click.tomasz.model.Definition;

import java.util.List;

public interface DefinitionService {

	void addDefinition(Definition definition);
	List<Definition> getDefinitionList();
	Definition getDefinition(String name);
}
