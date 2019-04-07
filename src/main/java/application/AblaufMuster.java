package application;

import java.io.IOException;
import Zugsteuerung.Funktionssteuerung;
import Zugsteuerung.Zugablauf;
import clientServerConnection.RmxCalls;
import clientServerConnection.thread;
import datenbank.DeleteFromTable;
import datenbank.InsertIntoTable;
import datenbank.ReadFromTable;

public class AblaufMuster {



//Licht, Speed, Warten, Richtungswechsel
	public void Ablauffolge(String speed, String dir, String warten, String licht) throws IOException {
	try {
	ReadFromTable r = new ReadFromTable();
	RmxCalls c = new RmxCalls();
	String k = r.getAblaufReihe(r.getAblaufReihe(r.getNameAktiverZug()));
	String[] u = k.split(";");	
	
	System.out.println(u[0]);
	switch(u[0]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	switch(u[1]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	switch(u[2]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	switch(u[3]) {
	
		
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	switch(u[4]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	switch(u[5]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	switch(u[6]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht.equals("1")) {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		System.out.println("Licht AN");
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));	
		System.out.println("Licht AUS");
		System.out.println(licht);
		thread.sleep(1000* Integer.parseInt(r.getTempLichtTime()));
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug())));
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	thread.sleep(1000* Integer.parseInt(r.getTempSpeedTime()));
	Zugablauf.ZugFahrEinstellungen(nr, c.intToByte(0) , y);
	break;
	
	case "Direction":
	byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
	byte direction = c.intToByte(Integer.parseInt(dir));
	Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("1 Nicht aktiv");
	break;
	}
	
	}
	catch(Exception e) {
		System.out.println("Ablauffehler!");
	}
	ReadFromTable r = new ReadFromTable();
	DeleteFromTable d = new DeleteFromTable();
	d.deleteReihe(r.getZugNrAktiverZug());
	InsertIntoTable i = new InsertIntoTable();
	i.setDefaultReihe(Integer.parseInt(r.getZugNrAktiverZug()));
}
}