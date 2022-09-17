package net.rolling.forge.network;

import net.minecraft.util.Identifier;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.rolling.Rolling;

public class NetworkHandler {
    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static void registerMessages(){
        INSTANCE = NetworkRegistry.newSimpleChannel(new Identifier(Rolling.MOD_ID, "network"), () -> "1.0", s -> true, s -> true);

        INSTANCE.registerMessage(ID++, PacketWrapper.class, PacketWrapper::encode, PacketWrapper::decode, PacketWrapper::handle);
    }
}
