package com.target.basegame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;


public class DefaultUser extends Users{
	private int currency;
	private int userscore;
	private String saveFile;
	public DefaultUser() {
		saveFile = "usersavefile.txt";
		currency = 0;
		userscore = 0;
	}
	
	
	public boolean readSave(String login, String password) {
		File users = new File(saveFile); // Fetch the saveFile
		boolean returnval=false; // Variable for return statement
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(users)); // Add the File to the BufferedReader
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		String string; 
		int index=0,previndex=0;
		try {
			while ((string = br.readLine()) != null) {
				index = string.indexOf('/'); // Get index of char '/' 
				String name = string.substring(0, index); // Get the Login
				if(name.equals(login)) {
					this.login=login;
					previndex = index; // Set current index as previous index
					index = string.indexOf('/',index+1); // Get index of the next char '/'
					String key = string.substring(previndex+1,index); // Get the password
					if(key.equals(password)) {
						this.password=password;
						previndex = index;
						index = string.indexOf('/',index+1);
						currentlevel = Integer.parseInt(string.substring(previndex+1,index)); // Get the currentlevel
						previndex = index;
						index = string.indexOf('/',index+1);
						ArrowType = string.substring(previndex+1,index); // Get the ArrowType
						previndex = index;
						index = string.indexOf('/',index+1);
						BowType = string.substring(previndex+1,index); // Get the BowType
						previndex = index;
						index = string.indexOf('/',index+1);
						currency = Integer.parseInt(string.substring(previndex+1,index)); // Get the currency
						previndex = index;
						index = string.indexOf('/',index+1);
						userscore = Integer.parseInt(string.substring(previndex+1,index)); // Get the userscore
						returnval = true; // returns true if the login and password is correct
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnval; // returns false if the login and password is incorrect
		
	}
	
	public void writeSave(String login, String password) {
		File users = new File(saveFile);
		FileWriter fp = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(users)); 
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String string;
		List<String> array = new ArrayList<String>();
		boolean flag = false;
		try {
			while ((string = br.readLine()) != null) {
				if(string.contains(login) && string.contains(password)) {
					flag = true;
					continue;
				}
				array.add(string);
			}
			new FileWriter(saveFile, false).close();
			if(flag) {
				fp = new FileWriter("usersavefile.txt", true);
				BufferedWriter bw = new BufferedWriter(fp); 
				PrintWriter pr = new PrintWriter(bw); 
				for(int i =0 ; i<array.size() ; i++) {
					pr.println(array.get(i));
				}
				pr.println(login + "/" + password + "/" + currentlevel + "/" + ArrowType + "/" + BowType + "/" + currency + "/" + userscore + "/");
				pr.close();
				bw.close();
				
			} else {
				fp = new FileWriter(saveFile, true);
				BufferedWriter bw = new BufferedWriter(fp); 
				PrintWriter pr = new PrintWriter(bw); 
				pr.println(login + "/" + password + "/" + currentlevel + "/" + ArrowType + "/" + BowType + "/" + currency + "/" + userscore + "/"); // Print the contents to the file
				pr.close();
				bw.close();
			}
			fp.close();
			//Files.move(Paths.get("tempfile.txt"), Paths.get("usersavefile.txt") ,StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return true;
		
	}
	
	public boolean register(String login, String password) {
		File users = new File(saveFile);
		FileWriter fp = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(users)); 
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String string;
		try {
			while ((string = br.readLine()) != null) {
				int index = string.indexOf('/');
				String name = string.substring(0, index); 
				if(name.equals(login)) {
					return false;
				}
			}
			fp = new FileWriter(saveFile, true);
			BufferedWriter bw = new BufferedWriter(fp); 
			PrintWriter pr = new PrintWriter(bw); 
			pr.println(login + "/" + password + "/" + currentlevel + "/" + ArrowType + "/" + BowType + "/" + currency + "/" + userscore + "/"); // Print the contents to the file
			pr.close();
			bw.close();
			fp.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public int getCurrency() {
		return currency;
	}


	public void setCurrency(int currency) {
		this.currency = currency;
	}


	public int getUserscore() {
		return userscore;
	}


	public void setUserscore(int userscore) {
		this.userscore = userscore;
	}


	public String getSaveFile() {
		return saveFile;
	}
	public void increaseUserscore(int score) {
		this.userscore += score;
	}
	public void increaseCurrency(int currency) {
		this.currency += currency;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}
}
