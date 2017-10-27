package net.minecraft.src;

public class ItemTallGrass extends Item
{

    public ItemTallGrass(int i)
    {
        super(i);
        setMaxDamage(0);
        blockID = 31;
        setHasSubtypes(true);
    }
    
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if(world.getBlockId(i, j, k) == Block.snow.blockID)
        {
            l = 0;
        } else
        {
            if(l == 0)
            {
                j--;
            }
            if(l == 1)
            {
                j++;
            }
            if(l == 2)
            {
                k--;
            }
            if(l == 3)
            {
                k++;
            }
            if(l == 4)
            {
                i--;
            }
            if(l == 5)
            {
                i++;
            }
        }
        if(itemstack.stackSize == 0)
        {
            return false;
        }
        if(j == 127 && Block.blocksList[blockID].blockMaterial.isSolid())
        {
            return false;
        }
        if(world.canBlockBePlacedAt(blockID, i, j, k, false, l))
        {
            Block block = Block.blocksList[blockID];
            if(world.setBlockAndMetadataWithNotify(i, j, k, blockID, getPlacedBlockMetadata(itemstack.getItemDamage())))
            {
                Block.blocksList[blockID].onBlockPlaced(world, i, j, k, l);
                Block.blocksList[blockID].onBlockPlacedBy(world, i, j, k, entityplayer);
                world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.func_1145_d(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                itemstack.stackSize--;
            }
            return true;
        } else
        {
            return false;
        }
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }

    public int getIconFromDamage(int i)
    {
        return 115 + (i%3);
    }
    
    public String getItemNameIS(ItemStack itemstack) {
    	return (itemstack.getItemDamage() == 2) ? "Fern" : "Tall Grass";
    }
    
    private int blockID;
}
