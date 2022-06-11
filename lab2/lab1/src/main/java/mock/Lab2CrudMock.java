package mock;

import Instruments.instrument;

import crud.Lab2CrudInterface;

public class Lab2CrudMock implements Lab2CrudInterface {

	@Override
	public instrument readInstrument() {
		// TODO Auto-generated method stub
		return new instrument("Guitar", "Epiphone Blue Electric Guitar", 1249.5f);
	}

	@Override
	public void updateInstrument(instrument Instruments) {
		// TODO Auto-generated method stub

	}
}
