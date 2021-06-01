package org.sebi;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/todos")
public class TodoResource {
    
    @GET
    public List<Todo> getTodos() {
        return Todo.listAll();
    }

    @POST
    @Transactional
    public Response saveTodo(Todo todo) {
        todo.persist();
        return Response.status(Status.CREATED).entity(todo).build();
    }

}
