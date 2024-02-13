package chylex.respack.packs;

import chylex.respack.gui.GuiCustomResourcePacks;
import net.minecraft.client.resources.ResourcePackListEntryFound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class ResourcePackListEntryCustom extends ResourcePackListEntryFound {
    public ResourcePackListEntryCustom(GuiCustomResourcePacks ownerScreen) {
        super(ownerScreen, null);
    }

    @Override
    public abstract void bindResourcePackIcon();

    @Override
    public abstract String getResourcePackName();

    @Override
    public abstract String getResourcePackDescription();

    @Override
    public boolean showHoverOverlay() {
        return super.showHoverOverlay();
    }
}