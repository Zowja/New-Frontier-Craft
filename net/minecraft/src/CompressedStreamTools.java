// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package net.minecraft.src:
//            NBTBase, NBTTagCompound

public class CompressedStreamTools {

	public CompressedStreamTools() {
	}

	public static NBTTagCompound func_1138_a(InputStream inputstream)
			throws IOException {
		DataInputStream datainputstream = new DataInputStream(
				new GZIPInputStream(inputstream));
		try {
			NBTTagCompound nbttagcompound = func_1141_a(datainputstream);
			return nbttagcompound;
		} finally {
			datainputstream.close();
		}
	}

	public static void writeGzippedCompoundToOutputStream(
			NBTTagCompound nbttagcompound, OutputStream outputstream)
			throws IOException {
		DataOutputStream dataoutputstream = new DataOutputStream(
				new GZIPOutputStream(outputstream));
		try {
			func_1139_a(nbttagcompound, dataoutputstream);
		} finally {
			dataoutputstream.close();
		}
	}

	public static NBTTagCompound func_1141_a(DataInput datainput)
			throws IOException {
		NBTBase nbtbase = NBTBase.readTag(datainput);
		if (nbtbase instanceof NBTTagCompound) {
			return (NBTTagCompound) nbtbase;
		} else {
			throw new IOException("Root tag must be a named compound tag");
		}
	}

	public static void func_1139_a(NBTTagCompound nbttagcompound,
			DataOutput dataoutput) throws IOException {
		NBTBase.writeTag(nbttagcompound, dataoutput);
	}

	public static NBTTagCompound decompress(byte[] par0ArrayOfByte)
			throws IOException {
		DataInputStream var1 = new DataInputStream(new BufferedInputStream(
				new GZIPInputStream(new ByteArrayInputStream(par0ArrayOfByte))));
		NBTTagCompound var2;

		try {
			var2 = read(var1);
		} finally {
			var1.close();
		}

		return var2;
	}

	public static byte[] compress(NBTTagCompound par0NBTTagCompound)
			throws IOException {
		ByteArrayOutputStream var1 = new ByteArrayOutputStream();
		DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1));

		try {
			write(par0NBTTagCompound, var2);
		} finally {
			var2.close();
		}

		return var1.toByteArray();
	}

	public static NBTTagCompound read(DataInput par0DataInput)
			throws IOException {
		NBTBase var1 = func_150664_a(par0DataInput, 0);

		if (var1 instanceof NBTTagCompound) {
			return (NBTTagCompound) var1;
		} else {
			throw new IOException("Root tag must be a named compound tag");
		}
	}

	private static void func_150663_a(NBTBase p_150663_0_,
			DataOutput p_150663_1_) throws IOException {
		p_150663_1_.writeByte(p_150663_0_.getType());

		if (p_150663_0_.getType() != 0) {
			p_150663_1_.writeUTF("");
			p_150663_0_.writeTagContents(p_150663_1_);
		}
	}

	public static void write(NBTTagCompound par0NBTTagCompound,
			DataOutput par1DataOutput) throws IOException {
		func_150663_a(par0NBTTagCompound, par1DataOutput);
	}

	private static NBTBase func_150664_a(DataInput p_150664_0_, int p_150664_1_)
			throws IOException {
		byte var2 = p_150664_0_.readByte();

		if (var2 == 0) {
			return new NBTTagEnd();
		} else {
			p_150664_0_.readUTF();
			NBTBase var3 = NBTBase.func_150284_a(var2);

			try {
				var3.readTagContents(p_150664_0_);
				return var3;
			} catch (IOException var7) {

			}
		}
		return null;
	}

	public static NBTTagCompound writeMapToFileUncompressed(File file)
		    throws IOException
		    {
		        if (!file.exists())
		        {
		            return null;
		        }
		        DataInputStream datainputstream = new DataInputStream(new FileInputStream(file));
		        try
		        {
		            NBTTagCompound nbttagcompound = read(datainputstream);
		            return nbttagcompound;
		        }
		        finally
		        {
		            datainputstream.close();
		        }
		    }
	
	public static void saveMapToFileWithBackup(NBTTagCompound nbttagcompound, File file)
		    throws IOException
		    {
		        File file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append("_tmp").toString());
		        if (file1.exists())
		        {
		            file1.delete();
		        }
		        saveMapToFile(nbttagcompound, file1);
		        if (file.exists())
		        {
		            file.delete();
		        }
		        if (file.exists())
		        {
		            throw new IOException((new StringBuilder()).append("Failed to delete ").append(file).toString());
		        }
		        else
		        {
		            file1.renameTo(file);
		            return;
		        }
		    }
	
	public static void saveMapToFile(NBTTagCompound nbttagcompound, File file)
		    throws IOException
		    {
		        DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(file));
		        try
		        {
		            writeTo(nbttagcompound, dataoutputstream);
		        }
		        finally
		        {
		            dataoutputstream.close();
		        }
		    }
	
	public static void writeTo(NBTTagCompound nbttagcompound, DataOutput dataoutput)
		    throws IOException
		    {
		        NBTBase.writeTag(nbttagcompound, dataoutput);
		    }


}
