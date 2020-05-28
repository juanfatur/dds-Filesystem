public interface File {
	Bloque syncRead(int bytesALeer);
	Bloque asyncRead(int bytesALeer);
	void syncWrite(Bloque bloque);
	void close();
}
