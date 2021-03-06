// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
 // end::copyright[]
package io.openliberty.guides.inventory;

import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// CDI
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

// tag::RequestScoped[]
@RequestScoped
// end::RequestScoped[]
@Path("hosts")
public class InventoryResource {

    // tag::Inject[]
    @Inject InventoryManager manager;
    // end::Inject[]

    @GET
    @Path("{hostname}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPropertiesForHost(@PathParam("hostname") String hostname) {
        return manager.get(hostname);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject listContents() {
        return manager.list();
    }
}
