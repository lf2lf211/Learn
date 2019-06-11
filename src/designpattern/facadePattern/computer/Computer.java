package designpattern.facadePattern.computer;

public class Computer {
	public void startComputer() {

		CPU cpu = new CPU();
		Memory memory = new Memory();
		HardDrive hardDrive = new HardDrive();

		cpu.freeze();
		memory.load(1, hardDrive.read(1, 1));
		cpu.jump(1);
		cpu.execute();
	}
}
