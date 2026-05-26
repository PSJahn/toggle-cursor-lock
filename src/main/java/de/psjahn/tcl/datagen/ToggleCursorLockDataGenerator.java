package de.psjahn.tcl.datagen;

import de.psjahn.tcl.ToggleCursorLock;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ToggleCursorLockDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(EnglishLanguageProvider::new);
    }

    private static class EnglishLanguageProvider extends FabricLanguageProvider {
        private EnglishLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(packOutput, "en_us", registryLookup);
        }

        @Override
        public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder builder) {
            builder.add(ToggleCursorLock.CATEGORY.id().toLanguageKey("key.category"), "Toggle Cursor Lock");
            builder.add(ToggleCursorLock.TOGGLE_KEY.getName(), "Toggle");
        }
    }
}
