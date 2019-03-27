package application;

import java.util.ArrayList;
import java.util.Arrays;

import datenbank.ReadFromTable;

public class TestKlasse {
	
	public static void main(String[] args) { 
		ReadFromTable r = new ReadFromTable();
		String b = r.getData();
		String[] h = b.split(";");
		Integer[] n = new Integer[h.length/2];
		int j = 0;
		
		System.out.println(h.length);
		
		for(int i=0; i<= h.length;i+=2){
			n[j] = Integer.parseInt(h[i].toString());
			j++;
		}
		
		//Gibt alle Zugnummern aus und speichert sie in als Integer in n
		if(h != null && h.length != 0) {
			for(int i=0; i<= h.length;i+=2){
				n[j] = Integer.parseInt(h[i].toString());
				j++;
			System.out.println(n[j].toString());
			}
		}
		// aus 100 Array alle vergebenen Zahlen löschen
		Integer[] array = new Integer[100];
		
		//Array mit 100 Elementen 0-99 erstellen
		for (int i = 0; i < array.length; i++) {
				array[i] = i;
				}
		
		for (int i = 0; i <n.length ; i++) {
			int a = n[i];
			array[a] = null;
			}
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
		}

}
