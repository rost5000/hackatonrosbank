package ru.skoltech;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import ru.skoltech.reportgenerator.model.Payment;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * @author rost.
 */
public class TesJson {

    @Test
    @Ignore
    public void testJson(){
        ObjectMapper mapper = new ObjectMapper();

        try {

            List<Payment> usrPost = mapper.readValue(new URL("http://springboot-reportgenerator-dev.us-east-1.elasticbeanstalk.com/api/list_payment?token=%22%22"),
                    new TypeReference<List<Payment>>(){});
            System.out.println(usrPost.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
