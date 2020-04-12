package ovh.flw.neonq.service;

import ovh.flw.neonq.commons.service.GenericService;
import ovh.flw.neonq.model.Movie;

import javax.inject.Singleton;

@Singleton
public class MovieService extends GenericService<Movie> {
    @Override
    public Class<Movie> getEntityType() {
        return Movie.class;
    }
}
