package ir.mohamadcm.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.Object;

/**
 * This class contains the main Controllers (Routes)
 * For avaiable pathes
 */
@RestController
public class Controller {

    @Autowired
    private URLRepository repository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * A simple hello API
     * @param name is name of the person
     * @return a Greeting Object
     */
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /**
     * Create a new shotened URL
     * @param newURL is the created URL, contains
     *               oldAddress and newAddress
     *               which are URL and shotened path
     *               respectively
     * @return created URL with code 201 if successful
     *          Or 409 Error if URL already exists
     */
    @PostMapping("url")
    public ResponseEntity addURL(@RequestBody URL newURL) {
        try {
            repository.save(newURL);
            return ResponseEntity.status(HttpStatus.CREATED).body(newURL);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorMessage("Sorry, URL already exits", null));
        }
    }

    /**
     * @param path is the shotened path
     * @return The redirected page if page available,
     *          Or /url-not-found API otherwise
     */
    @GetMapping("/{path}")
    public RedirectView redirect(@PathVariable String path) {
        URL url = repository.findByNewAddress(path);
        if (url == null)
            return new RedirectView("/url-not-found?path=" + path);
        return new RedirectView(url.getOldAddress());
    }

    /**
     * @param path is the path of the unavailable path.
     * @return an String showing error
     */
    @GetMapping("/url-not-found")
    public String notFound(@RequestParam(value = "path", defaultValue = "") String path) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sorry, no URL for ")
                .append(path)
                .append(" Was found!");
        return stringBuilder.toString();
    }
}