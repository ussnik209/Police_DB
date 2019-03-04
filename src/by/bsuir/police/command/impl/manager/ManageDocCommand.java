package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.Document;
import by.bsuir.police.service.impl.DocServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Manage doc command.
 */
public class ManageDocCommand implements ActionCommand {

    @Override
    public Router execute(HttpServletRequest request) {
        DocServiceImpl docService = new DocServiceImpl();
        Router router = new Router();
        ArrayList<Document> documents = docService.showAll();
        request.getSession().setAttribute("docs",documents);
        router.setPagePath(PagePath.DOCS_TABLE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
