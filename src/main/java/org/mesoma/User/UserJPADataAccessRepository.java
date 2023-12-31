package org.mesoma.User;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("UserJPA")
public class UserJPADataAccessRepository implements UserDaoInterface{

    private final UserRepository userRepository;

    public UserJPADataAccessRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void deleteCustomerById(UUID userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public boolean existsPersonWithId(UUID id) {
        return userRepository.existsUserByUserId(id);
    }
}
