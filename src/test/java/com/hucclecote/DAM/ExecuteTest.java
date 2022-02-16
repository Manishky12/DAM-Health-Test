package com.hucclecote.DAM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Properties;
//import java.util.logging.LogManager;

//import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.logging.log4j.Logger;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import java.lang.Iterable;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExecuteTest extends Keywords  {
	
	static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ExecuteTest.class);

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream("C:\\Users\\ampcome\\Documents\\DAM\\objectRepository\\objectrepository.properties");
		prop = new Properties();
		prop.load(file);
		
		Keywords key = new Keywords();
		
		ArrayList data = new ArrayList();
		
		FileInputStream excelfile = new FileInputStream("C:\\Users\\ampcome\\Documents\\DAM\\excelData\\teststeps.xlsx");
		XSSFWorkbook b = new XSSFWorkbook(excelfile);
		XSSFSheet s = b.getSheet("test");
		Iterator<Row> itr = s.iterator();
		while (itr.hasNext()){
			Row rowitr = (Row)itr.next();
			Iterator<Cell> cellitr =  rowitr.cellIterator();
			
			while(cellitr.hasNext()){
				
				Cell celldata =(Cell)cellitr.next();
				
				switch (celldata.getCellType()){
				
				case STRING: 
					data.add(celldata.getStringCellValue());
					break;
				case NUMERIC: 
					data.add(celldata.getNumericCellValue());
					break;
				case BOOLEAN:
					data.add(celldata.getBooleanCellValue());
					break;
				
				}
				
			}
			
		}
		count =1;
		for(int i =0; i<data.size(); i++){
				
				if(data.get(i).equals("openBrowser")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				System.out.print(keyword);
				System.out.print(Data);
				System.out.print(Objectname1);
				System.out.print(runmode);
				if(runmode.equals("yes")){
					key.openBrowser();
				}
			}
			if(data.get(i).equals("navigate")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.navigate(Data);
				}
			}
			if(data.get(i).equals("selectInputDropdown")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectInputDropdown(Data,Objectname1);
				}
			}
			if(data.get(i).equals("openCalender")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.openCalender(Objectname1,Objectname2 );
				}
			}
			if(data.get(i).equals("selectDate")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectDate(Objectname1,Objectname2 );
				}
			}
			if(data.get(i).equals("selectSlot")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectSlot(Objectname1,Objectname2 );
				}
			}
			if(data.get(i).equals("insertDetails")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.insertDetails(Objectname1,Data );
				}
			}
			if(data.get(i).equals("selectFormDropdown")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectFormDropdown(Objectname1,Data);
				}
			}
			if(data.get(i).equals("checkBox")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.checkBox(Objectname1);
				}
			}
			if(data.get(i).equals("selectBtn")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectBtn(Objectname1);
				}
			}
			if(data.get(i).equals("waitforElement")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.waitforElement(Objectname1);
				}
			}
			if(data.get(i).equals("selectinfoDropdown")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectFormDropdown(Objectname1,Data);
				}
			}
			if(data.get(i).equals("continueBtn")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.continueBtn(Objectname1);
				}
			}
			if(data.get(i).equals("addPeople")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.addPeople(Objectname1, Data);
				}
			}
			
			if(data.get(i).equals("selectSlotrec")){
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.selectSlotrec(Objectname1, Objectname2);
				}
			}
			
			if(data.get(i).equals("closeBrowser")){
				
				String keyword = (String) data.get(i);
				String Data = (String) data.get(i+1);
				String Objectname1 = (String) data.get(i+2);
				String Objectname2 = (String) data.get(i+3);
				String runmode = (String) data.get(i+4);
				if(runmode.equals("yes")){
					key.closeBrowser();
					count++;
				}
			}
		}
	}

}

