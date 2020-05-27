
public class FileWindows implements File {
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

}
