package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Class representing the Monologue
 *
 * @author Loh Zhun Guan
 * @version 1.0
 */
public class Monologue {

    /**
     * Hashmap of actors and their turns
     */
    private static HashMap<Actor, Integer> actors = new HashMap<>();

    /**
     * Hashmap of actors and their talkList
     */
    private static HashMap<Actor, ArrayList<String>> actorsTalkList = new HashMap<>();

    /**
     * To generate random value
     */
    protected static Random random = new Random();


    /**
     * Maps the actor to their starting turn
     *
     * @param actor the actor that has a play turn
     */
    public static void addActor(Actor actor) {
        actors.put(actor, 0);
    }

    /**
     * Gets the turn of the actor
     *
     * @param actor the actor
     * @return the amount of turns an actor has
     */
    //Gets the actor's turn number
    public static int getTurn(Actor actor) {
        if (actors.containsKey(actor)) {
            return actors.get(actor);
        } else {
            return 0;
        }
    }

    /**
     * Turn increases every turn
     * @param actor the Actor
     * @param turn The number of turns
     */
    //Getting the turns from the Actor and then adding a turn
    public static void addTurn(Actor actor, int turn) {
        int currTurn;
        if (actors.containsKey(actor)) {
            currTurn = actors.get(actor);
        } else {
            currTurn = 0;
        }
        int newTurn = currTurn + turn;
        actors.put(actor, newTurn);
    }

    /**
     * Maps the actor to their Monologue
     *
     * @param actor the Actor
     * @param talkList the Actor's monologue
     */
    public static void addTalkList(Actor actor, ArrayList<String> talkList){
        actorsTalkList.put(actor, talkList);
    }

    /**
     * Actors and their monologue
     *
     * @param actor the Actor
     */
    public static void talk(Actor actor){
        ArrayList<String> newTalk = actorsTalkList.get(actor);
        int talkIndex = random.nextInt(newTalk.size());
        System.out.println(actor+ ": \""+newTalk.get(talkIndex)+"\"");



    }



}
