package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.News;
import by.bsuir.police.service.impl.NewsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type To news page command.
 */
public class ToNewsPageCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        NewsServiceImpl docService = new NewsServiceImpl();
        Router router = new Router();
        ArrayList<News> news = docService.showAll();
        request.getSession().setAttribute("news", news);
        router.setPagePath(PagePath.NEWS_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
