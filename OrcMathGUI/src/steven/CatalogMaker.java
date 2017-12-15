package steven;

import java.util.ArrayList;
import java.util.Collections;

public class CatalogMaker {

	private ArrayList<Computer> arr;
	public CatalogMaker() {
		arr=new ArrayList<Computer>();
		arr.add(new Computer(10,10,"i7","gtx1080"));
		arr.add(new Computer(15,4,"i5","gtx980"));
		arr.add(new Computer(16,1,"i5","gtx780"));
	}

	public static void main(String[] args) {
		CatalogMaker a=new CatalogMaker();
		
	}
	
	public String getCsvContent() {
		String data="";
		for(Computer c:arr) {
			data+=c+"\n";
		}
		return data;
	}

}
