package Kapitel_2.exercises.task3;

import java.io.IOException;

public interface BankDataInterface {

	public static final int INT_SIZE = Integer.BYTES;
	public static final int DOUBLE_SIZE = Double.BYTES;
	public static final int FLOAT_SIZE = Float.BYTES;
	public static final int OWNER_SIZE = 15;
	public static final int STRING_SIZE = OWNER_SIZE + 2;
	public static final int RECORD_SIZE = INT_SIZE + DOUBLE_SIZE + FLOAT_SIZE + STRING_SIZE;

	void open(String fileName) throws IOException;

	int find(int accountNumber) throws IOException;

	BankAccount read(int position) throws IOException;

	int size() throws IOException;

	void write(int position, BankAccount account) throws IOException;

	void close() throws IOException;

	void delete(int position) throws IOException;

}
