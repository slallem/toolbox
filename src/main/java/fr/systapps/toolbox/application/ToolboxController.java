package fr.systapps.toolbox.application;

import fr.systapps.toolbox.domain.NetworkService;
import fr.systapps.toolbox.utility.TreeDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    NetworkService networkService;

    public ToolboxController(NetworkService networkService) {
        this.networkService = networkService;
    }

    /**
     * Give information about client/browser context
     * */
    @GetMapping("/info")
    ResponseEntity<TreeDoc> info(@RequestHeader Map<String, String> headers) {
        TreeDoc doc = new TreeDoc();
        doc.put("headers", headers);
        return new ResponseEntity<TreeDoc>(doc, HttpStatus.OK);
    }

    /**
     * Give information about server context
     * */
    @GetMapping("/host-info")
    ResponseEntity<TreeDoc> hostInfo(@RequestHeader Map<String, String> headers) {
        TreeDoc doc = new TreeDoc();
        doc.put("serverPort", networkService.getServerPort());
        doc.put("env", System.getenv());
        // Local name and IP
        doc.put("hostName", networkService.getHostName());
        doc.put("hostAddress", networkService.getHostAddress());
        // DNS record ?
        // Public name and IP
        doc.put("hostPublicIP", null);
        doc.put("hostPublicName", null);
        doc.put("hasWebAccess", null);
        // Resources (type and values) : CPU / DISK / MEM ?
        // Context (VM/Container/K8s...?)
        doc.put("isDockerized", networkService.isDockerized());
        // Container Image version ? Pod information ?

        return new ResponseEntity<TreeDoc>(doc, HttpStatus.OK);
    }

}
