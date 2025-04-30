package org.nootnoot.fabricchaos;

import net.fabricmc.api.ModInitializer;
import org.nootnoot.fabricchaos.Register.ModBlocks;
import org.nootnoot.fabricchaos.Register.ModFluids;
import org.nootnoot.fabricchaos.Register.Moditemgroup;
import org.nootnoot.fabricchaos.Register.Moditems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Fabricchaos implements ModInitializer {
    public static final String MOD_ID = "fabricchaos";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        Moditems.initialize();
        ModBlocks.initialize();
        Moditemgroup.initialize();
        ModFluids.initialize();

    }

}

