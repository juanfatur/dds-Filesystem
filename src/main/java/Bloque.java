import java.util.*;

public class Bloque {
	byte[] bytes;
	
	int tamanio() {
		return bytes.length;
	}
	
	void setBytes(byte[] bytesLeidos,int tamanio) {
		bytes = new byte[tamanio];
		for (int i = 0; i < tamanio; i++) {
	         bytes[i] = bytesLeidos[i];
	      }
	}
	

	
	byte[] getBytes() {
		return bytes;
	}
}
