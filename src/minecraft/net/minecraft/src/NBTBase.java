// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            NBTTagEnd, NBTTagByte, NBTTagShort, NBTTagInt, 
//            NBTTagLong, NBTTagFloat, NBTTagDouble, NBTTagByteArray, 
//            NBTTagString, NBTTagList, NBTTagCompound

public abstract class NBTBase
{

    public NBTBase()
    {
        key = null;
    }

    abstract void writeTagContents(DataOutput dataoutput)
        throws IOException;

    abstract void readTagContents(DataInput datainput)
        throws IOException;

    public abstract byte getType();

    public String getKey()
    {
        if(key == null)
        {
            return "";
        } else
        {
            return key;
        }
    }

    public NBTBase setKey(String s)
    {
        key = s;
        return this;
    }

    public static NBTBase readTag(DataInput datainput)
        throws IOException
    {
        byte byte0 = datainput.readByte();
        if(byte0 == 0)
        {
            return new NBTTagEnd();
        } else
        {
            NBTBase nbtbase = createTagOfType(byte0);
            nbtbase.key = datainput.readUTF();
            nbtbase.readTagContents(datainput);
            return nbtbase;
        }
    }

    public static void writeTag(NBTBase nbtbase, DataOutput dataoutput)
        throws IOException
    {
        dataoutput.writeByte(nbtbase.getType());
        if(nbtbase.getType() == 0)
        {
            return;
        } else
        {
            dataoutput.writeUTF(nbtbase.getKey());
            nbtbase.writeTagContents(dataoutput);
            return;
        }
    }
    
    public abstract byte getId();
    
    public static String func_150283_g(int p_150283_0_)
    {
        switch (p_150283_0_)
        {
            case 0:
                return "TAG_End";

            case 1:
                return "TAG_Byte";

            case 2:
                return "TAG_Short";

            case 3:
                return "TAG_Int";

            case 4:
                return "TAG_Long";

            case 5:
                return "TAG_Float";

            case 6:
                return "TAG_Double";

            case 7:
                return "TAG_Byte_Array";

            case 8:
                return "TAG_String";

            case 9:
                return "TAG_List";

            case 10:
                return "TAG_Compound";

            case 11:
                return "TAG_Int_Array";

            case 99:
                return "Any Numeric Tag";

            default:
                return "UNKNOWN";
        }
    }

    public static NBTBase createTagOfType(byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return new NBTTagEnd();

        case 1: // '\001'
            return new NBTTagByte();

        case 2: // '\002'
            return new NBTTagShort();

        case 3: // '\003'
            return new NBTTagInt();

        case 4: // '\004'
            return new NBTTagLong();

        case 5: // '\005'
            return new NBTTagFloat();

        case 6: // '\006'
            return new NBTTagDouble();

        case 7: // '\007'
            return new NBTTagByteArray();

        case 8: // '\b'
            return new NBTTagString();

        case 9: // '\t'
            return new NBTTagList();

        case 10: // '\n'
            return new NBTTagCompound();
        }
        return null;
    }

    public static String getTagName(byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
            return "TAG_End";

        case 1: // '\001'
            return "TAG_Byte";

        case 2: // '\002'
            return "TAG_Short";

        case 3: // '\003'
            return "TAG_Int";

        case 4: // '\004'
            return "TAG_Long";

        case 5: // '\005'
            return "TAG_Float";

        case 6: // '\006'
            return "TAG_Double";

        case 7: // '\007'
            return "TAG_Byte_Array";

        case 8: // '\b'
            return "TAG_String";

        case 9: // '\t'
            return "TAG_List";

        case 10: // '\n'
            return "TAG_Compound";
        }
        return "UNKNOWN";
    }

    private String key;

	protected String func_150285_a_() {
		return this.toString();
	}

	protected static NBTBase func_150284_a(byte p_150284_0_)
    {
        switch (p_150284_0_)
        {
            case 0:
                return new NBTTagEnd();

            case 1:
                return new NBTTagByte();

            case 2:
                return new NBTTagShort();

            case 3:
                return new NBTTagInt();

            case 4:
                return new NBTTagLong();

            case 5:
                return new NBTTagFloat();

            case 6:
                return new NBTTagDouble();

            case 7:
                return new NBTTagByteArray();

            case 8:
                return new NBTTagString();

            case 9:
                return new NBTTagList();

            case 10:
                return new NBTTagCompound();

            case 11:
                return new NBTTagIntArray();

            default:
                return null;
        }
    }

	public abstract NBTBase copy();
}
