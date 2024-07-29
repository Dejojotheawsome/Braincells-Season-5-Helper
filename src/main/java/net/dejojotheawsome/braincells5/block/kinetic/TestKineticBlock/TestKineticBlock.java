package net.dejojotheawsome.braincells5.block.kinetic.TestKineticBlock;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.foundation.block.IBE;
import net.dejojotheawsome.braincells5.block.ModBlockEntityKinetic;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Objects;

public class TestKineticBlock extends DirectionalKineticBlock implements IBE<TestKineticBlockEntity> {

    private int rightClickSpeed = 32;

    public TestKineticBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AllShapes.MOTOR_BLOCK.get((Direction) pState.getValue(FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction preferred = this.getPreferredFacing(context);
        return (context.getPlayer() == null || !context.getPlayer().isShiftKeyDown()) && preferred != null ? (BlockState)this.defaultBlockState().setValue(FACING, preferred) : super.getStateForPlacement(context);
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == state.getValue(FACING);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState blockState) {
        return ((Direction)blockState.getValue(FACING)).getAxis();
    }

    @Override
    public boolean hideStressImpact() {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    @Override
    public Class<TestKineticBlockEntity> getBlockEntityClass() {
        return TestKineticBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends TestKineticBlockEntity> getBlockEntityType() {
        return ModBlockEntityKinetic.TEST_KINETIC_BLOCK.get();
    }

    /*
    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (pHand == InteractionHand.MAIN_HAND)
        {
            TestKineticBlockEntity entity = getBlockEntity(pLevel, pPos);

            if (pLevel.isClientSide)
                rightClickSpeed = (int)(Math.random() * 32);

            entity.setGeneratedSpeed(rightClickSpeed);

            pLevel.playSound(pPlayer, pPos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS);

        }

        return InteractionResult.SUCCESS;
    }
    */
}
