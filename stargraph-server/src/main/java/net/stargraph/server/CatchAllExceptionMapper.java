package net.stargraph.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Singleton
public final class CatchAllExceptionMapper implements ExceptionMapper<Exception> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Response toResponse(Exception exception) {
        logger.error("Oops!", exception);
        return Response.status(500).build();
    }
}
