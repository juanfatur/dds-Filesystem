import java.util.*;

public class Bloque {
	byte[] bytes;
	
	int tamanio() {
		return bytes.length;
	}
	
	List<Bloque> dividirEnBloques(int tamanioParticion){
		List<Bloque> lista = new ArrayList<Bloque>();
		int tamanioLista;
		int puntero = 0;
		if(this.tamanio()%tamanioParticion == 0) 
			tamanioLista = this.tamanio()/tamanioParticion; 
		else tamanioLista = this.tamanio()/tamanioParticion +1;
		for(int i = 0;i<tamanioLista;i++) {
			Bloque nuevoBloque = new Bloque();
			byte[] bytesNuevos = new byte[tamanioParticion];
			int j;
			for(j=0;j<tamanioParticion && puntero<this.tamanio();j++,puntero++) {
				System.out.println("Creando bloque " + i + ", byte numero " + j + ", y el puntero esta en " + puntero);
				bytesNuevos[j] = bytes[puntero];
			}
			nuevoBloque.setBytes(bytesNuevos, j);
			lista.add(nuevoBloque);
		}
		
		return lista;
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
