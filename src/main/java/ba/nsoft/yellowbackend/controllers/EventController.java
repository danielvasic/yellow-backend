package ba.nsoft.yellowbackend.controllers;

import ba.nsoft.yellowbackend.model.Event;
import ba.nsoft.yellowbackend.repository.EventRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
@Api(
        tags = "Controller for Event retrieval",
        description = "This controller is used to retrieve all events from database."
)
public class EventController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    @ApiOperation(value = "Display data from database", notes = "Returns a list of Event objects.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all events from database.")
    })
    public ResponseEntity<List<Event>> getEvents (){
        List<Event> events = new ArrayList<>(eventRepository.findAll());
        if (events.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
