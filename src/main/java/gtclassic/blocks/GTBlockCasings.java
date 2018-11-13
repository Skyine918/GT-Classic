package gtclassic.blocks;

import gtclassic.GTClassic;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.obj.ITexturedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class GTBlockCasings extends Block implements ITexturedBlock {
    public enum GTBlockCasingsVariants{
        FUSION(21), 
        LESU(23), 
        STANDARD(24), 
        REINFORCED(25), 
        ADVANCED(26), 
        HIGHLYADVANCED(27);
        private int id;

        GTBlockCasingsVariants(int id){
            this.id = id;
        }

        public int getID(){
            return id;
        }
    }

    GTBlockCasingsVariants variant;
    public GTBlockCasings(GTBlockCasingsVariants variant){
        super(Material.IRON);
        this.variant = variant;
        setRegistryName(variant.toString().toLowerCase() + "casing_block");
        setUnlocalizedName(GTClassic.MODID + "." + variant.toString().toLowerCase() + "casing_block");
        setCreativeTab(GTClassic.creativeTabGT);
        setHardness(5.0F);
        setSoundType(SoundType.METAL);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox(IBlockState iBlockState) {
        return FULL_BLOCK_AABB;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public TextureAtlasSprite getTextureFromState(IBlockState iBlockState, EnumFacing enumFacing) {
        return Ic2Icons.getTextures("gtclassic_blocks")[variant.getID()];
    }

    @Override
    @Deprecated
    public boolean canEntitySpawn(IBlockState state, Entity entityIn)
    {
        return false;
    }
    
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add("Mobs can't spawn on this Block");
    }
    
    @Override
    public TextureAtlasSprite getParticleTexture(IBlockState state) {
        return this.getTextureFromState(state, EnumFacing.SOUTH);
    }

    @Override
    public List<IBlockState> getValidStates() {
        return this.blockState.getValidStates();
    }

    @Override
    public IBlockState getStateFromStack(ItemStack stack) {
        return this.getStateFromMeta(stack.getMetadata());
    }
}

