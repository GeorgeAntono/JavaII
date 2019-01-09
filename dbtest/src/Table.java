import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Table	{
		private String tablename;
		// Name of table
		private HashMap<String , Column> records;
		// <Name of column, Value of column>

		public Table()	{
			records = new HashMap<String, Column>();
			// Empty constructor
		}
		public Table(String name)	{
			 tablename = name;
			records = new HashMap<String, Column>();
			// Constructor
		}// A record contains a value for each characteristic(column)
		public boolean insertRecord(HashMap<String , String>  rec)	{
			// Inserting records
			Iterator checkit = rec.entrySet().iterator();
			while ( checkit.hasNext())	{
				Map.Entry m2 = (Map.Entry)checkit.next();
				if (!records.containsKey((String)m2.getKey()))	{
					System.out.println("Cannot insert record ");
					return false;
				}
			}
				Iterator it = rec.entrySet().iterator();
				while (it.hasNext())	{
					Map.Entry m = (Map.Entry)it.next();
					String colname = (String)m.getKey();
					if (records.containsKey(colname))	{
						Column ctemp = (Column) records.get(colname);
						ctemp.addValue((String)(m.getValue()));
					}

				}
				return true;
		}
		public void selectTable()	{
			if (records.isEmpty())	{
				System.out.println("No records");
				return ;
				// Shows the tables or if none exist "No records"
			}
			Iterator it = records.entrySet().iterator();
			Column [] tablevalues = new Column [records.size()]; // use a column table so we can use the values in a row
			int i = 0;
			while (it.hasNext())	{
				Map.Entry m = (Map.Entry)it.next();				//Search through records via the characteristic (name of the column)
				String colname = (String)m.getKey();
				Column ctemp = (Column)records.get(colname);
				tablevalues[i] = ctemp;
				i++;
			}
			for(int k = 0; k < tablevalues [0].size(); k++)	{
				for (int j = 0; j<i; j++)	{
					System.out.print(" " + tablevalues[j].getValue(k) + " ");
				}
				System.out.println(" ");
			}
		}
			public int size()	{
				return records.size();
				// Returns size of the table
			}
			public void deleteRec(String key , String Value)	{ // In order to delete a record we need to delete every other value that is contained in the other columns
				if (!records.containsKey((String)key))	{
					System.out.println("No such column");

				}
				Column c = (Column)records.get(key);
				int [] theseis = new int [c.size()];
				for (int i = 0; i<theseis.length ; i++)	{//Search through records via the characteristic (name of the column)
					theseis[i] = -1;
					int j = 0;
					while ((theseis[j] = c.search(Value))!= -1)	{
						c.delete(theseis[j]);			//The table theseis holds the positions of the deleted values
						j++;
					}
				}
				Iterator it = records.entrySet().iterator();
				while(it.hasNext())	{
					Map.Entry m = (Map.Entry)it.next();
					String colname = (String)m.getKey();
					if (!colname.equals(key))	{
						Column ctemp = (Column)records.get(colname);
						for (int i = 0; i < theseis.length; i++)	{
							if( theseis[i] != -1)	{
								ctemp.delete(theseis[i]);
							}
						}
					}
				}
			}
			public void deleteAll()	{
				records.clear();
				// Clears all data from the table
			}
			public void addColumn(String key)	{
				Column c = new Column(key);
				records.put(key,c);
				// Adds a new column
			}
			public void deleteColumn(String key)	{
				records.remove(key);
				// Deletes a column
			}
			public void updateTable(String key , String newValue)	{
				Column ctemp = (Column) records.get(key);
				for (int i = 0; i < ctemp.size(); i++)	{
					ctemp.update(i , newValue);
					// Updates value of the record via index (position) and new value
				}
			}
			public String getTablename()	{
				return tablename;
			}
			public HashMap<String , Column> getRecords()	{
				return records;
			}
}
