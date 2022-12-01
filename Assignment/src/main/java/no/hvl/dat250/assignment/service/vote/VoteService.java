package no.hvl.dat250.assignment.service.vote;

import no.hvl.dat250.assignment.persistence.models.vote.UserVote;

import java.util.List;

public interface VoteService {
    List<UserVote> getAllVotes();

    List<UserVote> getAllVotesFromPoll(Long pollId);

    List<UserVote> getAllVotesFromUser(String username);

    Boolean hasUserVotedInPoll(String username, Long id);
}