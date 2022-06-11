package Instruments;

import java.util.ArrayList;
import java.util.List;

public class Mock {
	
	private List<instrument> instrumentList = new ArrayList<>();
	
	public Mock() {
		this.instrumentList.add(new instrument(0, "Piano", "Yamaha", 2457.67f));
		this.instrumentList.add(new instrument(1, "Violin", "Edgar Russ", 4001.0f));
		this.instrumentList.add(new instrument(2, "Kalimba", "Thomann", 5600.6f));
	}

	public List<instrument> getInstrumentList() {
		return instrumentList;
	}

	public void setInstrumentList(List<instrument> instrumentList) {
		this.instrumentList = instrumentList;
	}
	
}
