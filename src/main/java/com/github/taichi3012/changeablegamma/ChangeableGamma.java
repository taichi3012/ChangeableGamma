package com.github.taichi3012.changeablegamma;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import com.github.taichi3012.changeablegamma.commands.CommandChangeGamma;

@Mod(modid = ChangeableGamma.MOD_ID, useMetadata = true, clientSideOnly = true)
public class ChangeableGamma {
  public static final String MOD_ID = "changeablegamma";

  @EventHandler
  public void init(FMLInitializationEvent event) {
    ClientCommandHandler.instance.registerCommand(new CommandChangeGamma());
  }

  public static void printMessage(String text) {
    Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(text));
  }
}
