package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.Person;
import by.bsuir.police.service.impl.PersonServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Wanted page command.
 */
public class SearchPageCommand implements ActionCommand {

    /**
     * The constant STATUS.
     */
    public static final String STATUS = "status";
    /**
     * The constant MISSING.
     */
    public static final String MISSING = "missing";

    @Override
    public Router execute(HttpServletRequest request) {
        String status = request.getParameter(STATUS);
        PersonServiceImpl service = new PersonServiceImpl();
        Router router = new Router();
        ArrayList<Person> people = service.showAll();
        request.getSession().setAttribute("people", people);
        if (status.equals(MISSING)) {
            router.setPagePath(PagePath.MISSING_TABLE.getJspPath());
        } else {
            router.setPagePath(PagePath.WANTED_TABLE.getJspPath());
        }
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
