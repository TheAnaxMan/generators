/*
 * Copyright (c) bdew, 2015
 * https://github.com/bdew/generators
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.generators.controllers.syngas

import cpw.mods.fml.relauncher.{Side, SideOnly}
import net.bdew.lib.gui.GuiProvider
import net.bdew.lib.machine.Machine
import net.bdew.lib.multiblock.MachineCore
import net.minecraft.entity.player.EntityPlayer

object MachineSyngas extends Machine("SyngasController", BlockSyngasController) with MachineCore with GuiProvider {
  def guiId: Int = 4
  type TEClass = TileSyngasController

  lazy val internalTankCapacity = tuning.getInt("InternalTankCapacity")
  lazy val workHeat = tuning.getDouble("WorkHeat")
  lazy val maxHeat = tuning.getDouble("MaxHeat")
  lazy val carbonValuePerMBSyngas = tuning.getDouble("CarbonValuePerMBSyngas")
  lazy val waterSteamRatio = tuning.getDouble("WaterSteamRatio")
  lazy val steamPerMBSyngas = tuning.getDouble("SteamPerMBSyngas")
  lazy val mixingChamberThroughput = tuning.getDouble("MixingChamberThroughput")
  lazy val heatingChamberThroughput = tuning.getDouble("HeatingChamberThroughput")
  lazy val heatingChamberHeating = tuning.getDouble("HeatingChamberHeating")
  lazy val steamPerHeat = tuning.getDouble("SteamPerHeat")
  lazy val carbonPerHeat = tuning.getDouble("CarbonPerHeat")
  lazy val heatLossMultiplier = tuning.getDouble("HeatLossMultiplier")

  @SideOnly(Side.CLIENT)
  def getGui(te: TileSyngasController, player: EntityPlayer) = new GuiSyngas(te, player)
  def getContainer(te: TileSyngasController, player: EntityPlayer) = new ContainerSyngas(te, player)
}
