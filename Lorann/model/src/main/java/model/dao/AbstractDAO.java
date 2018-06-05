package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Example;
import view.IMap;

/**
 * <h1>The Class AbstractDAO.</h1>
 * 
 * @author Pierre-Alain TIETZ pierrealain.tietz@viacesi.fr
 * @version 1.0
 */
@SuppressWarnings("unused")
public abstract class AbstractDAO {
	
	private static final int IDMap = 1;

	/** Finding all the maps */
	private static String sqlAllMaps = "{call findAllMaps(?)}";
	
	/** Finding all the sprites*/
	private static String sqlAllSprites = "{call findAllSprites(?)}";
	
	/** The id column index. */
    private static int    idColumnIndex    = 1;

    /** The name column index. */
    private static int    nameColumnIndex  = 2;
    
    /** The path column index*/
    private static int 	  pathColumnIndex  = 3;
	
    public static List<Example> getAllMaps() 
    	throws SQLException
    	{
    		int currentMap = 1;
			if (IDMap == currentMap)
    		{
    			final ArrayList<Example> examples = new ArrayList<Example>();
    			final CallableStatement callStatement = prepareCall(sqlAllMaps);
    			
    			if (callStatement.execute())
    			{
    				final ResultSet result = callStatement.getResultSet();

    				for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) 
    				{
            			examples.add(new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex), result.getString(pathColumnIndex)));
            			}
            		result.close();
        			}
    			return examples;
    			}
			return null;
    		}

	
	public static List<Example> getAllSprites() 
			throws SQLException 
			{
        		final ArrayList<Example> examples = new ArrayList<Example>();
        		final CallableStatement callStatement = prepareCall(sqlAllSprites);
        		
        		if (callStatement.execute()) 
        		{
        			final ResultSet result = callStatement.getResultSet();

        			for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) 
        			{
        				examples.add(new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex), result.getString(pathColumnIndex)));
        			}
        			result.close();
        		}
        		return examples;
			}
	
    /**
     * Execute query.
     *
     * @param query
     *            the query
     * @return the result set
     */
    protected static ResultSet executeQuery(final String query) {
        return LorannBDDConnector.getInstance().executeQuery(query);
    }

    /**
     * Execute update.
     *
     * @param query
     *            the query
     * @return the int
     */
    protected static int executeUpdate(final String query) {
        return LorannBDDConnector.getInstance().executeUpdate(query);
    }

    /**
     * Prepare call.
     *
     * @param query
     *            the query
     * @return the callable statement
     */
    protected static CallableStatement prepareCall(final String query) {
        return LorannBDDConnector.getInstance().prepareCall(query);
    }
}
