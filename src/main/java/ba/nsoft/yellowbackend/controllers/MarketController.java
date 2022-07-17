package ba.nsoft.yellowbackend.controllers;

import ba.nsoft.yellowbackend.model.Market;
import ba.nsoft.yellowbackend.repository.MarketRepository;
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

@Api(
        tags = "Controller for Market retrieval",
        description = "This controller is used to retrieve all markets from database."
)
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class MarketController {
    @Autowired
    MarketRepository marketRepository;

    @GetMapping("/markets")
    @ApiOperation(value = "Display market data from database", notes = "Returns a list of Market objects.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all markets from database.")
    })
    public ResponseEntity<List<Market>> getMarkets (){
        List<Market> markets = new ArrayList<>(marketRepository.findAll());
        if (markets.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(markets, HttpStatus.OK);
    }
}
