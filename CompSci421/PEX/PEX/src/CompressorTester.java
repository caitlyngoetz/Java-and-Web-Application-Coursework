

public class CompressorTester
{

	public static void main(String[] args)
	{
		FileCompressor compressor;
		if(args.length != 1)
		{
			System.out.println("Not enough arguments.");
		}
		else
		{
				compressor = new FileCompressor();
				System.out.println("compressing file - " + args[0] + "...");
				compressor.compressFile(args[0]);
				System.out.println("done");
				System.out.println("decompressing file - " + args[0] + "-encoded..." );
				compressor.decompressFile(args[0] + "-encoded");
				System.out.println("done");
		}
	}

}
