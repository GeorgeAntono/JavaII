import java.util.LinkedList;

public class Column {
// The column class represents a specific characteristic and its values
	private String name;
	// Name of Column 
	private LinkedList<String> values;
	// Values of Column

	public Column (String name)	{
		this.name = name;
		values = new LinkedList<String>();
		// This was the constructor that names the list
	}
	public Column ()	{
		name = null;
		values = new LinkedList<String>();
		// Empty constructor
	}
	public void addValue (String v)	{
		values.addLast(v);
		//Adds values to the last position 
	}
	public void delete (int index)	{
		values.remove(index);
		// Deletes a record from its index
	}
	public void delete (String v)	{
		values.remove(v);
		// Deletes a record from its value 
	}
	public int size ()	{
		return values.size();
		// Size of the column
	}
	public void update (int index , String v)	{
		values.set(index , v);
		// Updates the value of a record via its index (position)
	}
	public int search (String v)	{
		return values.indexOf(v);
		// Searches for a value and returns the first index in which it was found 
	}
	public void update (String oldV , String newV)	{
		int i;
		for (i = 0; i < values.size(); i++)	{
			String temp = values.get(i);
			if (temp.equals(oldV))	{
				values.set(i,newV);
				// Updates the value of a record via the old value that it had 
			}
		}
	}
	public String getValue(int index)	{
		return values.get(index);
		// Returns value of record while having searched the indexes ****
		}
	public LinkedList<String> getColumn()	{
		return values;
		
	}
	public void setName (String name)	{
		this.name = name;
	}
	public String getName()	{
		return name;
	}
}
