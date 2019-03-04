package by.bsuir.police.command.impl.admin;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.Document;
import by.bsuir.police.exception.ServiceException;
import by.bsuir.police.service.impl.DocServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * The type Remove doc command.
 */
public class RemoveDocCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        DocServiceImpl service = new DocServiceImpl();

        String id = request.getParameter(ID);
        try {
            service.remove(Integer.parseInt(id));
            ArrayList<Document> userAll = service.showAll();
            request.getSession().setAttribute("docs", userAll);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        router.setPagePath(PagePath.DOCS_TABLE.getJspPath());
        router.setRouteType(Router.RouteType.REDIRECT);
        return router;
    }
}
