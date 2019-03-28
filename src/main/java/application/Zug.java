package application;

public class Zug {
	private String zugnummer;
	private String zugname;
	private String fahrstufe;
	
	public Zug (String zugnummer, String zugname, String fahrstufe) {
		this.zugnummer = zugnummer;
		this.zugname = zugname;
		this.fahrstufe = fahrstufe;
	}

	public String getZugnummer() {
		return zugnummer;
	}

	public void setZugnummer(String zugnummer) {
		this.zugnummer = zugnummer;
	}

	public String getZugname() {
		return zugname;
	}

	public void setZugname(String zugname) {
		this.zugname = zugname;
	}

	public String getFahrstufe() {
		return fahrstufe;
	}

	public void setFahrstufe(String fahrstufe) {
		this.fahrstufe = fahrstufe;
	}
}
