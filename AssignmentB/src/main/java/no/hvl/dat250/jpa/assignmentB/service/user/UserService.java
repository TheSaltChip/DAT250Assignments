package no.hvl.dat250.jpa.assignmentB.service.user;

import no.hvl.dat250.jpa.assignmentB.api.pojo.RoleString;
import no.hvl.dat250.jpa.assignmentB.models.Poll;
import no.hvl.dat250.jpa.assignmentB.models.Role;
import no.hvl.dat250.jpa.assignmentB.models.User;

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
