
public class MockFileInHardDrive {
	byte[] content;
	public byte readByteInPosition(int pos) {
		return content[pos];
	}
}
