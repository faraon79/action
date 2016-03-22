package click.tomasz.rest.service;

import click.tomasz.bpmn2.model.TDefinitions;
import click.tomasz.rest.logger.Messages;
import click.tomasz.model.CollectionResult;
import click.tomasz.model.Definition;
import click.tomasz.repository.DefinitionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import java.text.MessageFormat;

@Path("/definition")
public class Definitions {

	private DefinitionsService definitionsService;
	private Logger logger = LoggerFactory.getLogger(Definitions.class);

	@POST
	@Path("/")
	@Produces({"application/json"})
	@Consumes({"application/xml"})
	public String createDefinition(TDefinitions definitions) {
		definitionsService.addDefinition(definitions);
		String response = Messages.CREATE_DEFINITION;
		logger.info(response);
		return response;
	}

	@GET
	@Path("/{id}")
	@Produces({"application/xml"})
	public TDefinitions getDefinition(@PathParam("id") String id) {
		String response = MessageFormat.format(Messages.GET_DEFINITION, id);
		logger.info(response);
		return definitionsService.getDefinition(id);
	}

	@GET
	@Path("/")
	@Produces({"application/json"})
	public CollectionResult<Definition> getDefinitionList() {
		String response = Messages.GET_DEFINITION_LIST;
		logger.info(response);
		return definitionsService.getDefinitionList();
	}

	public void setDefinitionsService(DefinitionsService definitionsService) {
		this.definitionsService = definitionsService;
	}
}
