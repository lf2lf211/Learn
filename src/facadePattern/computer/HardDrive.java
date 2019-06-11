package facadePattern.computer;

public class HardDrive {
	public byte[] read(long lba, int size) {
		System.out.println("Walk read");
		return "1".getBytes();
	}
}
