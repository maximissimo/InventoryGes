import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.DefaultListModel;

public class DBHelper
{
	private final static String DATABASE = "database.ser";

	public static DefaultListModel<Producto> load()
	{
		DefaultListModel<Producto> stock = null;
		try
		{
			FileInputStream fis = new FileInputStream(DATABASE);
			ObjectInputStream ois = new ObjectInputStream(fis);
			stock = (DefaultListModel<Producto>)ois.readObject();
			ois.close();
			fis.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("No database file found. Continuing...");
			stock = new DefaultListModel<Producto>();
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
		catch(ClassNotFoundException e)
		{
			 System.out.println(e.toString());
		}
		return stock;
	}

	public static void save(DefaultListModel<Producto> stock)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(DATABASE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stock);
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.toString());
		}
		catch(IOException e)
		{
			System.out.println(e.toString());
		}
	}
}
