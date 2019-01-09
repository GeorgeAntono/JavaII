import java.util.HashMap;
import java.util.Scanner;

public class Application	{
	public static void main(String [] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	System.out.println("    HELLO    ");
	System.out.println("Please name your database:");
	String dbname = sc.next();
	Database db = new Database (dbname);
    int choice;
    
    
    String n;
	System.out.println(" Create the first table ");
	System.out.println("Enter table name");
	n = sc.next();
	int num;
	System.out.println("Number of characteristics");
	num = sc.nextInt();
	String [] cols = new String [num];
	for( int i = 0 ; i < num; i++)	{
		System.out.println("Enter Column name:");
		cols[i] = sc.next();
	}
	db.createTable(n , cols);
	
	System.out.println(" Insert the first Records ");
	System.out.println("Enter tablename:");
	String n1 = sc.next();
	Table tb1 = db.searchTable(n1);
	HashMap<String , String> rec = new HashMap<String , String>();
	for (int i = 0; i < tb1.size(); i++)	{
		System.out.println("Enter Column:");
		String cname = sc.next();
		System.out.println("Enter Value:");
		String v = sc.next();
		rec.put(cname  , v);
	}
	tb1.insertRecord(rec);

	do	{
		System.out.println("**** Menu ****");
		System.out.println("1. Create Table");
		System.out.println("2. Insert Record");
		System.out.println("3. Delete Table ");
		System.out.println("4. Update Record");
		System.out.println("5. Show Table Names");
		System.out.println("6. Show Tables");
		System.out.print("Make a choice: ");
	    choice = sc.nextInt();
		switch (choice)	{
		case 1:
		System.out.println("			Create Table ");
		System.out.println("  Enter table name");
		n = sc.next();
		System.out.println("Number of characteristics");
		num = sc.nextInt();
		for( int i = 0 ; i < num; i++)	{
			System.out.println("Enter Column name:");
			cols[i] = sc.next();
		}
		db.createTable(n , cols);
		break;
		
		
		case 2:
			System.out.println("			Insert Records ");
		System.out.println("Enter tablename:");
		 n1 = sc.next();
		 tb1 = db.searchTable(n1);
		for (int i = 0; i < tb1.size(); i++)	{
			System.out.println("Enter Column:");
			String cname = sc.next();
			System.out.println("Enter Value:");
			String v = sc.next();
			rec.put(cname  , v);
			}
	 	tb1.insertRecord(rec);
		break;
		
		
		case 3:
			System.out.println("			Delete Table ");
			System.out.println(" What would you like to delete?");
			System.out.println(" 1. All data ");
			System.out.println(" 2. A table  ");
			System.out.println(" 0. Return to menu  ");
			System.out.println(" Please make a choice ");
			int x = sc.nextInt();


			if (x==2) {
				db.clearBase();
				System.out.println(" All data was cleared ");
			}	else if (x == 1) {
				System.out.println(" Which table would you like to delete?");
				String del_table = sc.next();
				db.deleteTable(del_table);
				System.out.println(" Table was deleted");
				}
			else if ( x == 0) {
				System.out.println(" You are going to exit");
				
			}
			else {
				System.out.println(" You gave the wrong number, try again:");
				System.out.println(" What would you like to delete?");
				System.out.println(" 1. All data ");
				System.out.println(" 2. A table  ");
				System.out.println(" 0. Return to menu  ");
				System.out.println(" Please make a choice ");
			x = sc.nextInt();
			}




		break;

		case 4:
		System.out.println("			Update Record ");
		System.out.println("Which table would you like to update?");
		String updated_table = sc.next();
		Table t = new Table(updated_table);
		if (updated_table.contains(t.getTablename())) {
			t = db.searchTable(updated_table);
		    System.out.println("Which value would you like to update?");
		    String old_value = sc.next();
		    Column ctemp = (Column) t.getRecords().get(old_value);
		    int index = ctemp.search(old_value);	  
		    if (old_value.contains(ctemp.getValue(index)))	{
				System.out.println("Please enter the new name of the value:");
				String new_value = sc.nextLine();
				ctemp.update(old_value, new_value);
			} else {
				System.out.println(" This value is not in the table, please try again:");
			}
		}
		    else {
				System.out.println(" There is no table matching this name.");
				}
		break;

		case 5:
		System.out.println("			Show Table Names ");
		try {
		  db.ShowTables();
	    } catch (Exception e) {
		throw new Exception (e.getMessage());

		}
		break;
	
		case 6:
			
		System.out.println("			Show Table Values ");
		try {
			tb1.selectTable();
		} catch (Exception e) {
			throw new Exception (e.getMessage());

		}
			break; 	
	} 
	}while ( choice != 0) ;
		}
	}

