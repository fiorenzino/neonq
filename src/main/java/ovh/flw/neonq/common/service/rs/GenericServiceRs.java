package ovh.flw.neonq.common.service.rs;

import ovh.flw.neonq.common.service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public abstract class GenericServiceRs<T> {

    Service<T> service;

    public GenericServiceRs(){}

    public GenericServiceRs(Service<T> service) {
        this.service = service;
    }


    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") Long id) {
        T entity = service.find(id);
        if (entity != null) {
            return Response.ok(entity).build();
        }
        return Response.serverError().build();
    }

    @POST
    @Path("/")
    public Response post(T entity) {
        T result = service.createOrUpdate(entity);
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/")
    public Response list(@Context UriInfo uriInfo) {
        Iterable<T> result = service.findAll();
        return Response.ok(result).build();
    }


}
