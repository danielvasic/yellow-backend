package ba.nsoft.yellowbackend.controllers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(
        tags = "Serving static HTML example application",
        description = "This controller is used to serve static index webpage."
)
public class IndexController {
    @RequestMapping("/")
    @ApiOperation(value = "Forwards static HTML file to the client", notes = "Returns a static HTML page.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "index.html static page connected to the socket.")
    })
    public String index() {
        return "forward:index.html";
    }
}