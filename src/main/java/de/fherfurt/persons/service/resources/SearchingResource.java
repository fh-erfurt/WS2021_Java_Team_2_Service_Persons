package de.fherfurt.persons.service.resources;

import de.fherfurt.persons.service.model.Address;
import de.fherfurt.persons.service.model.Person;
import de.fherfurt.persons.service.model.PersonAvatar;
import de.fherfurt.persons.service.persistence.repository.PersonAvatarRepository;
import de.fherfurt.persons.service.persistence.repository.PersonRepository;
import de.fherfurt.persons.service.persistence.repository.RepositoryFactory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Tran Anh Hoang
 * The class SearchingResource includes iterator search methode for a person (by personId or personinformation)
 * and a search methode for the Avatar of a certain InputField
 */
public class SearchingResource {

    final PersonRepository personRepository;
    final PersonAvatarRepository personAvatarRepository;


    public SearchingResource() throws IOException {
        this.personRepository = RepositoryFactory.getInstance().getPersonRepository();
        this.personAvatarRepository = RepositoryFactory.getInstance().getPersonAvatarRepository();
        System.out.println("ist drinne im Konstruktor");
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String printTest(){
        return "SearchingResource Endpoint is avaible!";
    }


    @GET
    @Path("/findPerson/{personId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonBy(@PathParam("personId") long  personId ) {

        Person p = this.personRepository.findPersonBy( personId );

        if( p != null )
            return Response.ok( p ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }

    @GET
    @Path("/findAllPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPerson() {

        List<Person> p = this.personRepository.findAll();

        if( p != null )
            return Response.ok( p ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }


    @GET
    @Path("/findPersonBy/{firstname}/{lastname}/{major}/{faculty}")
    public Response findPersonByUserInput(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname,
                                          @PathParam("major") String major, @PathParam("faculty") String faculty ) {

        this.personRepository.findAllPersonsByUserInput(firstname, lastname, major, faculty);

        if( this.personRepository.findAllPersonsByUserInput(firstname, lastname, major, faculty) != null )
            return Response.ok( this.personRepository.findAllPersonsByUserInput(firstname, lastname, major, faculty) ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();

    }

    @GET
    @Path("/findAllPersonWithDeletedFlag")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithDeletedFlag() {
        if( this.personRepository.findAllPersonWithDeletedFlag() != null )
            return Response.ok(this.personRepository.findAllPersonWithDeletedFlag()).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();

    }

    @GET
    @Path("/findAllPersonWithOutDeletedFlag")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithOutDeletedFlag() {
        if( this.personRepository.findAllPersonsWithoutDeletedFlag() != null )
            return Response.ok(this.personRepository.findAllPersonsWithoutDeletedFlag()).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();

    }


    /*
    @GET
    @Path("{/findPersonAvatar:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonAvatarById(@PathParam("personAvatarid") long  personAvatarid ) {


        byte[] PersonAvatar  = this.personAvatarRepository.findPersonAvatarById(personAvatarid);

        if( PersonAvatar != null )
            return Response.ok( PersonAvatar ).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }

    */

    @GET
    @Path("/findAllPersonWithEqualAddressId/{street}/{city}/{zipCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersonWithEqualAddressId(@PathParam("street") String street,
                                                    @PathParam("city") String city,
                                                    @PathParam("zipCode") String zipCode) {


        if( this.personRepository.findAllPersonWithEqualAddress(street, city, zipCode) != null )
            return Response.ok(this.personRepository.findAllPersonWithEqualAddress(street, city, zipCode)).build();
        else
            return Response.status( Response.Status.NOT_FOUND ).build();
    }



    //TODO Milena Endpoints, Business Logic in Repository und Unit Test

    /*

    @GET
    @Path("{/findAddressById/{AddressId:\\d+}}")
    @Produces(MediaType.APPLICATION_JSON)


    @GET
    @Path("{/findPersonByAddressId/{AddressId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)


    @GET
    @Path("{/findAllPersonByFaculty")
    @Produces(MediaType.APPLICATION_JSON)

    */

}