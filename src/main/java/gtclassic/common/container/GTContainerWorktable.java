package gtclassic.common.container;

import gtclassic.GTMod;
import gtclassic.api.gui.GTGuiCompBasicString;
import gtclassic.common.tile.GTTileWorktable;
import ic2.core.inventory.container.ContainerTileComponent;
import ic2.core.inventory.gui.GuiIC2;
import ic2.core.inventory.slots.SlotBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTContainerWorktable extends ContainerTileComponent<GTTileWorktable> {

	private InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	private InventoryCraftResult craftResult = new InventoryCraftResult();
	private final World world;
	private final EntityPlayer player;
	public static ResourceLocation TEXTURE = new ResourceLocation(GTMod.MODID, "textures/gui/worktable.png");
	private GTTileWorktable block;

	public GTContainerWorktable(InventoryPlayer player, GTTileWorktable tile) {
		super(tile);
		this.block = tile;
		this.world = player.player.getEntityWorld();
		this.player = player.player;
		this.addComponent(new GTGuiCompBasicString("Basic Worktable", 85, 6));
		this.addSlotToContainer(new SlotCrafting(this.player, craftMatrix, craftResult, 0, 148, 35));// slot 0
		for (int k = 0; k < 4; ++k) {
			for (int l = 0; l < 4; ++l) {
				this.addSlotToContainer(new SlotBase(tile, (k + l * 4) + 1, 8 + l * 18, 8 + k * 18));
			}
		}
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlotToContainer(new Slot(craftMatrix, 0 + (j + i * 3), 82 + j * 18, 17 + i * 18));
			}
		}
		this.addPlayerInventory(player, 0, 0);
		readTileCraftingList();
		this.block.inUse = true;
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		this.slotChangedCraftingGrid(this.world, this.player, this.craftMatrix, this.craftResult);
	}

//	@Nullable
//	@Override
//	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
//		writeTileCraftingList();
//		if (!isCurrentListEqual()) {
//			readTileCraftingList();
//		}
//		return super.slotClick(slotId, dragType, clickTypeIn, player);
//	}
	@Override
	public void onContainerClosed(EntityPlayer playerIn) {
		super.onContainerClosed(playerIn);
		writeTileCraftingList();
	}

	public void writeTileCraftingList() {
		this.block.craftingInventory.clear();
		for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i) {
			ItemStack mSlot = this.craftMatrix.getStackInSlot(i);
			this.block.craftingInventory.set(i, mSlot);
		}
	}

	public void readTileCraftingList() {
		for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i) {
			ItemStack mSlot = this.block.craftingInventory.get(i);
			this.craftMatrix.setInventorySlotContents(i, mSlot);
		}
	}

	// Unused hopefully this can be of use for server support
	public boolean isCurrentListEqual() {
		NonNullList<ItemStack> copyList = NonNullList.<ItemStack>withSize(9, ItemStack.EMPTY);
		for (int i = 0; i < this.craftMatrix.getSizeInventory(); ++i) {
			ItemStack mSlot = this.craftMatrix.getStackInSlot(i);
			copyList.set(i, mSlot);
		}
		return copyList.equals(this.block.craftingInventory);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onGuiLoaded(GuiIC2 gui) {
		gui.disableName();
		gui.dissableInvName();
	}

	@Override
	public ResourceLocation getTexture() {
		return TEXTURE;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return getGuiHolder().canInteractWith(player);
	}

	@Override
	public int guiInventorySize() {
		return 26;
	}
}