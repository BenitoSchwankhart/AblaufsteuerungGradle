package clientServerConnection;

public class RmxCalls {

	// Konstanten des RMX-Protokolls
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
		public static final byte[] Nofall = new byte[] { HEADBYTE, 0x04, 0x03,
				0x08 };

		// Konstanten des Verbindungsstatus
		private static final int NULL = 0;
		private static final int CONNECTING = 1;
		private static final int CONNECTED = 2;
		private static final int DISCONNECTING = 3;
		private static final int DISCONNECTED = 4;
		
		private static int Verbindung = DISCONNECTED;
		
		public static int getVerbindung() {
			return Verbindung;
		}
		
		public static int setVerbindungNULL() {
			return Verbindung = NULL;
		}
		public static int setVerbindungCONNECTING() {
			return Verbindung = CONNECTING;
		}
		public static int setVerbindungCONNECTED() {
			return Verbindung = CONNECTED;
		}
		public static int setVerbindungDISCONNECTING() {
			return Verbindung = DISCONNECTING;
		}
		public static int setVerbindungDISCONNECTED() {
			return Verbindung = DISCONNECTED;
		}
		
		
		
		
}
