package me.nukkit.osprefix;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class OSPrefix extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Plugin enabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        String deviceName = getPlayerDeviceName(player);
        String displayName = TextFormat.GREEN + "[" + deviceName + "] " + TextFormat.RESET + playerName;
        player.setDisplayName(displayName);
    }

    private String getPlayerDeviceName(Player player) {
        int deviceOS = player.getLoginChainData().getDeviceOS();

        switch (deviceOS) {
            case 1:
                return "Android";
            case 2:
                return "iOS";
            case 3:
                return "Mac";
            case 4:
                return "FireOS";
            case 5:
                return "GearVR";
            case 6:
                return "HoloLens";
            case 10:
                return "PlayStation 4";
            case 7:
                return "Windows 10";
            case 8:
                return "Windows";
            case 9:
                return "Dedicated";
            case 11:
                return "Switch";
            default:
                return "Unknown";
        }
    }

}