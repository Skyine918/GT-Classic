package gtclassic;

import gtclassic.commands.CommandTeleport;
import gtclassic.proxy.ProxyCommon;
import gtclassic.util.GTCreativeTab;
import gtclassic.util.GTIcons;
import gtclassic.world.OreGen;
import ic2.api.classic.addon.IC2Plugin;
import ic2.api.classic.addon.PluginBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;
//@IC2Plugin(name = GTClassic.MODNAME, id = GTClassic.MODID, version = GTClassic.MODVERSION, hasResourcePack = true)
@Mod(modid = GTClassic.MODID, name = GTClassic.MODNAME, version = GTClassic.MODVERSION, dependencies = GTClassic.DEPENDS, useMetadata = true)
public class GTClassic {

    public static final String MODID = "gtclassic";
    public static final String MODNAME = "GregTech Classic";
    public static final String MODVERSION= "@VERSION@";
    public static final String DEPENDS = "required-after:ic2;required-after:ic2-classic-spmod;required-after:forge@[14.23.5.2772,)";
    public static final CreativeTabs creativeTabGT = new GTCreativeTab(MODID);
    @SidedProxy(clientSide = "gtclassic.proxy.ProxyClient", serverSide = "gtclassic.proxy.ProxyServer")
    public static ProxyCommon proxy;

    @Mod.Instance
    public static GTClassic instance;
    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
        //GTIcons.loadSprites();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        GameRegistry.registerWorldGenerator(new OreGen(), 0);
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        // some hello world action
        logger.info("HELLO WORLD!");
        proxy.postInit(e);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandTeleport());
    }
}
