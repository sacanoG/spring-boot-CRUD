package io.quind.calculatorsalary.gateway;

import io.quind.calculatorsalary.data.IGovernmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class GovernmentGateway implements IGovernmentRepository {

    private static final String GOVERNMENT_API =  "https://4f3e1764-0351-400b-bce6-eb1cf7a51a4c.mock.pstmn.io/person/";

    @Override
    public ResponseEntity<Object> consultEmployeeById(Long id) {
        String consultByIdUri = GOVERNMENT_API + id;
        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForEntity(consultByIdUri, Object.class);
        }catch (HttpClientErrorException e){
            return new ResponseEntity<>(e.getStatusCode());
        }
    }
}
