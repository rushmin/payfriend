/*
 * Copyright 2011-2012 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.jaxrs.server;

import java.util.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class AnimalService {
    long currentId = 123;
    Map<Long, Animal> animals = new HashMap<Long, Animal>();

    public AnimalService() {
        init();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Animal getAnimal(@PathParam("id") String id) {
        System.out.println("Animal Service -- invoking getAnimal, Animal id is: " + id);
        long idNumber = Long.parseLong(id);
        Animal c = animals.get(idNumber);
        return c;
    }

    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAnimal(Animal animal) {
        System.out.println("Animal Service -- invoking updateAnimal, Animal name is: " + animal.getName());
        Animal c = animals.get(animal.getId());
        Response r;
        if (c != null) {
            animals.put(animal.getId(), animal);
            r = Response.ok(animal).build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAnimal(Animal animal) {
        System.out.println("Animal Service -- invoking addAnimal, Animal name is: " + animal.getName());
        animal.setId(++currentId);

        animals.put(animal.getId(), animal);
        System.out.println("Animal Service -- Animal ID is: " + animal.getId());

        return Response.ok(animal).build();
    }


    @DELETE
    @Path("{id}")
    public Response deleteAnimal(@PathParam("id") String id) {
        System.out.println("Animal Service -- invoking deleteAnimal, Animal id is: " + id);
        long idNumber = Long.parseLong(id);
        Animal c = animals.get(idNumber);

        Response r;
        if (c != null) {
            r = Response.ok().build();
            animals.remove(idNumber);
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    final void init() {
        Animal c = new Animal();
        c.setName("cat");
        c.setId(123);
        c.setDateOfSpeciesIdentification("01-01-2000");
        c.setSpeciesName("wildCat");
        ContinentNames ctn = new ContinentNames();
        ctn.setNames(new String[]{"continent-ant1", "continent-ant2", "continent-ant3"});
        c.setContinentNames(ctn);
        animals.put(c.getId(), c);

        Animal ant = new Animal();
        ant.setName("ant");
        ant.setId(124);
        ant.setDateOfSpeciesIdentification("01-01-2000");
        ant.setSpeciesName("ant");
        ant.setContinentNames(ctn);
        animals.put(c.getId(), ant);
    }

}