// ******************************************************************************
//  Copyright (c) 2017 IBM Corporation and others.
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  which accompanies this distribution, and is available at
//  http://www.eclipse.org/legal/epl-v10.html
//
//  Contributors:
//  IBM Corporation - initial API and implementation
// ******************************************************************************
package net.wasdev.samples.microprofile.group;

import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("groups")
@RequestScoped
public class GroupResource {

  /** The JWT of the caller. */
  @Inject private JsonWebToken jwtPrincipal;

  // @GET
  // @Path("/prop")
  // @Produces(MediaType.APPLICATION_JSON)
  // public Response getProperties() {
  //   System.out.println("In get properties method");
  //   // JsonObjectBuilder builder = Json.createObjectBuilder();
  //   //
  //   // System.getProperties()
  //   //     .entrySet()
  //   //     .stream()
  //   //     .forEach(entry -> builder.add((String) entry.getKey(), (String) entry.getValue()));
  //
  //   // return builder.build(); (builder.build()).toString();
  //   // Create a JSON payload with the group content
  //
  //   // JsonObjectBuilder group = Json.createObjectBuilder();
  //   // group.add("JSON_KEY_GROUP_ID", "id");
  //   // group.add("JSON_KEY_GROUP_NAME", "name");
  //   //
  //   // String responsePayload = group.build().toString();
  //   String responsePayload = "This is placeholder";
  //
  //   return Response.ok().entity(responsePayload).build();
  // }

  @GET
  @Path("/prop")
  public Response generateJwtLogin() {
    System.out.println("In get properties method");
    // Build a JWT that the caller can use to create a new user or login.
    // The builder ID is specified in server.xml.  We build this first
    // because we don't want to add the user if we can't build the response.
    // String jwtTokenString = null;
    // try {
    //   jwtTokenString =
    //       JwtBuilder.create("jwtAuthLoginBuilder")
    //           .claim(Claims.SUBJECT, "unauthenticated")
    //           .claim("upn", "unauthenticated") /* MP-JWT defined subject claim */
    //           .claim(
    //               "groups",
    //               "login") /* MP-JWT defined group, seems Liberty makes an array from a comma
    // separated list */
    //           .buildJwt()
    //           .compact();
    // } catch (Throwable t) {
    //   return Response.status(Status.INTERNAL_SERVER_ERROR)
    //       .entity("Erorr building authorization token")
    //       .build();
    // }

    return Response.ok().header("proptoken", "placeholderhere").build();
  }

  /** Do some basic checks on the JWT, until the MP-JWT annotations are ready. */
  private void validateJWT() throws JWTException {
    // Make sure the authorization header was present.  This check is somewhat
    // silly since the jwtPrincipal will never actually be null since it's a
    // WELD proxy (injected).
    if (jwtPrincipal == null) {
      throw new JWTException("No authorization header or unable to inflate JWT");
    }

    // Make sure we're in one of the groups we know about.
    Set<String> groups = jwtPrincipal.getGroups();
    if ((groups.contains("users") == false) && (groups.contains("orchestrator") == false)) {
      throw new JWTException("User is not in a valid group [" + groups.toString() + "]");
    }

    // TODO: Additional checks as appropriate.
  }

  private static class JWTException extends Exception {
    private static final long serialVersionUID = 423763L;

    public JWTException(String message) {
      super(message);
    }
  }
}
