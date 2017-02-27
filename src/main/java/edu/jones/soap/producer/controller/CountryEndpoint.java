package edu.jones.soap.producer.controller;

import edu.jones.soap.producer.model.CountryRepository;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Jones on 27/02/2017.
 */
@Endpoint // this anotation register this class with Spring ws as a potential candidate for processing SOAP messages
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    //    the next anotation provide this method to spring ws to pick as handler methodbased on namespace and localPart
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload // this annotation provide the return of this method to the response payload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }

}