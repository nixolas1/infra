package com.socket;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class DataStore
{
	private FileWriter fW;
	public void storeData(String type, String sender, String value)
	{
		try
		{
			fW = new FileWriter(type, true);
			fW.write(sender+":"+value+"\n");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try
			{
				fW.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getRandomData(String type)
	{
		List<String> content = null;
		try
		{
			content = Files.readAllLines(Paths.get(type), null);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(content);
		return content.get((new Random()).nextInt(content.size()));
	}
}
