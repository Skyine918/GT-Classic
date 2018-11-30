package gtclassic.util;

import gtclassic.GTClassic;
import gtclassic.items.*;
import gtclassic.items.GTItemComponents.GTItemComponentTypes;
import gtclassic.items.armor.GTItemEnergyPack;
import gtclassic.items.energy.GTItemLapotronicEnergyOrb;
import gtclassic.items.energy.GTItemLithiumBattery;
import gtclassic.items.energy.GTItemZeroPointModule;
import gtclassic.items.resources.GTItemElements;
import gtclassic.items.resources.GTItemElements.GTItemCellTypes;
import gtclassic.items.resources.GTItemDust;
import gtclassic.items.resources.GTItemDust.GTItemDustTypes;
import gtclassic.items.resources.GTItemGem;
import gtclassic.items.resources.GTItemGem.GTItemGemTypes;
import gtclassic.items.resources.GTItemIngot;
import gtclassic.items.resources.GTItemIngot.GTItemIngotTypes;
import gtclassic.items.tools.GTItemAdvancedChainsaw;
import gtclassic.items.tools.GTItemAdvancedDrill;
import gtclassic.items.tools.GTItemDestructoPack;
import gtclassic.items.tools.GTItemHammerIron;
import gtclassic.items.tools.GTItemTeslaStaff;
import gtclassic.toxicdimension.items.GTItemCreditAlk;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class GTItems {
	
	public static final GTItemElements
	hydrogen = new GTItemElements(GTItemCellTypes.HYDROGEN),
	dueterium = new GTItemElements(GTItemCellTypes.DEUTERIUM),
	tritium = new GTItemElements(GTItemCellTypes.TRITIUM),
	helium = new GTItemElements(GTItemCellTypes.HELIUM),
	tungsten = new GTItemElements(GTItemCellTypes.TUNGSTEN),
	lithium = new GTItemElements(GTItemCellTypes.LITHIUM),
	helium3 = new GTItemElements(GTItemCellTypes.HELIUM3),
	silicon = new GTItemElements(GTItemCellTypes.SILICON),
	carbon = new GTItemElements(GTItemCellTypes.CARBON),
	methane = new GTItemElements(GTItemCellTypes.METHANE),
	berilium = new GTItemElements(GTItemCellTypes.BERILIUM),
	calcium = new GTItemElements(GTItemCellTypes.CALCIUM),
	sodium = new GTItemElements(GTItemCellTypes.SODIUM),
	chlorine = new GTItemElements(GTItemCellTypes.CHLORINE),
	potassium = new GTItemElements(GTItemCellTypes.POTASSIUM),
	nitrogen = new GTItemElements(GTItemCellTypes.NITROGEN);
	
	public static final GTItemDust
	dustEnderpearl = new GTItemDust(GTItemDustTypes.ENDERPEARL),
    dustEnderEye = new GTItemDust(GTItemDustTypes.ENDER_EYE),
	dustLazurite = new GTItemDust(GTItemDustTypes.LAZURITE),
	dustPyrite = new GTItemDust(GTItemDustTypes.PYRITE),
	dustCalcite = new GTItemDust(GTItemDustTypes.CALCITE),
	dustFlint = new GTItemDust(GTItemDustTypes.FLINT),
	dustUranium = new GTItemDust(GTItemDustTypes.URANIUM),
	dustBauxite = new GTItemDust(GTItemDustTypes.BAUXITE),
	dustAluminium = new GTItemDust(GTItemDustTypes.ALUMINIUM),
	dustTitanium = new GTItemDust(GTItemDustTypes.TITANIUM),
	dustChrome = new GTItemDust(GTItemDustTypes.CHROME),
	dustRuby = new GTItemDust(GTItemDustTypes.RUBY),
	dustSapphire = new GTItemDust(GTItemDustTypes.SAPPHIRE),
	dustGreenSapphire = new GTItemDust(GTItemDustTypes.GREEN_SAPPHIRE),
	dustEmerald = new GTItemDust(GTItemDustTypes.EMERALD),
	dustSodalite = new GTItemDust(GTItemDustTypes.SODALITE);

	public static final GTItemGem
	ruby = new GTItemGem(GTItemGemTypes.RUBY),
	sapphire = new GTItemGem(GTItemGemTypes.SAPPHIRE);
	
	public static final GTItemIngot
	ingotIridium = new GTItemIngot(GTItemIngotTypes.IRIDIUM),
	ingotAluminium = new GTItemIngot(GTItemIngotTypes.ALUMINIUM),
	ingotTitanium = new GTItemIngot(GTItemIngotTypes.TITANIUM),
	ingotChrome = new GTItemIngot(GTItemIngotTypes.CHROME);
	
	public static final GTItemComponents
	energyFlowCircuit = new GTItemComponents(GTItemComponentTypes.ENERGY_FLOW_CIRCUIT),
	dataControlCircuit = new GTItemComponents(GTItemComponentTypes.DATA_CONTROL_CIRCUIT),
	superConductor = new GTItemComponents(GTItemComponentTypes.SUPERCONDUCTOR),
	dataStorageCircuit = new GTItemComponents(GTItemComponentTypes.DATA_STORAGE_CIRCUIT),
	braintechAerospaceARDT = new GTItemComponents(GTItemComponentTypes.BRAINTECH_AEROSPACE_ARDT),
	dataOrb = new GTItemComponents(GTItemComponentTypes.DATA_ORB),
	glassTube = new GTItemComponents(GTItemComponentTypes.GLASS_TUBE);
	
	public static final GTItemCreditAlk creditAlk = new GTItemCreditAlk();
	public static final GTItemHammerIron hammerIron = new GTItemHammerIron();
	public static final GTItemAdvancedDrill advancedDrill = new GTItemAdvancedDrill();
	public static final GTItemAdvancedChainsaw advancedChainsaw = new GTItemAdvancedChainsaw();
	public static final GTItemTeslaStaff teslaStaff = new GTItemTeslaStaff();
	public static final GTItemLithiumBattery lithiumBattery = new GTItemLithiumBattery();
	public static final GTItemLapotronicEnergyOrb lapotronicEnergyOrb = new GTItemLapotronicEnergyOrb();
	public static final GTItemZeroPointModule zeroPointModule = new GTItemZeroPointModule();
	public static final GTItemEnergyPack lithiumBatpack = new GTItemEnergyPack(58, "gtclassic:textures/models/armor/lithiumbatpack", 600000, "lithium_batpack", ".lithiumBatpack", 1, 200);
	public static final GTItemEnergyPack lapotronPack = new GTItemEnergyPack(45, "gtclassic:textures/models/armor/lapotronpack", 100000000, "lapotron_pack", ".lapotronPack", 3, 1500);
	public static final GTItemDestructoPack destructoPack = new GTItemDestructoPack();

	public static final Item[] items = {
			
			hydrogen,
			dueterium,
			tritium,
			helium,
			tungsten,
			lithium,
			helium3,
			silicon,
			carbon,
			methane,
			berilium,
			calcium,
			sodium,
			chlorine,
			potassium,
			nitrogen,

			dustEnderpearl,
			dustEnderEye,
			dustLazurite,
			dustPyrite,
			dustCalcite,
			dustFlint,
			dustUranium,
			dustBauxite,
			dustAluminium,
			dustTitanium,
			dustChrome,
			dustRuby,
			dustSapphire,
			dustGreenSapphire,
			dustEmerald,
			dustSodalite,

			ruby,
			sapphire,
			ingotIridium,
			ingotAluminium,
			ingotTitanium,
			ingotChrome,
			
			energyFlowCircuit,
			dataControlCircuit,
			superConductor,
			dataStorageCircuit,
			braintechAerospaceARDT,
			dataOrb,
			glassTube,
			
			hammerIron,
			advancedDrill,
			advancedChainsaw,
			teslaStaff,
			lithiumBattery,
			lapotronicEnergyOrb,
			zeroPointModule,
			lithiumBatpack,
			lapotronPack,
			destructoPack,
			creditAlk
			
	};
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry registry = event.getRegistry();
		//items
		GTClassic.logger.info("Registering Items");
		for (Item item : items)
		{
			registry.register(item);
		}
	}
}
