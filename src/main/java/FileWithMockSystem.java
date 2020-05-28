public class FileWithMockSystem implements File {
	Bloque bloqueAsync = new Bloque();
	LowLevelFileSystem filesystem;
	int fd;
	
	FileWithMockSystem(String path){
		filesystem = new MockFileSystem();
		fd = filesystem.openFile(path); //El archivo se abre al crearse su instancia
	}
	
	public Bloque syncRead(int bytesALeer) {
		byte[] buffer = new byte[bytesALeer];
		int bytesLeidos = filesystem.syncReadFile(fd, buffer, 0, bytesALeer-1);
		Bloque bloqueLeido = new Bloque();
		bloqueLeido.setBytes(buffer,bytesLeidos);
		return bloqueLeido;
	}
	
	public Bloque asyncRead(int bytesALeer) {
		byte[] buffer = new byte[bytesALeer];
		filesystem.asyncReadFile(fd, buffer, 0, bytesALeer-1,i -> {
			Bloque bloqueLeido = this.bloqueAsync;
			bloqueLeido.setBytes(buffer,i);
		}
		); 
		return bloqueAsync;
	}
	
	public void syncWrite(Bloque bloque) {
		filesystem.syncWriteFile(fd, bloque.getBytes(), 0, bloque.tamanio());
	}
	
	public void close() {
		filesystem.closeFile(fd);
	}
	

}
