package com.github.taichi3012.changeablegamma.commands;

import java.util.Collections;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

import com.github.taichi3012.changeablegamma.ChangeableGamma;

public class CommandChangeGamma extends CommandBase {

  @Override
  public String getCommandName() {
    return "changegamma";
  }

  @Override
  public List<String> getCommandAliases() {
    return Collections.singletonList("cg");
  }

  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  @Override
  public String getCommandUsage(ICommandSender sender) {
    return "使い方: /changegamma <明るさ>";
  }

  @Override
  public void processCommand(ICommandSender sender, String[] args) throws CommandException {
    if (args.length != 1)
      throw new CommandException(getCommandUsage(sender));

    int gamma = parseInt(args[0]);
    GameSettings settings = Minecraft.getMinecraft().gameSettings;
    settings.setOptionFloatValue(GameSettings.Options.GAMMA, gamma / 100f);
    settings.saveOptions();
    ChangeableGamma.printMessage(String.format("明るさを%d%%に設定しました。", gamma));
  }

}
