package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet302PlayerList extends Packet {

	public void readPacketData(DataInputStream in) throws IOException
	{
		players = in.readInt();
		usernames = new String[players];
		scores = new int[players];
		for(int i = 0; i < players; i++)
		{
			usernames[i] = in.readUTF();
		}
		for(int i = 0; i < players; i++)
		{
			scores[i] = in.readInt();
		}
	}

	public void writePacketData(DataOutputStream out) throws IOException
	{
		
	}
	
	public void processPacket(NetHandler nethandler)
	{
		nethandler.handleList(this);
	}

	public int getPacketSize()
	{
		return players;
	}
	
	private int players;
	public String[] usernames;
    public int[] scores;
}
