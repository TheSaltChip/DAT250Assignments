package no.hvl.dat250.jpa.assignments.service.user;

import no.hvl.dat250.jpa.assignments.models.Poll;
import no.hvl.dat250.jpa.assignments.models.Role;
import no.hvl.dat250.jpa.assignments.models.User;

import java.util.List;
import java.util.Set;

/**
 * Interface for user services
 *
 * @author Sebastian
 */
public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String username);

    User saveUser(User user);

    User updateUser(String username, User user);

    Set<Poll> getOwnedPollsFromUser(String username);

    Poll addPollToUser(String username, Poll poll);

    void deleteUser(String username);

    User changeRoleOfUser(String username, String role);

    Role getRoleOfUser(String username);
}