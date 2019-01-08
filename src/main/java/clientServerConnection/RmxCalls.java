package clientServerConnection;

public class RmxCalls {

		//Konstanten des RMX-Protokolls

		public static final byte HEADBYTE = 0x7c;
		public static final byte RMXVERSION = 0x01;

		// Wichtige RMX-Default-Pakete bzw. statische Pakete
		
		public static final byte[] Positivquittung = new byte[] { HEADBYTE,
				0x04, 0x00, 0x00 };
		public static final byte[] UnknownOPCODE = new byte[] { HEADBYTE,
				0x04, 0x0f, 0x00 };
		public static final byte[] Initialisieren = new byte[] { HEADBYTE, 0x05,
				0x03, 0x02, RMXVERSION };
		public static final byte[] ZugInfo = new byte[] { HEADBYTE, 0x04, 0x08, 0x01 };
		public static final byte[] Status = new byte[] { HEADBYTE, 0x03, 0x04 };
		public static final byte[] PowerOn = new byte[] { HEADBYTE, 0x04, 0x03,
				(byte) 128 };
		public static final byte[] PowerOff = new byte[] { HEADBYTE, 0x04,
				0x03, 0x40 };
		public static final byte[] Notfall = new byte[] { HEADBYTE, 0x04, 0x03,
				0x08 };

		//Konstanten des Verbindungsstatus
		
		private static final int NULL = 0;
		private static final int CONNECTING = 1;
		private static final int CONNECTED = 2;
		private static final int DISCONNECTING = 3;
		private static final int DISCONNECTED = 4;
		
		private static int Verbindung = DISCONNECTED;
		
		public int getVerbindung() {
			return Verbindung;
		}
		
		public int setVerbindungNULL() {
			return Verbindung = NULL;
		}
		public int setVerbindungCONNECTING() {
			return Verbindung = CONNECTING;
		}
		public int setVerbindungCONNECTED() {
			return Verbindung = CONNECTED;
		}
		public int setVerbindungDISCONNECTING() {
			return Verbindung = DISCONNECTING;
		}
		public int setVerbindungDISCONNECTED() {
			return Verbindung = DISCONNECTED;
		}
		
		//Konverter:
		
		/**
		 * Dezimalen int-Wert in 2 Bytes
		 * (highByte und lowByte)
		 * 
		 * @param value
		 * @return byte[] - Byte-Array (highByte/lowByte)
		 */
		protected static byte[] intToBytes(int value) {
			byte[] byteValue = new byte[2];
		
			byteValue[1] = (byte) (value & 0xFF);
			byteValue[0] = (byte) ((value >> 8) & 0xFF);
		
			return byteValue;
		}
		
		/** Array zu Hexadezimal(Hex32)
		 * 
		 * @param toPrint
		 */
		
	protected void Hexaprint(byte[] toPrint) {
		for (int i = 0; i < toPrint.length; i++) {
			System.out.print(String.format("0x%02X", ((byte) toPrint[i])) + " ");
			}
		}
	
		//Zugbefehle:
	
	public static void LokSpeed(int trainNumber, int runningNotch, byte direction) {
		// <0x7c><0x07><0x24><ADRH><ADRL><SPEED><DIR> 
		//  [0]   [1]   [2]   [3]   [4]    [5]   [6]
		
		// Rumpf formen
		byte[] byteToSend = new byte[] { HEADBYTE, 0x07, 0x24, 0x00,
				0x00, (byte) runningNotch, direction };
		
		// Loknummer konvertieren
		byte[] trainAddress = intToBytes(trainNumber);
		
		// Loknummer schreiben
		byteToSend[3] = trainAddress[0];
		byteToSend[4] = trainAddress[1];
	}
	
	//Negativquittung Fälle
	
	private void NegCases(byte[] message) {
		// <0x01><0x0?>
		
		switch (message[1]) {
		case 1: // Hex: 0x01
			// 0x01: unbekannter OPCODE
			System.out.println("Server: unknown OPCODE");
			break;
		case 3: // Hex: 0x03
			// Loknummer nicht in Datenbank
			System.out.println("Server: train number not in database");
			break;
		case 4: // Hex: 0x04
			// Eingabefehler
			System.out.println("Server: input-error");
			break;
		case 5: // Hex: 0x05
			// Mode ungleich 0x01 
			System.out.println("Server: mode is not 0x01");
			break;
		case 7: // Hex: 0x07
			// Eingabe Lokomotiven Datenbank voll 
			System.out.println("Server: train data base full");
			break;
		case 8: // Hex: 0x08
			// Steuerkanäle belegt
			System.out.println("Server: control channel occupied");
			break;
		}
	}
		
		
		
}
