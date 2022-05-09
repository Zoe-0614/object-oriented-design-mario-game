package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Fire extends Item {
    private int turns;

    /***
     * Constructor.
     */
    public Fire() {
        super("Fire", 'F', false);
        this.turns = 3;
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        if (turns == 0) {
            currentLocation.removeItem(this);
        }
        turns--;
        if (currentLocation.containsAnActor()) {
            currentLocation.getActor().hurt(20);
            if (!currentLocation.getActor().isConscious()) {
                System.out.println(currentLocation.getActor() + " is killed by " + this);
                currentLocation.map().removeActor(currentLocation.getActor());
            }
        }
    }


}
