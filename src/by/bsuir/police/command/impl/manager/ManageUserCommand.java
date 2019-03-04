package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.User;
import by.bsuir.police.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Manage user command.
 */
public class ManageUserCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        UserServiceImpl service = new UserServiceImpl();
        Router router = new Router();
        ArrayList<User> userAll = service.showAll();
        request.getSession().setAttribute("users", userAll);
        router.setPagePath(PagePath.USERS_TABLE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
