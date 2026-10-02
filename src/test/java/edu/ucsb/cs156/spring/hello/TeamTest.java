package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("f26-03");
        team.addMember("Brandon K");
        team.addMember("Cody");
        team.addMember("Declan");
        team.addMember("Junxi");
        team.addMember("Philip");
        team.addMember("Xianze");
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("f26-03", team.getName());
    }

    @Test
    public void getMembers_returns_all_members() {
        assertEquals(6, team.getMembers().size());
        assertEquals("Brandon K", team.getMembers().get(0));
        assertEquals("Cody", team.getMembers().get(1));
        assertEquals("Declan", team.getMembers().get(2));
        assertEquals("Junxi", team.getMembers().get(3));
        assertEquals("Philip", team.getMembers().get(4));
        assertEquals("Xianze", team.getMembers().get(5));
    }

    @Test
    public void default_constructor_initializes_fields() {
        Team emptyTeam = new Team();

        assertEquals("", emptyTeam.getName());
        assertEquals(0, emptyTeam.getMembers().size());
    }

    @Test
    public void named_constructor_initializes_fields() {
        Team emptyTeam = new Team("new-team");

        assertEquals("new-team", emptyTeam.getName());
        assertEquals(0, emptyTeam.getMembers().size());
    }

    @Test
    public void addMember_adds_member() {
        Team newTeam = new Team("new-team");
        newTeam.addMember("Cody");

        assertEquals(1, newTeam.getMembers().size());
        assertEquals("Cody", newTeam.getMembers().get(0));
    }

    @Test
    public void setName_updates_name() {
        team.setName("updated-team");

        assertEquals("updated-team", team.getName());
    }

    @Test
    public void setMembers_replaces_members() {
        Team replacement = new Team();
        replacement.addMember("Cody");
        replacement.addMember("Declan");

        team.setMembers(replacement.getMembers());

        assertEquals(2, team.getMembers().size());
        assertEquals("Cody", team.getMembers().get(0));
        assertEquals("Declan", team.getMembers().get(1));
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_for_null() {
        assertEquals(false, team.equals(null));
    }

    @Test
    public void equals_returns_false_for_other_type() {
        assertEquals(false, team.equals("f26-03"));
    }

    @Test
    public void equals_returns_true_for_matching_teams() {
        Team other = new Team("f26-03");
        other.addMember("Brandon K");
        other.addMember("Cody");
        other.addMember("Declan");
        other.addMember("Junxi");
        other.addMember("Philip");
        other.addMember("Xianze");

        assertEquals(true, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_names() {
        Team other = new Team("different-team");
        other.setMembers(team.getMembers());

        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team other = new Team("f26-03");
        other.addMember("Cody");

        assertEquals(false, team.equals(other));
    }

    @Test
    public void toString_returns_correct_representation() {
        assertEquals(
            "Team(name=f26-03, members=[Brandon K, Cody, Declan, Junxi, Philip, Xianze])",
            team.toString()
        );
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team hashTeam = new Team("A");

        // "A".hashCode() = 65; empty member list hashCode = 1.
        // 65 | 1 = 65.
        assertEquals(65, hashTeam.hashCode());
    }
}