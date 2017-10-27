package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet301Score extends Packet {
	
	public Packet301Score()
	{
		
	}
	
	public void readPacketData(DataInputStream input) throws IOException
	{
		id = input.readInt();
		score = input.readInt();		
	}

	public void writePacketData(DataOutputStream output) throws IOException
	{
		
	}

	public void processPacket(NetHandler handler)
	{
		handler.handleScore(this);
	}

	public int getPacketSize()
	{
		return 8;
	}
	
	public int id;
	public int score;
}