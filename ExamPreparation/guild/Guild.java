package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }
    //•	Method addPlayer(Player player) - adds an entity to the roster if there is room for it
    public void addPlayer(Player player){
        if (count() < this.capacity){
            this.roster.add(player);
        }
    }
    //•	Method count() - returns the number of players
    public int count(){
        return roster.size();
    }
    //•	Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
    public boolean removePlayer(String name){
        if (this.roster.contains(name)){
            this.roster.remove(name);
            return true;
        }
            return false;

    }
    //•	Method promotePlayer(String name) - promote (set his rank to "Member") the first player with the given name.
    // If the player is already a "Member", do nothing.
    public void promotePlayer(String name){
             boolean flag = true;
             for (Player p : roster) {
                 if (p.getName().equals(name) && flag) {
                     if (!(p.getRank().equals("Member"))) {
                         p.setRank("Member");
                         flag = false;
                     }
                 }
             }
    }
    //•	Method demotePlayer(String name)- demote (set his rank to "Trial") the first player with the given name.
    // If the player is already a "Trial",  do nothing.
    public void demotePlayer(String name) {
        boolean flag = true;
        for (Player player : roster) {
            if (player.getName().equals(name) && flag) {
                if (!(player.getRank().equals("Trial"))) {
                    player.setRank("Trial");
                    flag = false;
                }
            }
        }
    }
        //•	Method kickPlayersByClass(String clazz)
        // - removes all the players by the given class and returns all removed players from that class as an array
        public Player[] kickPlayersByClass(String clazz) {
            Player[] removed = roster.stream()
                    .filter(player -> clazz.equals(player.getClazz()))
                    .toArray(Player[]::new);

            for (Player player : removed) {
                roster.remove(player);
            }

            return removed;
        }
    public String report() {
        return String.format(
                "Players in the guild: %s:%n%s", this.name,
                roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }

}
