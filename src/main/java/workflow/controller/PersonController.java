package workflow.controller;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import workflow.bean.Person;
import workflow.service.PersonService;

@Controller
public class PersonController {

    final Logger logger = LogManager.getLogger(getClass());

    static final String SEARCH_VIEW_PATH_KEY = "/person/search";

    private static final String DELETE_PATH_KEY = "/person/delete";
    private static final String SEARCH_VIEW_KEY = "redirect:search.xhtml";
    private static final String SEARCH_MODEL_KEY = "persons";

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    /**
     * <p>Deletes a person.</p>
     *
     * <p>Expected HTTP POST and request '/person/delete'.</p>
     */
    @RequestMapping(value=DELETE_PATH_KEY, method= RequestMethod.POST)
    public String delete(@RequestParam("id") Integer id) {
        logger.info("'{}'  id={}", DELETE_PATH_KEY, id);

        service.delete(id);

        return SEARCH_VIEW_KEY;
    }

    /**
     * <p>Searches for all persons and returns them in a
     * <code>Collection</code>.</p>
     *
     * <p>Expected HTTP GET and request '/person/search'.</p>
     */
    @RequestMapping(value=SEARCH_VIEW_PATH_KEY, method=RequestMethod.GET)
    public @ModelAttribute(SEARCH_MODEL_KEY)
    Collection<Person> search() {
        return service.find();
    }

}
