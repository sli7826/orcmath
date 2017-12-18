package steven;


import java.util.Collections;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;


public class CatalogMaker {

	private ArrayList<Computer> arr;
	public CatalogMaker() {
		arr=new ArrayList<Computer>();
		arr.add(new Computer(10,10,"i7","gtx1080"));
		arr.add(new Computer(15,4,"i5","gtx980"));
		arr.add(new Computer(16,1,"i5","gtx780"));
	}

	public static void main(String[] args) {
		CatalogMaker maker=new CatalogMaker();
		System.out.println(maker.getCsvContent());
		Scanner in=new Scanner(System.in);
		String s;
		while(true) {
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
			maker.saveAsCsv();
			
		}
	}
	
	public String getCsvContent() {
		String data="";
		for(Computer c:arr) {
			data+=c+"\n";
		}
		return data;
	}
	
	public void saveAsCsv() {
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
