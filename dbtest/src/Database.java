import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Database {
	private String databasename;
	private HashMap<String , Table> tables;

	public Database(String name)	{
		databasename = name;
		tables = new HashMap<String , Table>();
		// Constructor that names the database
	}
	public Database()	{
		databasename = null;
		tables = new HashMap<String , Table>();
		// Empty constructor
	}
	public String getName()	{
		return databasename;
	}
	public int size()	{
		return tables.size();
		// Returns how many tables the database has
	}
	public void createTable( String name , String [] cols)	{
		Table newtable = new Table(name);
		for( int i = 0; i < cols.length; i++)	{
			newtable.addColumn(cols[i]);
		}
		tables.put(name , newtable);
	}
	public void deleteTable(String name)	{
		tables.remove(name);
		// Deletes table from Database
	}
	public void clearBase()	{
		tables.clear();
		// Clears the database
	}
	public Table searchTable(String tablename)	{
		return ((Table)tables.get(tablename));
	}	// returns a Table object via the name of the table
	public void ShowTables()	{
		if(tables.isEmpty())	{
			System.out.println("No tables");
			return;
			// Shows that the database is empty
		}
		Iterator it = tables.entrySet().iterator();
		while (it.hasNext())	{
			Map.Entry m = (Map.Entry)it.next();
			String n = (String)m.getKey();
			System.out.println(n);
			// Returns the names of the tables
		}
	}
}

