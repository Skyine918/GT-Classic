package gtclassic.block;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import gtclassic.GTBlocks;
import gtclassic.GTMod;
import gtclassic.tile.GTTileBasicEnergyStorage;
import gtclassic.tile.GTTileComputerCube;
import gtclassic.tile.GTTileDigitalChest;
import gtclassic.tile.GTTileDigitalTransformer;
import gtclassic.tile.GTTileElectricSmelter;
import gtclassic.tile.GTTileHeatingElement;
import gtclassic.tile.GTTileIndustrialCentrifuge;
import gtclassic.tile.GTTileIndustrialElectrolyzer;
import gtclassic.tile.GTTileMultiArcFurnace;
import gtclassic.tile.GTTileMultiBlastFurnace;
import gtclassic.tile.GTTileMultiBloomery;
import gtclassic.tile.GTTileMultiCharcoalPit;
import gtclassic.tile.GTTileMultiFusionComputer;
import gtclassic.tile.GTTileMultiIndustrialProcessor;
import gtclassic.tile.GTTileMultiLightningRod;
import gtclassic.tile.GTTilePlayerDetector;
import gtclassic.tile.GTTileQuantumEnergyStorage;
import gtclassic.tile.GTTileSuperConductorHigh;
import gtclassic.tile.GTTileSuperConductorLow;
import ic2.core.block.base.tile.TileEntityBlock;
import ic2.core.block.base.tile.TileEntityElectricBlock;
import ic2.core.platform.textures.Ic2Icons;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFlintAndSteel;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTBlockTileBasic extends GTBlockMultiID {

	String name;
	String texture;
	int size = 0;

	public GTBlockTileBasic(String name) {
		super(Material.IRON);
		this.name = name;
		this.size = 1;
		setRegistryName(this.name.toLowerCase());
		setUnlocalizedName(GTMod.MODID + "." + this.name.toLowerCase());
		setCreativeTab(GTMod.creativeTabGT);
		setBlockUnbreakable();
		setResistance(20.0F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 2);
	}

	public GTBlockTileBasic(String name, int additionalInfo) {
		super(Material.IRON);
		this.name = name;
		this.size = additionalInfo + 1;
		setRegistryName(this.name.toLowerCase());
		setUnlocalizedName(GTMod.MODID + "." + this.name.toLowerCase());
		setCreativeTab(GTMod.creativeTabGT);
		setBlockUnbreakable();
		setResistance(20.0F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		for (int i = 0; i < this.size; i++) {
			tooltip.add(I18n.format(this.getUnlocalizedName().replace("tile", "tooltip") + i));
		}
	}

	@Override
	@Deprecated
	public boolean canEntitySpawn(IBlockState state, Entity entityIn) {
		return false;
	}

	@Override
	@Deprecated
	public boolean canProvidePower(IBlockState state) {
		int meta = this.getMetaFromState(state);
		return meta >= 0 && meta <= 2 ? true : super.canProvidePower(state);
	}

	@Override
	public TileEntityBlock createNewTileEntity(World worldIn, int meta) {
		if (this == GTBlocks.computerCube) {
			return new GTTileComputerCube();
		}
		if (this.equals(GTBlocks.heatingElement)) {
			return new GTTileHeatingElement();
		}
		if (this == GTBlocks.bloomery) {
			return new GTTileMultiBloomery();
		}
		if (this == GTBlocks.charcoalPit) {
			return new GTTileMultiCharcoalPit();
		}
		if (this == GTBlocks.blastFurnace) {
			return new GTTileMultiBlastFurnace();
		}
		if (this == GTBlocks.industrialCentrifuge) {
			return new GTTileIndustrialCentrifuge();
		}
		if (this == GTBlocks.industrialProcessor) {
			return new GTTileMultiIndustrialProcessor();
		}
		if (this == GTBlocks.industrialElectrolyzer) {
			return new GTTileIndustrialElectrolyzer();
		}
		if (this == GTBlocks.electricSmelter) {
			return new GTTileElectricSmelter();
		}
		if (this == GTBlocks.playerDetector) {
			return new GTTilePlayerDetector();
		}
		if (this == GTBlocks.arcFurnace) {
			return new GTTileMultiArcFurnace();
		}
		if (this == GTBlocks.lightningRod) {
			return new GTTileMultiLightningRod();
		}
		if (this == GTBlocks.fusionComputer) {
			return new GTTileMultiFusionComputer();
		}
		if (this == GTBlocks.basicEnergyStorage) {
			return new GTTileBasicEnergyStorage();
		}
		if (this == GTBlocks.quantumEnergyStorage) {
			return new GTTileQuantumEnergyStorage();
		}
		if (this == GTBlocks.digitalChest) {
			return new GTTileDigitalChest();
		}
		if (this == GTBlocks.digitalTransformerIV) {
			return new GTTileDigitalTransformer();
		}
		if (this == GTBlocks.energiumCable) {
			return new GTTileSuperConductorLow();
		}
		if (this == GTBlocks.lapotronCable) {
			return new GTTileSuperConductorHigh();
		} else {
			return new TileEntityBlock();
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public TextureAtlasSprite[] getIconSheet(int meta) {
		return Ic2Icons.getTextures(this.name);
	}

	@Override
	public int getMaxSheetSize(int meta) {
		return 1;
	}

	@Override
	@Deprecated
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		TileEntity tile = blockAccess.getTileEntity(pos);
		if (tile instanceof TileEntityElectricBlock) {
			return ((TileEntityElectricBlock) tile).isEmittingRedstone() ? 15 : 0;
		} else {
			return super.getStrongPower(blockState, blockAccess, pos, side);
		}
	}

	@Override
	@Deprecated
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		TileEntity tile = blockAccess.getTileEntity(pos);
		if (tile instanceof TileEntityElectricBlock) {
			return ((TileEntityElectricBlock) tile).isEmittingRedstone() ? 15 : 0;
		} else {
			return super.getWeakPower(blockState, blockAccess, pos, side);
		}
	}

	@Override
	public List<Integer> getValidMetas() {
		return Arrays.asList(0);
	}

	@Override
	public List<IBlockState> getValidStateList() {
		IBlockState def = getDefaultState();
		List<IBlockState> states = new ArrayList<>();
		for (EnumFacing side : EnumFacing.VALUES) {
			states.add(def.withProperty(allFacings, side).withProperty(active, false));
			states.add(def.withProperty(allFacings, side).withProperty(active, true));
		}
		return states;
	}

	@Override
	public List<IBlockState> getValidStates() {
		return getBlockState().getValidStates();
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof GTTileHeatingElement && ((GTTileHeatingElement) tile).isActive) {
			if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
					&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn)) {
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
			}
		}

		super.onEntityWalk(worldIn, pos, entityIn);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		if (this == GTBlocks.bloomery && playerIn.getHeldItemMainhand().getItem() instanceof ItemFlintAndSteel) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof GTTileMultiBloomery && ((GTTileMultiBloomery) te).isActive) {
				return false;
			}
			if (te instanceof GTTileMultiBloomery && !((GTTileMultiBloomery) te).isActive) {
				playerIn.getHeldItem(hand).onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
				return ((GTTileMultiBloomery) te).canWork();
			}
		}

		if (this == GTBlocks.charcoalPit && playerIn.getHeldItemMainhand().getItem() instanceof ItemFlintAndSteel) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof GTTileMultiCharcoalPit && ((GTTileMultiCharcoalPit) te).isActive) {
				return false;
			}
			if (te instanceof GTTileMultiCharcoalPit && !((GTTileMultiCharcoalPit) te).isActive) {
				playerIn.getHeldItem(hand).onItemUse(playerIn, worldIn, pos, hand, facing, hitX, hitY, hitZ);
				return ((GTTileMultiCharcoalPit) te).canWork();
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		particleQuantumEnergy(stateIn, worldIn, pos, rand);
		particleBloomery(stateIn, worldIn, pos, rand);
		particleDetector(stateIn, worldIn, pos, rand);
		particleCharcoalPit(stateIn, worldIn, pos, rand);
		particleSmelter(stateIn, worldIn, pos, rand);
		particleBlastFurnace(stateIn, worldIn, pos, rand);
	}

	public void particleCharcoalPit(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof GTTileMultiCharcoalPit) {
			if (((GTTileMultiCharcoalPit) tile).isActive) {
				if (rand.nextInt(16) == 0) {
					worldIn.playSound((double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F),
							(double) ((float) pos.getZ() + 0.5F), SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS,
							1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
				}
				for (int i = 0; i < 3; ++i) {
					double d0 = (double) pos.getX() + rand.nextDouble();
					double d1 = (double) pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
					double d2 = (double) pos.getZ() + rand.nextDouble();
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	public void particleDetector(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		Random random = worldIn.rand;
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof GTTilePlayerDetector) {
			if (((GTTilePlayerDetector) tile).isActive) {
				for (int i = 0; i < 6; ++i) {
					double d1 = (double) ((float) pos.getX() + random.nextFloat());
					double d2 = (double) ((float) pos.getY() + random.nextFloat());
					double d3 = (double) ((float) pos.getZ() + random.nextFloat());

					if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
						d2 = (double) pos.getY() + 0.0625D + 1.0D;
					}

					if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
						d2 = (double) pos.getY() - 0.0625D;
					}

					if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
						d3 = (double) pos.getZ() + 0.0625D + 1.0D;
					}

					if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
						d3 = (double) pos.getZ() - 0.0625D;
					}

					if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
						d1 = (double) pos.getX() + 0.0625D + 1.0D;
					}

					if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
						d1 = (double) pos.getX() - 0.0625D;
					}

					if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D
							|| d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ()
							|| d3 > (double) (pos.getZ() + 1)) {
						worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d1, d2, d3, 0.0D, 0.0D, 0.0D);
					}
				}
			}
		}
	}

	public void particleQuantumEnergy(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (this == GTBlocks.quantumEnergyStorage) {
			for (int i = 0; i < 3; ++i) {
				int j = rand.nextInt(2) * 2 - 1;
				int k = rand.nextInt(2) * 2 - 1;
				double d0 = pos.getX() + 0.5D + 0.25D * j;
				double d1 = pos.getY() + rand.nextFloat();
				double d2 = pos.getZ() + 0.5D + 0.25D * k;
				double d3 = rand.nextFloat() * j;
				double d4 = (rand.nextFloat() - 0.5D) * 0.125D;
				double d5 = rand.nextFloat() * k;
				worldIn.spawnParticle(EnumParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
			}
		}
	}

	@SuppressWarnings("incomplete-switch")
	public void particleBloomery(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof GTTileMultiBloomery) {
			if (((GTTileMultiBloomery) tile).isActive) {
				EnumFacing enumfacing = getFacing(worldIn, pos);
				double d0 = (double) pos.getX() + 0.5D;
				double d1 = (double) pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
				double d2 = (double) pos.getZ() + 0.5D;
				double d3 = 0.52D;
				double d4 = rand.nextDouble() * 0.6D - 0.3D;

				if (rand.nextDouble() < 0.1D) {
					worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D,
							SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
				}

				switch (enumfacing) {
				case WEST:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					break;
				case EAST:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					break;
				case NORTH:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
					break;
				case SOUTH:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@SuppressWarnings("incomplete-switch")
	public void particleSmelter(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof GTTileElectricSmelter) {
			if (((GTTileElectricSmelter) tile).isActive) {
				EnumFacing enumfacing = getFacing(worldIn, pos);
				double d0 = (double) pos.getX() + 0.5D;
				double d1 = (double) pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
				double d2 = (double) pos.getZ() + 0.5D;
				double d4 = rand.nextDouble() * 0.6D - 0.3D;

				switch (enumfacing) {
				case WEST:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					break;
				case EAST:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					break;
				case NORTH:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
					break;
				case SOUTH:
					worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
					worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@SuppressWarnings("incomplete-switch")
	public void particleBlastFurnace(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		TileEntity tile = worldIn.getTileEntity(pos);
		if (tile instanceof GTTileMultiBlastFurnace) {
			if (((GTTileMultiBlastFurnace) tile).isActive) {
				EnumFacing enumfacing = getFacing(worldIn, pos);
				double d0 = (double) pos.getX() + 0.5D;
				double d1 = (double) (pos.getY() + 0.3D) + rand.nextDouble() * 8.0D / 16.0D;
				double d2 = (double) pos.getZ() + 0.5D;
				double d4 = rand.nextDouble() * 0.6D - 0.3D;

				if (rand.nextDouble() < 0.1D) {
					worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D,
							SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
				}

				switch (enumfacing) {
				case WEST:
					worldIn.spawnParticle(EnumParticleTypes.LAVA, d0 - 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					break;
				case EAST:
					worldIn.spawnParticle(EnumParticleTypes.LAVA, d0 + 0.52D, d1, d2 + d4, 0.0D, 0.0D, 0.0D);
					break;
				case NORTH:
					worldIn.spawnParticle(EnumParticleTypes.LAVA, d0 + d4, d1, d2 - 0.52D, 0.0D, 0.0D, 0.0D);
					break;
				case SOUTH:
					worldIn.spawnParticle(EnumParticleTypes.LAVA, d0 + d4, d1, d2 + 0.52D, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}