package crud;

import Instruments.instrument;

import fileIO.FileIO;
import fileIO.FileIOInterface;

public class FileCrud implements Lab2CrudInterface {

	FileIOInterface fio;
	
	public FileCrud() {
		this.fio = new FileIO();
	}
	
	@Override
	public instrument readInstrument() {
		
		return (instrument) fio.loadFromFile();
	}

	@Override
	public void updateInstrument(instrument Instruments) {
		
		fio.saveToFile(Instruments);
		
	}
}
