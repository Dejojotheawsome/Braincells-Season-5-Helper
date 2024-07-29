package net.dejojotheawsome.braincells5.item;

import net.dejojotheawsome.braincells5.Braincells5;
import net.dejojotheawsome.braincells5.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Braincells5.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COMPUTER.get()))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEST.get());
                        output.accept(ModItems.COMPUTER.get());
                        output.accept(ModBlocks.TEST_BLOCK.get());
                    })
                    .build());

    public static void register (IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
