package me.border.falldamagemodifier.listeners;

import me.border.falldamagemodifier.FallDamageModifier;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageHandler implements Listener {
    FallDamageModifier plugin = FallDamageModifier.getInstance();

    int percentage = 0;
    boolean set = false;

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageEvent e) {
        if (percentage == 0 && !set) {
            setFallDamage();
        }
        if (e.getEntity() instanceof Player) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {
                double damage = e.getDamage();
                double one = damage / 100;
                double modifier = one * percentage;
                double newDamage = damage - modifier;
                e.setDamage(newDamage);
            }
        }
    }

    void setFallDamage() {
        percentage = plugin.getConfig().getInt("Modifier"); // Only modifies down
        set = true;
    }

}
