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
     * @param actor the NPC
     * @return the amount of turns an NPC have
     */
    //Gets the npc's turn number
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
    //Getting the balance from the Actor and then adding the money
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

    public static void addTalkList(Actor actor, ArrayList<String> talkList){
        actorsTalkList.put(actor, talkList);
    }

    /**
     *
     * @param actor the Actor
     */
    public static void talk(Actor actor){
        if (getTurn(actor) % 2 ==0){
            ArrayList<String> newTalk = actorsTalkList.get(actor);
            int talkIndex = random.nextInt(newTalk.size());
            System.out.println(actor+ ": \""+newTalk.get(talkIndex)+"\"");
        }


    }



}
