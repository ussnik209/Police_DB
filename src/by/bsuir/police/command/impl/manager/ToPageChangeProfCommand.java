package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.consant.RoleType;

import javax.servlet.http.HttpServletRequest;

/**
 * The type To page change prof command.
 */
public class ToPageChangeProfCommand implements ActionCommand {
    private static final String ROLE = "role";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        RoleType role = (RoleType) request.getSession().getAttribute(ROLE);
        if (role != RoleType.ADMIN) {
            router.setPagePath(PagePath.CHANGE_PROF_PAGE_USER.getJspPath());
        } else {
            router.setPagePath(PagePath.CHANGE_PROF_PAGE_ADMIN.getJspPath());
        }
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
