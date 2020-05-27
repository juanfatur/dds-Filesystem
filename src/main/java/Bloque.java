import java.util.*;

public class Bloque {
	List<Byte> bytes = new ArrayList<>();
	int tamanio() {
		return bytes.size();
	}
	void setBytes(byte[] bytesLeidos,int tamanio) {
		for(int i=0; i<tamanio;i++) {
			bytes.add(bytesLeidos[i]);
		}
	}
	
	void clear() {
		bytes.clear();
	}
}
