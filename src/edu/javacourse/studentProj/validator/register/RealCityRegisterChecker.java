package edu.javacourse.studentProj.validator.register;

import edu.javacourse.studentProj.config.Config;
import edu.javacourse.studentProj.domain.register.CityRegisterRequest;
import edu.javacourse.studentProj.domain.Person;
import edu.javacourse.studentProj.exception.CityRegisterException;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.Client;
import java.awt.*;

public class RealCityRegisterChecker implements CityRegisterChecker {

    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException {

        try {
            CityRegisterRequest request = new CityRegisterRequest(person);

            Client client = ClientBuilder.newClient();
            CityRegisterResponse response = client.target(Config.getProperty(Config.CR_URL))
                    .request(PageAttributes.MediaType.APPLICATION_JSON)
                    .post(Entity.entity(request, PageAttributes.MediaType.APPLICATION_JSON))
                    .readEntity(CityRegisterResponse.class);

            return response;
        } catch (Exception ex) {
            throw new CityRegisterException("1", ex.getMessage(), ex);
        }
    }
}
