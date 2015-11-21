import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Vasco on 11/21/2015.
 */
public class Protocol
{
    private static final int WAITING = 0;
    private static final int SENTWELCOME = 1;
    private static final int TRANSLATE = 2;
    private static final int ANOTHER = 3;

    private static final int NUMJOKES = 5;

    private int state = WAITING;
    private int currentJoke = 0;

    private HashMap<String, String> translationsDU_EN = new HashMap<>();

    public Protocol()
    {
        // Setup all the translations
        translationsDU_EN.put("Appel", "Apple");
        translationsDU_EN.put("Peer", "Pear");
        translationsDU_EN.put("Druif", "Grape");
        translationsDU_EN.put("Beer", "Bear");
        translationsDU_EN.put("Drie", "Three");
        translationsDU_EN.put("Leren", "Learn");
        translationsDU_EN.put("Speelstijl", "Playstyle");
        translationsDU_EN.put("Onthouden", "Remember");
        translationsDU_EN.put("Gebeuren", "Happen");
        translationsDU_EN.put("Mogelijk", "Capable");
    }

    public String processInput(String theInput)
    {
        String theOutput = null;

        if( state == WAITING )
        {
            theOutput = "What do you wanna do?";
            state = SENTWELCOME;
        }
        else if( state == SENTWELCOME )
        {
            if (theInput.equalsIgnoreCase("Translate"))
            {
                theOutput = "Type a dutch word that you wanna translate to english";
                state = TRANSLATE;
            }
            else
            {
                theOutput = "You're supposed to say \"Translate\"! " +
                        "Try again!";
            }
        }
        else if( state == TRANSLATE )
        {
            String translationString = "NOT_FOUND";

            if( theInput != null )
            {
                // Split it in different words and append each word to the translation string
                String[] inputList = theInput.split(" ");

                translationString = "";

                for( String entry : inputList )
                {
                    if( translationsDU_EN.get(entry) != null )
                    {
                        translationString += translationsDU_EN.get(entry) + " ";
                    }
                    else
                    {
                        translationString += "NOT_FOUND ";
                    }
                }
            }

            theOutput = "Translation: " + translationString + " Want another? (y/n)";
            state = ANOTHER;
        }
        else if( state == ANOTHER )
        {
            if( theInput.equalsIgnoreCase("y") )
            {
                theOutput = "Type a dutch word that you wanna translate to english";
                state = TRANSLATE;
            }
            else
            {
                theOutput = "Bye.";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
