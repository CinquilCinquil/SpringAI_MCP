package br.imd.ufrn;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class AnimalTools {

    @Tool(description = "Returns the 'Animal of the Day' of the current weekday.")
    String getAnimalOfTheDay() {
        List<String> animals = Arrays.asList(
            "Dog",
            "Cat",
            "Lion",
            "Dolphin",
            "Elephant",
            "Parrot",
            "Chameleon"
        );

        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        return animals.get(dayOfWeek % animals.size());
    }

    @Tool(description = "Allows user to guess othe 'Animal of the Day' of the current weekday."
     + "Do not tell the user the animal of the day unless asked to.")
    boolean guessAnimalOfTheDay(@ToolParam(description="User's guess") String animal) {
        return getAnimalOfTheDay().toLowerCase().equals(animal.toLowerCase());
    }
}
