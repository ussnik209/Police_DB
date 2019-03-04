package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.consant.RoleType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * The type Logout command.
 */
public class LogoutCommand implements ActionCommand {

    private static final String NAME_USER = "nameUser";
    private static final String SESSION_ROLE = "role";
    private static final String SESSION_IS_LOGIN = "isLogin";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPagePath(PagePath.INDEX_PAGE.getJspPath());
        HttpSession session = request.getSession();
        session.removeAttribute(NAME_USER);
        session.setAttribute(SESSION_IS_LOGIN, "false");
        session.setAttribute(SESSION_ROLE, RoleType.GUEST);
        router.setRouteType(Router.RouteType.REDIRECT);

        return router;
    }
}
