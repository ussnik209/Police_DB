package by.bsuir.police.command;

/**
 * The enum Page path.
 */
public enum PagePath {
    MAIN("");
    /**
     * The Jsp path.
     */
    String jspPath;

    PagePath(String jspPath) {
        this.jspPath = jspPath;
    }

    /**
     * Gets jsp path.
     *
     * @return the jsp path
     */
    public String getJspPath() {
        return jspPath;
    }

}
