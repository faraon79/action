package click.tomasz.service;

import click.tomasz.logger.Messages;
import click.tomasz.repository.DefinitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import java.text.MessageFormat;
import java.util.List;

@Path("/definition")
public class Definition {

	private DefinitionService definitionService;
	private Logger logger = LoggerFactory.getLogger(Definition.class);

	@POST
	@Path("/")
	@Produces({"application/json"})
	@Consumes({"application/xml"})
	public String createDefinition(click.tomasz.model.Definition definition) {
		definitionService.addDefinition(definition);
		String response = Messages.CREATE_DEFINITION;
		logger.info(response);
		return response;
	}

	@GET
	@Path("/{name}")
	@Produces({"application/json"})
	public click.tomasz.model.Definition getDefinition(@PathParam("name") String name) {
		String response = MessageFormat.format(Messages.GET_DEFINITION, name);
		logger.info(response);
		return definitionService.getDefinition(name);
	}

	@GET
	@Path("/")
	@Produces({"application/json"})
	public List<click.tomasz.model.Definition> getDefinitionList(@PathParam("name") String name) {
		String response = Messages.GET_DEFINITION_LIST;
		logger.info(response);
		return definitionService.getDefinitionList();
	}

	public void setDefinitionService(DefinitionService definitionService) {
		this.definitionService = definitionService;
	}
}
