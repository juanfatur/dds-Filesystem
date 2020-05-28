import java.util.*;

public interface File {
	Bloque syncRead(int bytesALeer);
	Bloque asyncRead(int bytesALeer);
	void syncWrite(Bloque bloque);
	void syncWrite(List<Bloque> lista);
	void close();
}
