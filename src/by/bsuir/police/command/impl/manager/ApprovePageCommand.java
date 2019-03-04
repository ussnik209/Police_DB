package by.bsuir.police.command.impl.manager;

import by.bsuir.police.command.ActionCommand;
import by.bsuir.police.command.PagePath;
import by.bsuir.police.command.Router;
import by.bsuir.police.entity.Document;
import by.bsuir.police.service.impl.DocServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * The type Approve page command.
 */
public class ApprovePageCommand implements ActionCommand {

    private static final String ID = "id";

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        String id = request.getParameter(ID);
        DocServiceImpl docService = new DocServiceImpl();
        Optional<Document> document = docService.searchById(Integer.parseInt(id));
        request.setAttribute("document", document.get());
        router.setPagePath(PagePath.APPROVE_PAGE.getJspPath());
        router.setRouteType(Router.RouteType.FORWARD);
        return router;
    }
}
