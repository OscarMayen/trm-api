
package com.curso.resource;

import com.curso.service.ConversionService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

/**
 *
 * @author omayen
 */

@Path("/conversion")
public class ConversionResource {
    
    @Inject
    ConversionService conversionService;

    @GET
    @Path("/DolarAPesos")
    @Operation(summary = "Metodo para conversión de dolar a moneda de Colombia")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.TEXT_PLAIN))
    @APIResponse(responseCode = "404", description = "Recurso no encontrado")
    public Response conversion(@QueryParam("cantidad") Double cantidad) {
        Double resultado = conversionService.conversionDolaAPesos(cantidad);
        return Response.ok(resultado).build();
    }
}
