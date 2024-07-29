package net.dejojotheawsome.braincells5.block;

import com.simibubi.create.content.kinetics.base.HalfShaftInstance;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.dejojotheawsome.braincells5.block.kinetic.TestKineticBlock.TestKineticBlockEntity;
import net.dejojotheawsome.braincells5.block.kinetic.TestKineticBlock.TestKineticBlockRenderer;

import static net.dejojotheawsome.braincells5.Braincells5.REGISTRATE;

public class ModBlockEntityKinetic {
    public static final BlockEntityEntry<TestKineticBlockEntity> TEST_KINETIC_BLOCK = REGISTRATE
            .blockEntity("kinetic_test", TestKineticBlockEntity::new)
            .instance(() -> HalfShaftInstance::new, false)
            .validBlocks(ModKineticBlocks.TEST_KINETIC_BLOCK)
            .renderer(() -> TestKineticBlockRenderer::new)
            .register();

    public static void register() {}
}
