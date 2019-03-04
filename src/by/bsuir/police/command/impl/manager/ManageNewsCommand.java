package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;

import javax.servlet.http.HttpServletRequest;

/**
 * The type Manage news command.
 */
public class ManageNewsCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPagePath(PagePath.NEWS_ADD_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
