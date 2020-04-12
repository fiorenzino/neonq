package ovh.flw.neonq.service.rs;

import ovh.flw.neonq.common.service.rs.GenericServiceRs;
import ovh.flw.neonq.model.Movie;
import ovh.flw.neonq.service.MovieService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieServiceRs extends GenericServiceRs<Movie> {

    public MovieServiceRs() {
    }

    @Inject
    public MovieServiceRs(MovieService movieService) {
        super(movieService);
    }
}
