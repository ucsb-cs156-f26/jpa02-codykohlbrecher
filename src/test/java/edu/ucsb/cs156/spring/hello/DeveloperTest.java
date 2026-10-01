package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // <https://bit.ly/cs156-f26-teams>
        assertEquals("Cody", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getGithubId_returns_correct_githubId() {
           assertEquals("codykohlbrecher", Developer.getGithubId());
    }
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team team = Developer.getTeam();
            assertEquals("f26-03", team.getName());
    }
    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team team = Developer.getTeam();
        assertTrue(team.getMembers().contains("Brandon K"));
        assertTrue(team.getMembers().contains("Cody"));
        assertTrue(team.getMembers().contains("Declan"));
        assertTrue(team.getMembers().contains("Junxi"));
        assertTrue(team.getMembers().contains("Philip"));
        assertTrue(team.getMembers().contains("Xianze"));
    }

}
