package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

class VotingMachine {
    private Map<String, Integer> votes;

    public VotingMachine() {
        votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting system.
     * @param name The name of the candidate.
     */
    public void addCandidate(String name) {
        if (!votes.containsKey(name)) {
            votes.put(name, 0);
        }
    }

    /**
     * Casts a vote for a candidate.
     * @param name The name of the candidate.
     * @return true if the vote was successfully cast, false if the candidate does not exist.
     */
    public boolean castVote(String name) {
        if (votes.containsKey(name)) {
            votes.put(name, votes.get(name) + 1);
            return true;
        }
        return false; // Candidate does not exist
    }

    /**
     * Determines the winner of the election.
     * @return The winner's name along with their vote count.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = 0;
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return (winner != null) ? winner + " WINS with " + maxVotes + " votes!!" : "No votes cast.";
    }
}

// VotingMachineTest class to test VotingMachine
public class VotingMachineTest {
    /**
     * Main method to test the VotingMachine functionality.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success);

        // Displaying results
        System.out.println("Winner: " + vm.getWinner());
    }
}
