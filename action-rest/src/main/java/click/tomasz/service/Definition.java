package click.tomasz.service;

import click.tomasz.logger.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.text.MessageFormat;

@Path("/definition")
public class Definition {
	private Logger logger = LoggerFactory.getLogger(Definition.class);

	@POST
	@Path("/")
	@Produces({"application/json"})
	@Consumes({"application/xml"})
	public Response createDefinition(String definition) {
		logger.info(Messages.CREATE_DEFINITION);
		return Response.ok(Messages.CREATE_DEFINITION).build();
	}

	@GET
	@Path("/{name}")
	@Produces({"application/json"})
	@Consumes({"application/xml"})
	public Response getDefinition(@PathParam("name") String name) {
		String response = MessageFormat.format(Messages.GET_DEFINITION, name);
		logger.info(response);
		return Response.ok(response).build();
	}
}
