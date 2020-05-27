import java.util.function.Consumer;

public class FileSystemWindows implements LowLevelFileSystem {

	@Override
	public int openFile(String path) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void closeFile(int fd) {
		// TODO Auto-generated method stub

	}

	@Override
	public int syncReadFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void syncWriteFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void asyncReadFile(int fd, byte[] bufferBytes, int bufferStart, int bufferEnd, Consumer<Integer> callback) {
		// TODO Auto-generated method stub

	}

}
