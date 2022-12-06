package fr.systapps.toolbox.application;

import fr.systapps.toolbox.utility.TreeDoc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ToolboxController {

    @GetMapping("/info")
    ResponseEntity<TreeDoc> info(@RequestHeader Map<String, String> headers) {
        TreeDoc doc = new TreeDoc();
        doc.put("headers", headers);
        return new ResponseEntity<TreeDoc>(doc, HttpStatus.OK);
    }


}
