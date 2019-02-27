package by.bsuir.police.command;


import javax.servlet.http.HttpServletRequest;

/**
 * The interface Action command.
 */
public interface ActionCommand {

    /**
     * Execute router.
     *
     * @param request the request
     * @return the router
     */
    Router execute(HttpServletRequest request);

}
