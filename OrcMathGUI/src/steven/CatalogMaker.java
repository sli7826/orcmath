package steven;


import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Scanner;


public class CatalogMaker {

	private ArrayList<Computer> arr;
	public static Scanner in=new Scanner(System.in);
	public CatalogMaker() {
		arr=new ArrayList<Computer>();
	}

	public static void main(String[] args) {
		CatalogMaker maker=new CatalogMaker();
		System.out.println(maker.getCsvContent());
		String s;
		while(true) {
			System.out.println("Would you like to load a csv?");
			s=in.nextLine();
			if(s.equals("yes")) {
				
			}
			int ram=0;
			int storage=0;
			String cpu;
			String gpu;
			boolean isInt=true;
			System.out.println("How many gb is your ram?");
			s=in.nextLine();
			while(isInt) {
				try {
					ram=Integer.parseInt(s);
					isInt=false;
				}catch(NumberFormatException e) {
					System.out.println("Invalid response.\nHow many gb is your ram?");
					s=in.nextLine();
				}
			}
			isInt=true;
			System.out.println("How many gb is your memory?");
			s=in.nextLine();
			while(isInt) {
				try {
					storage=Integer.parseInt(s);
					isInt=false;
				}catch(NumberFormatException e) {
					System.out.println("Invalid response.\nHow many gb is your memory?");
					s=in.nextLine();
				}
			}
			System.out.println("What is your cpu?");
			s=in.nextLine();
			cpu=s;
			System.out.println("What is your gpu?");
			s=in.nextLine();
			gpu=s;
			maker.arr.add(new Computer(ram,storage,cpu,gpu));
			System.out.println(maker.getCsvContent());
			System.out.println("Would you like to save your file?");
			s=in.nextLine();
			if(s.equals("yes"))maker.save();
		}
	}
	
	public String getCsvContent() {
		String data="";
		for(Computer c:arr) {
			data+=c+"\n";
		}
		return data;
	}
	public void addComp(Computer a) {
		arr.add(a);
	}
	public void loadCsv(String fileName) {
		try {
			FileReader fileReader = new FileReader(new File(fileName));
			BufferedReader br = new BufferedReader(fileReader);
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] a=line.split(",");
				arr.add(new Computer(Integer.parseInt(a[0]),Integer.parseInt(a[1]),a[2],a[3]));
			}
			br.close();
		}catch(IOException e){
			System.out.println("An IOException was thrown.");
		}
	}
	
	public void save() {
		try {
			FileWriter fw=new FileWriter("computer.csv");
			fw.write(getCsvContent());
			fw.close();    
			System.out.println("Success! File \""+"computer.csv"+"\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

}
