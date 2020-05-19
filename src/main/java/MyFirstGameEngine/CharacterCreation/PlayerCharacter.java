package MyFirstGameEngine.CharacterCreation;

/**
 * @author Lars, Christine
 */
public final class PlayerCharacter {

     String name;
     int maxHealth = 50;
     int currentHeath = 50;
     int jumpHeight; // = hoppe like høyt som egen height eller sin egen height ganger 2?
    // to do : legg inn jumpHight i pixels. //legge til på fiender også??
     int movementSpeed = 10;
     int damage = 5;
     int size = 10;
     boolean scoreEnabled = true;
     long points = 0;
     String photo = "/Pictures/PlayableCharacters/Standard.png";

    public String getName() {
        return name;
    }

    public int getHealth() {
        return maxHealth;
    }

    public int getCurrentHeath(){
        return currentHeath;
    }

    public int getjumpHeight() {
        return jumpHeight;
    }

    public int getDamage() {
        return damage;
    }

    public int getSize() {
        return size;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public String isScoreEnabled() {
        if (scoreEnabled){
            return "points are enabled for this Character";
        }
        else {
            return "points are not enabled for this Character";
        }
    }
    public long getPoints() {
        return points;
    }

    public String getPhoto() {
        return photo;
    }

    public void getInformation(){
        System.out.println("Name of character: " + name + " Character's max health: " + maxHealth +
                " Characters current Health: " + currentHeath + " Characters damage: " + damage + " Characters size: " + size +
                " " + isScoreEnabled());
    }

    @Override
    public String toString(){
        return "Name of character: " + name + " Character's max health: " + maxHealth +
                " Characters current Health: " + currentHeath + " Characters damage: " + damage + " Characters size: " + size +
                " " + isScoreEnabled();
    }
}

