package org.raj.test.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.raj.test.model.Data;
import org.raj.test.resource.Raj;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
@Path("/repo")
@Api("/repo")
@SwaggerDefinition(tags= {@Tag(name="Test Service",description="REST IMPL")})
public class DataRepo {
	Raj raj = new Raj();

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<Data> getData() {
		System.out.println("All data called");
		return raj.getAll();
	}
	@Path("data/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Data getData(int id) {
		System.out.println("one data called id = "+id);
		return raj.getData(id);
	}
	
	@POST
	@Path("data")
	public void create(Data d) {
		System.out.println("one data created");
		raj.createData(d);
	}
}
