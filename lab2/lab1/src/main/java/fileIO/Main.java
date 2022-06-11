package fileIO;

import Instruments.instrument;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		instrument Instruments = new instrument("Guitar", "Epiphone Blue Electric Guitar", 1249.5f);
		
		FileIOInterface fio = new FileIO();
		
		fio.saveToFile(Instruments);
		System.out.println((instrument) fio.loadFromFile());
	}

}
