package model;

/**
 * <h1>The Class Example.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Example {

    /** The id. */
    private final int id;

    /** The name. */
    private String    name;
    
    /** The path. */
    private String    path;

    /**
     * Instantiates a new example.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     * @param path
     * 			  the path
     */
    public Example(final int id, final String name, final String path) {
        super();
        this.id = id;
        this.name = name;
        this.path = path;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
    	return this.path;
    }
    
    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getId() + " : " + this.getName();
    }
}
