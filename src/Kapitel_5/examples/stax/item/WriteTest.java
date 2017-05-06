package Kapitel_5.examples.stax.item;

public final class WriteTest {

	private WriteTest(){};

	public static void main(String[] args) {
		StAXWriter configFile = new StAXWriter();
		configFile.setFile("config2.xml");
		try {configFile.saveConfig();}
		catch (Exception e) {e.printStackTrace();}
	}
}

