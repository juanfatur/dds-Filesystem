public class FileWindows implements File {
	Bloque bloqueAsync = new Bloque();
	LowLevelFileSystem filesystem;
	int fd;
	
	FileWindows(String path){
		filesystem = new FileSystemWindows();
		fd = filesystem.openFile(path);
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
			bloqueLeido.clear();
			bloqueLeido.setBytes(buffer,i);
		}
		); 
		return bloqueAsync;
	}

}
