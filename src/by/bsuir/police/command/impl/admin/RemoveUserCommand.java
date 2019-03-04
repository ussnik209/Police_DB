package by.bsuir.police.command.impl.admin;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.User;
import by.bsuir.police.exception.ServiceException;
import by.bsuir.police.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Remove user command.
 */
public class RemoveUserCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        UserServiceImpl service = new UserServiceImpl();

        String id = request.getParameter(ID);
        try {
            service.remove(Integer.parseInt(id));
            ArrayList<User> userAll = service.showAll();
            request.getSession().setAttribute("users", userAll);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        router.setPagePath(PagePath.USERS_TABLE.getJspPath());
        router.setRouteType(Router.RouteType.REDIRECT);
        return router;
    }
}
