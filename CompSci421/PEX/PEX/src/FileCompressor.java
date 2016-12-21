import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCompressor {
	
	int SIZE = 128;

	String string;
	HuffmanNode nodeAll;

	public FileCompressor() {

		string = "";
		nodeAll = new HuffmanNode(null);
	}

	public void compressFile(String filename) {

		string = filename;

		// Builds the Huffman Data Table
		HuffmanData[] data = frequencyArray(filename);

		// Makes a Huffman Node
		HuffmanNode[] node = buildHuffmanNodeArray(data);

		// Makes a Priority Queue - heap.java
		HuffmanTreePQ pq = new HuffmanTreePQ();

		// Build the Huffman tree
		pq = buildHuffPQ(node);
		mergeNodes(pq);
		nodeAll = pq.deQueue();

		String[] code = new String[SIZE];
		String encode = "";

		BuildHuffCodeTbl(nodeAll, encode, code);

		String decode = filename;
		String encodedFile = filename + "-encoded";

		try {
			String encoded = "";

			int next = 0;
			FileInputStream input = new FileInputStream(decode);
			PrintWriter printWriter = new PrintWriter(encodedFile);

			while (next != -1) {

				while (((next = input.read()) != -1)) {
					char c = (char) next;

					if (c != (char) 0)
						encoded += code[(int) c];
				}

			}
			printWriter.print(encoded);

			// Close printWriter
			printWriter.close();
			input.close();

			//Catches Exceptions
		} catch (Exception e) {
			System.err.println("File not found.");
		}

	}

	public void decompressFile(String input) {

		String decode = input;
		String decodedFileEnding = string + "-decoded";

		try {

			int next = 0;
			FileInputStream stream = new FileInputStream(decode);
			PrintWriter pw = new PrintWriter(decodedFileEnding);

			while (next != -1) {

				HuffmanNode node = nodeAll;

				while ((node.getRight() != null || node.getLeft() != null) && ((next = stream.read()) != -1)) {

					char temp = (char) next;

					if (temp == '0') {
						node = node.getLeft();
					}
					if (temp == '1') {
						node = node.getRight();
					}
				}

				if (node.getData().getIndex() != 0) {
					pw.print((char) node.getData().getIndex());
				}
			}

			// Close printWriter
			pw.close();
			stream.close();

			//Catches Exceptions
		} catch (Exception e) {
			System.out.println("An exception was caught");
			System.exit(0);
		}
	}

	private HuffmanNode[] buildHuffmanNodeArray(HuffmanData[] data) {

		HuffmanNode[] nodeArray = new HuffmanNode[SIZE];

		for (int i = 0; i < SIZE; i++) {

			nodeArray[i] = new HuffmanNode(data[i]);

		}

		return nodeArray;

	}

	private void mergeNodes(HuffmanTreePQ pq) {

		while (pq.size() > 1) {

			HuffmanNode smallestA = pq.deQueue();
			HuffmanNode smallestB = pq.deQueue();
			HuffmanData frequency = new HuffmanData(smallestA.getData().getFreq() + smallestB.getData().getFreq());
			HuffmanNode node = new HuffmanNode(frequency);

			node.setLeft(smallestA);
			node.setRight(smallestB);
			smallestA.setParent(node);
			smallestB.setParent(node);

			pq.enQueue(node);
		}

	}

	private void BuildHuffCodeTbl(HuffmanNode node, String str, String[] code) {
		if (node.getLeft() != null) {
			BuildHuffCodeTbl(node.getLeft(), str + "0", code);
		}
		if (node.getRight() != null) {
			BuildHuffCodeTbl(node.getRight(), str + "1", code);
		}
		if (node.getLeft() == null && node.getRight() == null)

			code[node.getData().getIndex()] = str;

	}

	private HuffmanTreePQ buildHuffPQ(HuffmanNode[] node) {

		HuffmanTreePQ pq = new HuffmanTreePQ();

		for (int i = 0; i < SIZE; i++) {
			if (node[i].getData().getFreq() != 0) {
				pq.enQueue(node[i]);
			}
		}

		return pq;

	}

	private HuffmanData[] frequencyArray(String filename) {

		File file = new File(filename);

		HuffmanData[] data = new HuffmanData[SIZE];

		for (int i = 0; i < SIZE; i++) {
			data[i] = new HuffmanData(i, 0);
		}

		try {
			Scanner scan = new Scanner(file);

			scan.useDelimiter("");

			int index = -1;
			String previous = "";
			boolean first = true;

			while (scan.hasNext()) {
				String next = scan.next();
				if (next == "/" && first) {
					previous = "/";
					first = false;
					continue;
				} else if (next == "/" && first == false && previous == "/") {
					next = "\n";
					first = true;
				} else if (next == "/" && first == false && previous != "/") {
					next = " ";
					first = true;
				}
				char IndexChar = next.charAt(0);
				index = (int) IndexChar;

				// System.out.println(IndexChar + " the ascii: " + ASCIIindex);
				if (index != -1)
					data[index].incrementFreq();

			}
			scan.close();

			//Catching Exceptions
		} catch (FileNotFoundException e) {
			System.err.println("File can't find.");
			System.exit(0);
		}
		return data;
	}
}
