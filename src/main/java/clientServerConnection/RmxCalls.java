package clientServerConnection;

import java.io.UnsupportedEncodingException;

public class RmxCalls {

	// Konstanten des RMX-Protokolls

	public static final byte HEADBYTE = 0x7c;
	public static final byte RMXVERSION = 0x01;

	// Wichtige RMX-Default-Pakete bzw. statische Pakete

	public static final byte[] Positivquittung = new byte[] { HEADBYTE, 0x04, 0x00, 0x00 };
	public static final byte[] UnknownOPCODE = new byte[] { HEADBYTE, 0x04, 0x0f, 0x00 };
	public static final byte[] Initialisieren = new byte[] { HEADBYTE, 0x05, 0x03, 0x02, RMXVERSION };
	public static final byte[] ZugInfo = new byte[] { HEADBYTE, 0x04, 0x08, 0x01 };
	public static final byte[] Status = new byte[] { HEADBYTE, 0x03, 0x04 };
	public static final byte[] PowerOn = new byte[] { HEADBYTE, 0x04, 0x03, (byte) 128 };
	public static final byte[] PowerOff = new byte[] { HEADBYTE, 0x04, 0x03, 0x40 };
	public static final byte[] Notfall = new byte[] { HEADBYTE, 0x04, 0x03, 0x08 };
	

	// Konstanten des Verbindungsstatus

	private static final int NULL = 0;
	private static final int CONNECTED = 2;
	private static final int DISCONNECTED = 4;

	private static int Verbindung = DISCONNECTED;

	public int getVerbindung() {
		return Verbindung;
	}

	public int setVerbindungNULL() {
		return Verbindung = NULL;
	}

	public int setVerbindungCONNECTED() {
		return Verbindung = CONNECTED;
	}

	public int setVerbindungDISCONNECTED() {
		return Verbindung = DISCONNECTED;
	}

	// Konverter:

	/**
	 * Konvertiert bytes[] zu hexabytes
	 * 
	 * @param toPrint
	 */
	public void Hexaprint(byte[] toPrint) {
		for (int i = 0; i < toPrint.length; i++) {
			System.out.print(String.format("0x%02X", ((byte) toPrint[i])) + " ");
		}
	}

	/**
	 * Dezimalen int-Wert in 2 Bytes (highByte und lowByte)
	 * 
	 * @param value
	 * @return byte[] - Byte-Array (highByte/lowByte)
	 */
	public byte[] intToBytes(int value) {
		byte[] byteValue = new byte[2];

		byteValue[1] = (byte) (value & 0xFF);
		byteValue[0] = (byte) ((value >> 8) & 0xFF);

		return byteValue;
	}
	
	public byte intToByte(int value) {
		byte byteValue = (byte) (value & 0xFF);
		return byteValue;
	}

	/**
	 * Array zu Hexadezimal(Hex32)
	 * 
	 * @param toPrint
	 */

	public String ASCIIprint(byte[] bytes) throws UnsupportedEncodingException {

		String fertig = null;
		String string = new String(bytes, "ASCII");
		String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890|";
		char[] alphabetArray = alphabetString.toCharArray();

		for (int i = 13; i < string.length(); i++) {

			char charsbby = string.charAt(i);

			for (int j = 0; j < alphabetArray.length; j++) {
				char c = alphabetArray[j];

				if (charsbby == c) {
					fertig = "" + charsbby;
					//System.out.print(fertig.replace("|", " "));
				}
			}
			String[] words = fertig.split("\\s+");
			for (int o = 0; o < words.length; o++) {
				words[o] = words[o].replaceAll("[^\\w]", "");
			}
			for (int counter = 0; counter < words.length; counter++) {
				System.out.print(words[counter]);
			}
		}
		return fertig;
	}

}
