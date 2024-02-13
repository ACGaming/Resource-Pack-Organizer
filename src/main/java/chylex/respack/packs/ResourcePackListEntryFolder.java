package chylex.respack.packs;

import chylex.respack.gui.GuiCustomResourcePacks;
import chylex.respack.gui.GuiUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

@SideOnly(Side.CLIENT)
public class ResourcePackListEntryFolder extends ResourcePackListEntryCustom {
    private static final ResourceLocation folderResource = new ResourceLocation("resourcepackorganizer:textures/gui/folder.png"); // http://www.iconspedia.com/icon/folion-icon-27237.html
    public final File folder;
    public final String folderName;
    public final boolean isUp;
    private final GuiCustomResourcePacks ownerScreen;

    public ResourcePackListEntryFolder(GuiCustomResourcePacks ownerScreen, File folder) {
        super(ownerScreen);
        this.ownerScreen = ownerScreen;
        this.folder = folder;
        this.folderName = folder.getName();
        this.isUp = false;
    }

    public ResourcePackListEntryFolder(GuiCustomResourcePacks ownerScreen, File folder, boolean isUp) {
        super(ownerScreen);
        this.ownerScreen = ownerScreen;
        this.folder = folder;
        this.folderName = "..";
        this.isUp = isUp;
    }

    @Override
    public void bindResourcePackIcon() {
        mc.getTextureManager().bindTexture(folderResource);
    }

    @Override
    public String getResourcePackName() {
        return folderName;
    }

    @Override
    public String getResourcePackDescription() {
        return isUp ? "(Back)" : "(Folder)";
    }

    @Override
    public boolean mousePressed(int slotIndex, int mouseX, int mouseY, int mouseEvent, int relativeX, int relativeY) {
        ownerScreen.moveToFolder(folder);
        return true;
    }

    @Override
    public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected, float partialTicks) {
        GuiUtils.renderFolderEntry(this, x, y, isSelected);
    }
}