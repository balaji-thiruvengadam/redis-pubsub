/**
 * 
 */
package com.example.demo.entiry;

import java.io.Serializable;

import lombok.Data;

/**
 * @author balaj
 *
 */

@Data
public class Joke implements Serializable {

    private static final String JOKE_FORMAT = "Q: %s \nA: %s";

    private String setup;
    private String punchline;

    @Override
    public String toString() {
        return String.format(JOKE_FORMAT, this.setup, this.punchline);
    }
}
