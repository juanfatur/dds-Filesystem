public interface File {
	Bloque syncRead(int bytesALeer);
	Bloque asyncRead(int bytesALeer);
}
