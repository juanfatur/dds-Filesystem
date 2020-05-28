import java.util.function.Consumer;

public class MockFileSystem implements LowLevelFileSystem {
	
	int pointer=0;

	@Override
	public int openFile(String path) {
		System.out.println("Archivo abierto");
		return 1;
		
	}

	@Override
	public void closeFile(int fd) {
		System.out.println("Archivo cerrado");
	}

	@Override
	public int syncReadFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd) {
		int cantidadLeida = 0;
		for(int i = bufferStart;i<=bufferEnd; i++) {
			cantidadLeida++;
			bufferBytes[i] = (byte) pointer++;
		}
		return cantidadLeida;
	}

	@Override
	public void syncWriteFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd) {
		

	}

	@Override
	public void asyncReadFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd, Consumer<Integer> callback) {
		byte byteAEscribirEnBuffer = 0;
		int cantidadLeida = 0;
		for(int i = bufferStart;i<=bufferEnd; i++) {
			cantidadLeida++;
			bufferBytes[i] = byteAEscribirEnBuffer++;
		}
		callback.accept(cantidadLeida);

	}

}
