package no.hvl.dat250.jpa.assignmentB.dao.client;

import no.hvl.dat250.jpa.assignmentB.models.User;
import no.hvl.dat250.jpa.assignmentB.models.Poll;
import no.hvl.dat250.jpa.assignmentB.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

public class UserRepositoryImpl implements UserRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByUsername(String username) {
        return em.find(User.class, username);
    }

    @Override
    public User createClient(String username, String password, Role role) {
        User user = new User(username, password, role);
        em.persist(user);
        return user;
    }

    @Override
    public void updateClientFirstname(String username, String firstname) {
        User user = findByUsername(username);
        user.setFirstname(firstname);
        em.merge(user);
    }

    @Override
    public void updateClientLastname(String username, String lastname) {
        User user = findByUsername(username);
        user.setLastname(lastname);
        em.merge(user);
    }

    @Override
    public void updateClientEmail(String username, String email) {
        User user = findByUsername(username);
        user.setEmail(email);
        em.merge(user);
    }

    @Override
    public Set<Poll> getPollsFromClient(String username) {
        User user = findByUsername(username);
        return user.getOwnedPolls();
    }

    @Override
    public void addPollToClient(String username, Poll poll) {
        User user = findByUsername(username);
        Set<Poll> polls = user.getOwnedPolls();
        polls.add(poll);
        user.setOwnedPolls(polls);
        em.merge(user);
    }

    @Override
    public void deleteClient(String username) {
        em.remove(findByUsername(username));
    }

    @Override
    public void changeRole(String username, Role role) {
        User user = findByUsername(username);
        user.setRole(role);
        em.merge(user);
    }

    @Override
    public Role getRoleOfClient(String username) {
        return findByUsername(username).getRole();
    }
}