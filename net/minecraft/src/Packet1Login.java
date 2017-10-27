// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;
import java.util.UUID;

import com.mojang.util.UUIDTypeAdapter;

// Referenced classes of package net.minecraft.src:
//            Packet, NetHandler

public class Packet1Login extends Packet {

	public Packet1Login() {
	}

	public Packet1Login(String s, UUID b, int i) {
		username = s;
		id = b;
		protocolVersion = i;
	}

	public void readPacketData(DataInputStream datainputstream)
			throws IOException {
		protocolVersion = datainputstream.readInt();
		username = readString(datainputstream, 16);
		mapSeed = datainputstream.readLong();
		dimension = datainputstream.readByte();
		String read = readString(datainputstream, 36);
        if(read.equals("")){
        	id = null;
        } else
        id =  UUIDTypeAdapter.fromString(read);
	}

	public void writePacketData(DataOutputStream dataoutputstream)
			throws IOException {
		dataoutputstream.writeInt(protocolVersion);
		writeString(username, dataoutputstream);
		dataoutputstream.writeLong(mapSeed);
		dataoutputstream.writeByte(dimension);
		if(id == null){
        	writeString("", dataoutputstream);
        } else
        writeString(id.toString(), dataoutputstream);
	}

	public void processPacket(NetHandler nethandler) {
		nethandler.handleLogin(this);
	}

	public int getPacketSize() {
		return 4 + username.length() + 4 + 5;
	}

	public int protocolVersion;
	public String username;
	public long mapSeed;
	public byte dimension;
	public UUID id;
}
