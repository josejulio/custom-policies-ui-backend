/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.cloud.custompolicies.app;

import java.util.concurrent.CompletionStage;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author hrupp
 */
@Path("/endpoints/email/subscription/")
@RegisterRestClient(configKey = "notifications")
public interface NotificationSystem {


  @PUT
  @Path("/{event}")
  CompletionStage<String> addNotification(
      @PathParam("event") String event,
      @HeaderParam("x-rh-identity") String rhIdentity);

  @DELETE
  @Path("/{event}")
  CompletionStage<String> removeNotification(
      @PathParam("event") String event,
      @HeaderParam("x-rh-identity") String rhIdentity);
}
