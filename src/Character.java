import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Character {
    private String name;
    private int health;
    private int resource;
    private int[] stats;//0 element is max health, 1 is max resource, 2 is speed, 3 is damage die
    private int[] speed;

    public Character(String n, int[] st){ //framework for reading characters from files
        name = n;
        health = st[0];
        resource = st[1];
        stats = st;
        speed = new int[st[2]];
    }

    public void setHealth(int h) {
        health = h;
    }
    public void setResource(int r) {
        resource = r;
    }
    //prerequisite: s is an int array with same length as stats
    public void setStats(int[] s) {
        for (int i = 0; i < stats.length; i++) {
            stats[i] = s[i];
        }
    }
    public void rollSpeed(){
        int[] temp = new int[speed.length];
        for (int i = 0; i < speed.length; i++) {
            temp[i] = (int) (Math.random()*20+1);
        }
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            speed[i] = temp[temp.length-1-i];
        }
        System.out.println(Arrays.toString(speed));
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getResource() {
        return resource;
    }
    public String getStats() {
        return Arrays.toString(stats);
    }
    //prerequisite: 0 <= s <= 5
    public int getSpecificStat(int s){
        return stats[s];
    }

    public int move0(){
        return 0;
    }
    public int move1(){
        return 0;
    }
    public int move2(){
        return 0;
    }
    public int move3(){
        return 0;
    }
    public int move4(){
        return 0;
    }
    public int move5(){
        return 0;
    }

    public String toString() {
        return getName() + "\nHealth: " + getHealth() + "\nResource: " + getResource() + "\nStats Array: " + getStats();
    }

    public String prepareForFile() {
            return getName() + "\n" + getStats();
    }
}
