package click.tomasz.repository;

import click.tomasz.bpmn2.model.TDefinitions;
import click.tomasz.model.CollectionResult;
import click.tomasz.model.Definition;

public interface DefinitionsService {

	void addDefinition(TDefinitions definitions);
	CollectionResult<Definition> getDefinitionList();
	TDefinitions getDefinition(String id);
}
