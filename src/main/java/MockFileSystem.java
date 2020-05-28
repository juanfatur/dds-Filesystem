import java.util.function.Consumer;

public class MockFileSystem implements LowLevelFileSystem {
	
	int pointer=0;
	int readPointer = 0;
	byte[] writtenData = new byte[100];

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
			System.out.println("Leyendo posicion " + readPointer + " del archivo");
			cantidadLeida++;
			bufferBytes[i] = writtenData[readPointer];
			readPointer++;
		}
		return cantidadLeida;
	}

	@Override
	public void syncWriteFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd) {
		System.out.println("Llamado syncWriteFile. A escribir desde " + bufferStart + " hasta " + bufferEnd);
		for(int i=bufferStart;i<=bufferEnd;i++) {
			System.out.println("Escribiendo posicion " + pointer + " del archivo");
			writtenData[pointer] = bufferBytes[i];
			pointer++;
		}
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
