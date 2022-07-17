package ba.nsoft.yellowbackend.controllers;

import ba.nsoft.yellowbackend.model.Event;
import ba.nsoft.yellowbackend.model.Market;
import ba.nsoft.yellowbackend.stream.producer.ProducerService;
import ba.nsoft.yellowbackend.utils.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/stream")
@Api(
        tags = "This controller pushes messages to Kafka",
        description = "This controller is used to serve market and event stream updates using Kafka API"
)
public class StreamController {
    @Autowired
    ProducerService producerService;

    Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer()).create();

    @RequestMapping(value="event", method=RequestMethod.POST)
    @ApiOperation(value = "Push event to stream.", notes = "Returns a list of Market objects.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully pushed event to Kafka."),
            @ApiResponse(code = 400, message = "The message sent to Kafka is invalid and cannot be parsed.")
    })
    public ResponseEntity addEvent(@RequestBody String payload){
        try {
            Event event = gson.fromJson(payload, Event.class);
            if (event.valid())
                producerService.sendEvent(event);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value="market", method=RequestMethod.POST)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully pushed market to Kafka."),
            @ApiResponse(code = 400, message = "The message sent to Kafka is invalid and cannot be parsed.")
    })
    public ResponseEntity addMarket(@RequestBody String payload){
        try {
            Market market = gson.fromJson(payload, Market.class);
            if (market.valid())
                producerService.sendMarket(market);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
