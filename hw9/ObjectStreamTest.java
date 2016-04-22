package hw.hw9;

import java.io.*;
import java.util.*;

// An example of how to use object streams.
// Note that the objects you write to the stream
// must implement the Serializable interface.

// The various stream methods all throw IOExceptions.
// The readObject method also throws a ClassNotFound exception.
// For simplicity I am not catching them, although I ought to.


public class ObjectStreamTest {
	public static void main(String[] args) 
			throws IOException, ClassNotFoundException {

		OutputStream os = new FileOutputStream("output.dat");
		ObjectOutputStream output = new ObjectOutputStream(os);
		output.writeInt(3);
		output.writeObject("abc");
		Collection<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		output.writeObject(list);
		Dummy d = new Dummy(1);
		output.writeObject(d);
		output.close();

		InputStream is = new FileInputStream("output.dat");
		ObjectInputStream input = new ObjectInputStream(is);
		int x = input.readInt();
		String y = (String) input.readObject();
		Collection<String> z = (Collection<String>) input.readObject();
		Dummy d2 = (Dummy) input.readObject();
		input.close();

		System.out.println(x);
		System.out.println(y);
		for (String s : z)
			System.out.println(s);
		System.out.println(d2.getInfo());
	}
}

class Dummy implements Serializable {
	private int x;

	public Dummy(int n) {
		x = n;
	}

	public int getInfo() {
		return x;
	}
}

