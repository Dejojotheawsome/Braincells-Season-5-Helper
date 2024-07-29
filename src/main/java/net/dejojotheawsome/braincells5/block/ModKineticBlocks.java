package net.dejojotheawsome.braincells5.block;

import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.motor.CreativeMotorGenerator;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dejojotheawsome.braincells5.block.kinetic.TestKineticBlock.TestKineticBlock;
import net.dejojotheawsome.braincells5.item.ModCreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static net.dejojotheawsome.braincells5.Braincells5.REGISTRATE;

public class ModKineticBlocks {
    public static final BlockEntry<TestKineticBlock> TEST_KINETIC_BLOCK = REGISTRATE
            .block("test_kinetic_block", TestKineticBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
            .transform(axeOrPickaxe())
            .transform(BlockStressDefaults.setCapacity(32))
            .transform(BlockStressDefaults.setGeneratorSpeed(() -> Couple.create(0, 32)))
            .item()
            .tab(ModCreativeModeTabs.TEST_TAB.getKey())
            .transform(customItemModel())
            .register();

    public static void register() {}
}
