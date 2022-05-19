package game.enums;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    ENGAGED, // use this status once the enemy is engaged in a fight
    TALL, // use this status to tell that current instance has "grown"
    INVINCIBLE, // use this status after the player had consumed Power Star
    ALREADY_INVINCIBLE,
    RESET, //use to determine resettable
    ISPLAYER, //use this to check if toad is talking to player
    FIRE_ATTACK, //use this status after the player had consumed Fire Flower
    ALREADY_FIRE_ATTACK,

}
