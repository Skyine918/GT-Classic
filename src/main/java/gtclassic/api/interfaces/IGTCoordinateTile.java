package gtclassic.api.interfaces;

import net.minecraft.util.math.BlockPos;

public interface IGTCoordinateTile {

	public void applyCoordinates(BlockPos pos, int dimensionId);

	public boolean isInterdimensional();

	public BlockPos getAppliedPos();

	public int getAppliedDimId();
}
