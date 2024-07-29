package net.dejojotheawsome.braincells5.block.kinetic.TestKineticBlock;

import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class TestKineticBlockEntity extends GeneratingKineticBlockEntity {

    public static final int DEFAULT_SPEED = 32;
    protected int generatedSpeed = DEFAULT_SPEED;

    public TestKineticBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
    }

    @Override
    public void initialize() {
        super.initialize();
        if (!this.hasSource() || this.getGeneratedSpeed() > this.getTheoreticalSpeed())
        {
            this.updateGeneratedRotation();
        }
    }

    @Override
    public float getGeneratedSpeed() {
        return convertToDirection((float)generatedSpeed, (Direction)this.getBlockState().getValue(TestKineticBlock.FACING));
    }
}
