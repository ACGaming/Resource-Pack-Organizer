package chylex.respack.gui;

import chylex.respack.ResourcePackOrganizer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public final class GuiModConfig implements IModGuiFactory {
    @Override
    public void initialize(Minecraft mc) {
    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GuiModConfigInner(parentScreen);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public static final class GuiModConfigInner extends GuiConfig {
        public GuiModConfigInner(GuiScreen parent) {
            super(parent, ResourcePackOrganizer.getConfig().getGuiConfigElements(), ResourcePackOrganizer.MODID, false, false, ResourcePackOrganizer.getConfig().getGuiConfigString());
        }
    }
}