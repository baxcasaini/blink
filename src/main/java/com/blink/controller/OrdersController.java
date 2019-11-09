package com.blink.controller;

import com.blink.config.RestTemplateConfiguration;
import com.google.gson.Gson;
import it.snam.pimos.common.logger.Logp;
import it.snam.pimos.common.logger.LogpLevel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Casini Fabio
 *
 */
@RestController
@RequestMapping(value = "/api")
public class OrdersController {

    private Gson gson;
    private RestTemplate restTemplate;

    public OrdersController(RestTemplateConfiguration restTemplateConfiguration) {
        restTemplate = restTemplateConfiguration.getRestTemplateWithTimeout();
        this.gson = new Gson();
    }

    @PostMapping(value = "/enqueueOrders")
    public String receiveOrders(@RequestBody String order) {

        return null;
    }
}


//scp -i C:\Users\fabio.casini\Desktop\PimosProject\PimosBitBucket\soapWs\cartesio-web-master\pms-cartesio-web-service\sources\blink\src\main\resources\EC2KeypairBlink.pem C:\Users\fabio.casini\Desktop\PimosProject\PimosBitBucket\soapWs\cartesio-web-master\pms-cartesio-web-service\sources\blink\target\blink-0.0.1-SNAPSHOT.jar ec2-user@ec2-3-16-169-191.us-east-2.compute.amazonaws.com:~
//ssh -i C:\Users\fabio.casini\Desktop\PimosProject\PimosBitBucket\soapWs\cartesio-web-master\pms-cartesio-web-service\sources\blink\src\main\resources\EC2KeypairBlink.pem ec2-user@ec2-18-217-144-112.us-east-2.compute.amazonaws.com
//java -jar C:\Users\fabio.casini\Desktop\PimosProject\PimosBitBucket\soapWs\cartesio-web-master\pms-cartesio-web-service\sources\blink\target\blink-0.0.1-SNAPSHOT.jar

//db.createUser(
//        {
//        user: "blink",
//        pwd: "Blink1",
//        roles: [ { role: "readWrite", db: "muddle" }]
//        }
//        )