package application;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

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
	InsertIntoTable i = new InsertIntoTable();
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
		if(licht == "1") {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
	String b = r.getAblaufData();
	String[] j = b.split(";");
	j[4] = dir;
	i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
										Integer.parseInt(dir));
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
		if(licht == "1") {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
		String b = r.getAblaufData();
		String[] j = b.split(";");
		j[4] = dir;
		i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
											Integer.parseInt(dir));
		byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
		byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
		byte direction = c.intToByte(Integer.parseInt(dir));
		Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("2 Nicht aktiv");
	break;
	}
	
	switch(u[2]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht == "1") {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
		String b = r.getAblaufData();
		String[] j = b.split(";");
		j[4] = dir;
		i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
											Integer.parseInt(dir));
		byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
		byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
		byte direction = c.intToByte(Integer.parseInt(dir));
		Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("3 Nicht aktiv");
	break;
	}
	
	switch(u[3]) {
	
		
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht == "1") {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
		String b = r.getAblaufData();
		String[] j = b.split(";");
		j[4] = dir;
		i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
											Integer.parseInt(dir));
		byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
		byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
		byte direction = c.intToByte(Integer.parseInt(dir));
		Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("4 Nicht aktiv");
	break;
	}
	
	switch(u[4]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht == "1") {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
		String b = r.getAblaufData();
		String[] j = b.split(";");
		j[4] = dir;
		i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
											Integer.parseInt(dir));
		byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
		byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
		byte direction = c.intToByte(Integer.parseInt(dir));
		Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("5 Nicht aktiv");
	break;
	}
	
	switch(u[5]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
		if(licht == "1") {
		Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
		}
		else {
		Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
		}
		break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
		String b = r.getAblaufData();
		String[] j = b.split(";");
		j[4] = dir;
		i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
											Integer.parseInt(dir));
		byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
		byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
		byte direction = c.intToByte(Integer.parseInt(dir));
		Zugablauf.ZugRichtung(p, o , direction);
	default:
		System.out.println("6 Nicht aktiv");
	break;
	}
	
	switch(u[6]) {
	
	case "Warten":
	AblaufTime.time(Integer.parseInt(warten));
	thread.sleep(1000* Integer.parseInt(warten));
	System.out.println("Ende");
	break;
	
	case "Licht":
	if(licht == "1") {
	Funktionssteuerung.LichtAn(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen	
	}
	else {
	Funktionssteuerung.LichtAus(c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()))); // Noch in Funktionssteuerung anpassen		
	}
	break;
	
	case "Speed":
	byte nr = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
	byte s = c.intToByte(Integer.parseInt(speed));
	byte y = c.intToByte(Integer.parseInt(r.getAblaufRichtung()));
	Zugablauf.ZugFahrEinstellungen(nr, s , y);
	break;
	
	case "Direction":
		String b = r.getAblaufData();
		String[] j = b.split(";");
		j[4] = dir;
		i.setAktuellAblauf(Integer.parseInt(r.getZugNrAktiverZug()), Integer.parseInt(j[1]), Integer.parseInt(j[2]), Integer.parseInt(j[3]), 
											Integer.parseInt(dir));
		byte p = c.intToByte(Integer.parseInt(r.getZugNrAktiverZug()));
		byte o = c.intToByte(Integer.parseInt(r.getTempFS()));
		byte direction = c.intToByte(Integer.parseInt(dir));
		Zugablauf.ZugRichtung(p, o, direction);
	default:
		System.out.println("7 Nicht aktiv");
	break;
	}
	
	}
	catch(Exception e) {
		System.out.println("Ablauffehler!");
	}
	ReadFromTable r = new ReadFromTable();
	DeleteFromTable d = new DeleteFromTable();
	InsertIntoTable i = new InsertIntoTable();
	d.deleteReihe(r.getZugNrAktiverZug());
	i.setDefaultReihe(Integer.parseInt(r.getZugNrAktiverZug()));
}
}