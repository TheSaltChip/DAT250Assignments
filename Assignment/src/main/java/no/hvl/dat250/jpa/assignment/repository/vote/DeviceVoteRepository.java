package no.hvl.dat250.jpa.assignment.repository.vote;

import no.hvl.dat250.jpa.assignment.models.vote.DeviceVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DeviceVoteRepository extends JpaRepository<DeviceVote, UUID> {
    List<DeviceVote> findAllByPoll_Id(Long pollId);
}
