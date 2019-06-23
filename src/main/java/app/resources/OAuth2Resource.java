package app.resources;

import app.security.OAuth2Service;
import app.services.OAuth2PropertyProvider;
import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Component
@Path("/login")
public class OAuth2Resource {

    @Context
    private UriInfo uriInfo;

    @Autowired
    private OAuth2PropertyProvider oAuth2PropertyProvider;

    @GET
    @Path("/google")
    @Produces("text/html")
    public Response googleAuthentication() {
        OAuth2Service.setClientIdentifier(new ClientIdentifier(
                oAuth2PropertyProvider.getClientIdGoogle(),
                oAuth2PropertyProvider.getClientSecretGoogle()
        ));
        final String redirectURI =
                UriBuilder.fromUri(uriInfo.getBaseUri())
                .path("oauth2/authorize").build().toString();

        final OAuth2CodeGrantFlow flow = OAuth2ClientSupport
                .googleFlowBuilder(
                        OAuth2Service.getClientIdentifier(),
                        redirectURI,
                        "https://www.googleapis.com/auth/plus.login"
                )
                .prompt(OAuth2FlowGoogleBuilder.Prompt.CONSENT).build();
        OAuth2Service.setFlow(flow);
        final String googleAuthURI = flow.start();

        return Response.seeOther(UriBuilder.fromUri(googleAuthURI).build()).build();
    }

    @GET
    @Path("/wtf")
    @Produces("text/html")
    public Response setup() {
        OAuth2Service.setClientIdentifier(new ClientIdentifier(
                oAuth2PropertyProvider.getClientIdGoogle(),
                oAuth2PropertyProvider.getClientSecretGoogle()
        ));
        final URI uri = UriBuilder.fromUri(uriInfo.getBaseUri())
                .path("oauth2callback").build();
        return Response.seeOther(uri).build();
    }
}