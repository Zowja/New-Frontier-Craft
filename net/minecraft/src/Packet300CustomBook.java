package net.minecraft.src;

import io.netty.buffer.ByteBuf;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Packet300CustomBook extends Packet {
	private String strarray[], author, date, title, origin;
	public boolean signbook;
	private int compsize, strnum;
	public NBTTagCompound compound;

	public Packet300CustomBook() {
	}

	public Packet300CustomBook(boolean sign, NBTTagCompound comp) {
		signbook = sign;
		if (comp != null) {
			strnum = comp.getTagList("pages").tagCount();
			compsize = 0;
			for (int i = 0; i < 100; i++)
				compsize += comp.getTagList("pages").getStringTagAt(i).length();

			if (compsize >= 32767) {
				throw new IllegalArgumentException(
						"Payload may not be larger than 32k");
			} else {
				strarray = new String[strnum];
				for (int i = 0; i < strnum; i++) {
					strarray[i] = comp.getTagList("pages").getStringTagAt(i);
				}
				if (sign) {
					author = comp.getString("author");
					date = comp.getString("date");
					title = comp.getString("title");
					origin = comp.getString("origin");
				}
			}
		}

	}

	/**
	 * Reads the raw packet data from the data stream.
	 */

	/**
	 * Writes the raw packet data to the data stream.
	 */

	public void readPacketData(DataInputStream datainputstream)
			throws IOException {
		compsize = datainputstream.readShort();
		if (compsize > 0) {
			signbook = datainputstream.readBoolean();
			compound = new NBTTagCompound();
			NBTTagList list = new NBTTagList();
			compound.setTag("pages", list);
			strnum = datainputstream.readShort();
			for (int i = 0; i < strnum; i++) {
				list.appendTag(new NBTTagString(
						readString(datainputstream, 256)));
			}
			if (signbook) {
				author = readString(datainputstream, 60);
				date = readString(datainputstream, 60);
				title = readString(datainputstream, 60);
				origin = readString(datainputstream, 60);
				compound.setTag("author", new NBTTagString(author));
				compound.setTag("date", new NBTTagString(date));
				compound.setTag("title", new NBTTagString(title));
				compound.setTag("origin", new NBTTagString(origin));
			}
		}

	}

	public void writePacketData(DataOutputStream dataoutputstream)
			throws IOException {
		dataoutputstream.writeShort((short) compsize);
		if (compsize > 0) {
			dataoutputstream.writeBoolean(signbook);
			dataoutputstream.writeShort((short) strnum);
			for (int i = 0; i < strnum; i++) {
				writeString(strarray[i], dataoutputstream);
			}
			if (signbook) {
				writeString(author, dataoutputstream);
				writeString(date, dataoutputstream);
				writeString(title, dataoutputstream);
				writeString(origin, dataoutputstream);
			}
		}

	}

	public void processPacket(NetHandler nethandler) {
		nethandler.handleBook(this);
	}

	public int getPacketSize() {
		return 4 + compsize;
	}

}
