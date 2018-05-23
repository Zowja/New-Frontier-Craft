// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            NBTBase

public class NBTTagList extends NBTBase
{

    public NBTTagList()
    {
        tagList = new ArrayList();
    }

    void writeTagContents(DataOutput dataoutput)
        throws IOException
    {
        if(tagList.size() > 0)
        {
            tagType = ((NBTBase)tagList.get(0)).getType();
        } else
        {
            tagType = 1;
        }
        dataoutput.writeByte(tagType);
        dataoutput.writeInt(tagList.size());
        for(int i = 0; i < tagList.size(); i++)
        {
            ((NBTBase)tagList.get(i)).writeTagContents(dataoutput);
        }

    }

    void readTagContents(DataInput datainput)
        throws IOException
    {
        tagType = datainput.readByte();
        int i = datainput.readInt();
        tagList = new ArrayList();
        for(int j = 0; j < i; j++)
        {
            NBTBase nbtbase = NBTBase.createTagOfType(tagType);
            nbtbase.readTagContents(datainput);
            tagList.add(nbtbase);
        }

    }

    public byte getType()
    {
        return 9;
    }

    public String toString()
    {
        return (new StringBuilder()).append("").append(tagList.size()).append(" entries of type ").append(NBTBase.getTagName(tagType)).toString();
    }

    public void setTag(NBTBase nbtbase)
    {
        tagType = nbtbase.getType();
        tagList.add(nbtbase);
    }

    public NBTBase tagAt(int i)
    {
        return (NBTBase)tagList.get(i);
    }

    public int tagCount()
    {
        return tagList.size();
    }

    private List tagList;
    private byte tagType;
	public int func_150303_d() {
		return this.tagType;
	}

	public byte getId() {
		return (byte)9;
	}

	public String getStringTagAt(int p_150307_1_)
    {
        if (p_150307_1_ >= 0 && p_150307_1_ < this.tagList.size())
        {
            NBTBase var2 = (NBTBase)this.tagList.get(p_150307_1_);
            return var2.getId() == 8 ? var2.func_150285_a_() : var2.toString();
        }
        else
        {
            return "";
        }
    }

	public void appendTag(NBTBase par1NBTBase)
    {
        if (this.tagType == 0)
        {
            this.tagType = par1NBTBase.getId();
        }
        else if (this.tagType != par1NBTBase.getId())
        {
            System.err.println("WARNING: Adding mismatching tag types to tag list");
            return;
        }

        this.tagList.add(par1NBTBase);
    }

	public void func_150304_a(int p_150304_1_, NBTBase p_150304_2_)
    {
        if (p_150304_1_ >= 0 && p_150304_1_ < this.tagList.size())
        {
            if (this.tagType == 0)
            {
                this.tagType = p_150304_2_.getId();
            }
            else if (this.tagType != p_150304_2_.getId())
            {
                System.err.println("WARNING: Adding mismatching tag types to tag list");
                return;
            }

            this.tagList.set(p_150304_1_, p_150304_2_);
        }
        else
        {
            System.err.println("WARNING: index out of bounds to set tag in tag list");
        }
    }

	public NBTBase copy()
    {
        NBTTagList var1 = new NBTTagList();
        var1.tagType = this.tagType;
        Iterator var2 = this.tagList.iterator();

        while (var2.hasNext())
        {
            NBTBase var3 = (NBTBase)var2.next();
            NBTBase var4 = var3.copy();
            var1.tagList.add(var4);
        }

        return var1;
    }

	public NBTBase removeTag(int par1)
    {
        return (NBTBase)this.tagList.remove(par1);
    }
}
