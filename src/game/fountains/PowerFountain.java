package game.fountains;


import game.items.PowerWater;

public class PowerFountain extends MagicalFountain {
    private PowerWater water;
    /***
     * Constructor.
     */
    public PowerFountain() {
        super("Power Fountain", 'P');
        this.water = new PowerWater();
    }

    @Override
    public PowerWater getWater() {
        return water;
    }

}
