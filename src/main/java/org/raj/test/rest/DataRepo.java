package org.raj.test.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.raj.test.dbms.Dbms;
import org.raj.test.model.Data;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
@Path("/repo")
@Api("/repo")
@SwaggerDefinition(tags= {@Tag(name="Test Service",description="REST IMPL")})
public class DataRepo {
	Dbms raj = new Dbms();

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<Data> getData() {
		System.out.println("All data called");
		return raj.getAll();
	}
	@Path("data/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Data getData(@PathParam("id") int id) {
		System.out.println("one data called with id = "+id);
		return raj.getData(id);
	}
	
	@POST
	@Path("data")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void create(Data d) {
		System.out.println("one data created");
		raj.createData(d);
	}
	@PUT
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void update(Data d) {
		System.out.println("one data updated");
		raj.updateData(d);
	}
	@DELETE
	@Path("repo/data/{id}")
	public Data delete(@PathParam("id") int id) {
		Data a = raj.getData(id);
		if(a==null) {
			return null;
		}
		raj.delete(a);
		return a;
	}
}
